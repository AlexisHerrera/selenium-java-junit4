package com.the_internet.herokuapp.pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.the_internet.herokuapp.steps.CommonSteps.driver;

public class BasePageLocators {

    private static final By header1Locator = By.tagName("h1");

    public static WebElement getPageHeader() {
        return driver.findElement(header1Locator);
    }
}
