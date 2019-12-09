package com.zee.test;
import com.zee.servlets.backendconnector.BackendConnectable;
import com.zee.servlets.backendconnector.BackendConnector;
import com.zee.servlets.backendconnector.DTOConvert;
import com.zee.servlets.backendconnector.UnknownBackendException;
import com.zee.servlets.web.viewmodels.OffersPageVM;
import com.zee.servlets.web.viewmodels.UserVM;
import contract.dto.FlightOffer;
import contract.interfaces.BeanInterface;
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
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;


public class SearchFlightSelenium {
    private BeanInterface endpoint;
    WebDriver driver;
    BackendConnector bc;
    UserVM user;
    String fromAirport;
    String toAirpot;
    String fromDate;
    String toDate;


    @Given("^the fromAirport (.*?)$")
    public void getfromAirport(String fromAirport) throws ParseException {
        this.fromAirport = fromAirport;
    }

    @Given("^the toAirport (.*?)$")
    public void gettoAirpot(String toAirpot) throws ParseException {
        this.toAirpot = toAirpot;
    }

    @Given("^the fromDate (.*?)$")
    public void getfromDate(String fromDate) throws ParseException {
        this.fromDate = fromDate;
    }

    @Given("^the toDate (.*?)$")
    public void gettoDate(String toDate) throws ParseException {
        this.toDate = toDate;
    }


    @When("^flightSearch$")
    public void startWebDriver () throws InterruptedException {
        if (System.getProperty("os.name").startsWith("Linux")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver_78");
            driver = new ChromeDriver();
        } else if (System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.get("http://localhost:8080/LSD-frontend/searchFlight.jsp");
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromAirport")));
        WebElement depAirport = driver.findElement(By.id("fromAirport"));
        depAirport.sendKeys(fromAirport);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toAirport")));
        WebElement arrAirport = driver.findElement(By.id("toAirport"));
        arrAirport.sendKeys(toAirpot);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("depDate")));
        WebElement depDate = driver.findElement(By.name("depDate"));
        depDate.sendKeys(fromDate);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("retDate")));
        WebElement retDate = driver.findElement(By.name("retDate"));
        retDate.sendKeys(toDate);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchFlight")));
        WebElement searchFlight = driver.findElement(By.id("searchFlight"));
        Thread.sleep(1000);

        searchFlight.click();
        Thread.sleep(1000);
    }

    @Then("the searchOutput should be (.*?)")
    public void pageHeader(String header) {
        driver.close();
    }

}
