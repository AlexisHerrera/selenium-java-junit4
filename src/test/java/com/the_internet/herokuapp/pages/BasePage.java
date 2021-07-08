package com.the_internet.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public abstract class BasePage {

    public static WebDriver driver;

    public static final String BASE_URL = "https://the-internet.herokuapp.com";

    public static final Map<String, String> PAGE_URLS = Map.ofEntries(
            Map.entry("home", BASE_URL + "/"),
            Map.entry("checkboxes", BASE_URL + "/checkboxes"),
            Map.entry("dropdown", BASE_URL + "/dropdown"),
            Map.entry("dynamic controls", BASE_URL + "/dynamic_controls"),
            Map.entry("form authentication", BASE_URL + "/login"),
            Map.entry("inputs", BASE_URL + "/inputs"),
            Map.entry("secure area", BASE_URL + "/secure")
    );
    protected static final By listElementLocator = By.tagName("li");
    protected static final By anchorLocator = By.tagName("a");
    protected static final By imageLocator = By.tagName("img");
    protected static final By parentLocator = By.xpath("./..");
    private static final By header1Locator = By.tagName("h1");
    private static final By header2Locator = By.tagName("h2");
    private static final By header3Locator = By.tagName("h3");
    private static final By header4Locator = By.tagName("h4");
    private static final By forkLinkLocator = By.xpath("/html/body/div[2]/a");
    private static final By footerLocator = By.id("page-footer");

    public static String getHeaderText() {
        return driver.findElement(header1Locator).getText();
    }

    public static String getHeader2Text() {
        return driver.findElement(header2Locator).getText();
    }

    private static String getHeader3Text() {
        return driver.findElement(header3Locator).getText();
    }

    private static String getHeader4Text() {
        return driver.findElement(header4Locator).getText();
    }

    private static WebElement getGitHubForkLink() {
        return driver.findElement(forkLinkLocator);
    }

    private static WebElement getPageFooter() {
        return driver.findElement(footerLocator);
    }

    public abstract String getPageTitleText();

    public static String getGitHubForkText() {
        return getGitHubForkLink().findElement(imageLocator).getAttribute("alt");
    }

    public static String getGitHubForkLinkUrl() {
        return getGitHubForkLink().getAttribute("href");
    }

    public static String getGitHubForkImagePosition() {
        return getGitHubForkLink().findElement(imageLocator).getAttribute("style");
    }

    public static String getPageFooterText() {
        return getPageFooter().getText();
    }

    public static String getPageFooterLinkUrl() {
        return getPageFooter().findElement(anchorLocator).getAttribute("href");
    }
}
