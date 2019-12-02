package com.zee.test;

import com.zee.servlets.web.viewmodels.UserVM;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MoKayed
 */

public class Teest {
    WebDriver driver;
    String userName;
    String password;
    int agencyNumber;
    int id;
    String isUser;

    @Given("^the user (.*?)$")
    public void getUserName(String userName) throws ParseException {
        this.userName = userName;
    }

    @Given("^the password (.*?)$")
    public void getPassword(String password) throws ParseException {
        this.password = password;
    }

    @Given("^the agencyNumber (.*?)$")
    public void getAgencyNumber(int agencyNumber) throws ParseException {
        this.agencyNumber = agencyNumber;
    }

    @When("^logs in$")
    public void startWebDriver () throws InterruptedException {
        UserVM userVM =new UserVM(id,agencyNumber,userName, password);
        if (System.getProperty("os.name").startsWith("Linux")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver_78");
            driver = new ChromeDriver();
        } else if (System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.get("http://localhost:8080/LSD-frontend/");
        WebDriverWait wait = new WebDriverWait(driver, 120);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));
        WebElement user = driver.findElement(By.id("user"));
        user.sendKeys(userVM.getUserName());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(userVM.getPassword());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agency")));
        WebElement agencyNr = driver.findElement(By.id("agency"));
        agencyNr.sendKeys("62");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        WebElement login = driver.findElement(By.id("login"));
        login.click();
        isUser = driver.findElement(By.id("userSession")).getText();
        Thread.sleep(1000);
    }

    @Then("the session should be (.*?)")
    public void pageHeader(String header) {
        assertThat(header, is(isUser));
        driver.close();
    }

}
