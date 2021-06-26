package com.the_internet.herokuapp.steps;

import com.the_internet.herokuapp.DriverManager;
import com.the_internet.herokuapp.pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class CommonSteps {

    public static WebDriver driver;
    private final BasePage basePage = new BasePage();

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
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
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    @Given("I have navigated to the 'the-internet' {string} page")
    public void navigateTo(String pageName) {
        String url = basePage.PAGE_URLS.get(pageName.toLowerCase());
        driver.get(url);
        new WebDriverWait(driver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        assertEquals(url, driver.getCurrentUrl());
    }

    @Then("the header text is {string}")
    public void verifyHeaderText(String expectedText) {
        String actual = basePage.getHeaderText();
        assertEquals(expectedText, actual);
    }

    @Then("the sub-header text is {string}")
    public void verifySubheaderText(String expectedText) {
        String actual = basePage.getHeader2Text();
        assertEquals(expectedText, actual);
    }

    @Then("the page title is {string}")
    public void verifyPageTitle(String expectedText) {
        String actual = basePage.getPageTitleText();
        assertEquals(expectedText, actual);
    }

    @Then("the {string} page opens")
    public void verifyPageOpens(String pageName) {
        assertEquals(basePage.PAGE_URLS.get(pageName.toLowerCase()), driver.getCurrentUrl());
    }

    @Then("a {string} banner is displayed in the top-right corner of the page")
    public void verifyGitHubForkBanner(String expectedText) {
        final String expectedUrl = "https://github.com/tourdedave/the-internet";
        String actualText = basePage.getGitHubForkText();
        assertEquals(expectedText, actualText);
        assertEquals(expectedUrl, basePage.getGitHubForkLinkUrl());
        String[] styleAttrs = basePage.getGitHubForkImagePosition().split(";");
        for (String attr : styleAttrs) {
            if (attr.startsWith("position")) assertEquals("absolute", attr.split(": ")[1]);
            if (attr.startsWith("top")) assertEquals("0px", attr.split(": ")[1]);
            if (attr.startsWith("right")) assertEquals("0px", attr.split(": ")[1]);
            if (attr.startsWith("border")) assertEquals("0px", attr.split(": ")[1]);
        }
    }

    @Then("the page has a footer containing {string}")
    public void verifyPageFooterText(String expectedText) {
        String actual = basePage.getPageFooterText();
        assertEquals(expectedText,actual);
    }

    @Then("the link in the page footer goes to {string}")
    public void verifyPageFooterLinkUrl(String expectedUrl) {
        String actual = basePage.getPageFooterLinkUrl();
        assertEquals(expectedUrl, actual);
    }

}
