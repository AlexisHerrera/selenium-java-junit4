package com.the_internet.herokuapp.pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.the_internet.herokuapp.steps.CommonSteps.driver;

public class BaseLocators {

    private static final By header1Locator = By.tagName("h1");
    private static final By header2Locator = By.tagName("h2");

    public static WebElement getHeader() {
        return driver.findElement(header1Locator);
    }

    public static WebElement getSubheader() {
        return driver.findElement(header2Locator);
    }

}
