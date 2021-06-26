package com.the_internet.herokuapp.pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.the_internet.herokuapp.steps.CommonSteps.driver;

public class FormAuthenticationPageLocators {

    private static final By openingParagraphLocator = By.className("subheader");
    private static final By usernameInputLocator = By.id("username");
    private static final By passwordInputLocator = By.id("password");
    private static final By inputLabelLocator = By.xpath("./../label");
    private static final By loginButtonLocator = By.xpath("//button[@type=\"submit\"]");
    private static final By messageBannerLocator = By.id("flash");
    private static final By logoutButtonLocator = By.className("button");

    public static WebElement getOpeningParagraph() {
        return driver.findElement(openingParagraphLocator);
    }

    public static WebElement getUsernameInput() {
        return driver.findElement(usernameInputLocator);
    }

    public static WebElement getUsernameInputLabel() {
        return getUsernameInput().findElement(inputLabelLocator);
    }

    public static WebElement getPasswordInput() {
        return driver.findElement(passwordInputLocator);
    }

    public static WebElement getPasswordInputLabel() {
        return getPasswordInput().findElement(inputLabelLocator);
    }

    public static WebElement getLoginButton() {
        return driver.findElement(loginButtonLocator);
    }

    public static WebElement getMessageBanner() {
        return driver.findElement(messageBannerLocator);
    }

    public static WebElement getLogoutButton() {
        return driver.findElement(logoutButtonLocator);
    }
}