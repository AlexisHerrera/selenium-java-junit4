package com.the_internet.herokuapp.steps;

import com.the_internet.herokuapp.DriverManager;
import com.the_internet.herokuapp.pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class CommonSteps {

    public static WebDriver driver;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get(BasePage.BASE_URL);
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        driver.quit();
    }

    @Given("I have navigated to {string}")
    public void navigateTo(String url) {
        driver.get(url);
    }

    @Then("the H1 header text is {string}")
    public void verifyHeaderText(String expectedText) {
        String actual = BasePage.getHeaderText();
        assertEquals(expectedText, actual);
    }
}
