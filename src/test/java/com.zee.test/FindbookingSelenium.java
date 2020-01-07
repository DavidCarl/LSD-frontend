package com.zee.test;

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

public class FindbookingSelenium {
    WebDriver driver;
    String pnr;

    @Given("^the pnr (.*?)$")
    public void getfromAirport(String pnr) throws ParseException {
        this.pnr = pnr;
    }

    @When("^getBooking$")
    public void startWebDriver () throws InterruptedException {
        if (System.getProperty("os.name").startsWith("Linux")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver_78");
            driver = new ChromeDriver();
        } else if (System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.get("http://localhost:8080/LSD-frontend/home.jsp");
        WebDriverWait wait = new WebDriverWait(driver, 120);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pnr")));
        WebElement depAirport = driver.findElement(By.name("pnr"));
        depAirport.sendKeys(pnr);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBooking")));
        WebElement searchFlight = driver.findElement(By.id("searchBooking"));
        Thread.sleep(1000);

        searchFlight.click();
        Thread.sleep(1000);
    }

    @Then("the bookingOutput should be (.*?)")
    public void pageHeader(String header) {
        driver.close();
    }
}
