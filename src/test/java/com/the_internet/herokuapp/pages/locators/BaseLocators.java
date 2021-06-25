package com.the_internet.herokuapp.pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.the_internet.herokuapp.steps.CommonSteps.driver;

public class BaseLocators {

    protected static final By header1Locator = By.tagName("h1");
    protected static final By header2Locator = By.tagName("h2");
    protected static final By header3Locator = By.tagName("h3");
    private static final By header4Locator = By.tagName("h4");
    protected static final By listElementLocator = By.tagName("li");
    protected static final By anchorLocator = By.tagName("a");
    public static final By imageLocator = By.tagName("img");
    public static final By parentLocator = By.xpath("./..");

    public static WebElement getHeader() {
        return driver.findElement(header1Locator);
    }

    public static WebElement getSubheader() {
        return driver.findElement(header2Locator);
    }

    public static WebElement getHeader3() {
        return driver.findElement(header3Locator);
    }

    public static WebElement getHeader4() {
        return driver.findElement(header4Locator);
    }

}
