package com.the_internet.herokuapp.pages;

import com.the_internet.herokuapp.pages.locators.FormAuthenticationPageLocators;

public class FormAuthenticationPage extends BasePage {

    public String getOpeningParagraphText() {
        return FormAuthenticationPageLocators.getOpeningParagraph().getText();
    }

    public boolean isUsernameInputDisplayed() {
        return FormAuthenticationPageLocators.getUsernameInput().isDisplayed();
    }

    public String getUsernameInputLabelText() {
        return FormAuthenticationPageLocators.getUsernameInputLabel().getText();
    }

    public boolean isPasswordInputDisplayed() {
        return FormAuthenticationPageLocators.getPasswordInput().isDisplayed();
    }

    public String getPasswordInputLabelText() {
        return FormAuthenticationPageLocators.getPasswordInputLabel().getText();
    }

    public boolean isLoginButtonDisplayed() {
        return FormAuthenticationPageLocators.getLoginButton().isDisplayed();
    }

    public String getLoginButtonText() {
        return FormAuthenticationPageLocators.getLoginButton().getText();
    }

    public void clickLoginButton() {
        FormAuthenticationPageLocators.getLoginButton().click();
    }

    public boolean isMessageBannerDisplayed() {
        return FormAuthenticationPageLocators.getMessageBanner().isDisplayed();
    }

    public String getMessageBannerColour() {
        return FormAuthenticationPageLocators.getMessageBanner().getCssValue("background-color");
    }

    public String getMessageBannerText() {
        // This includes the 'x' to close the message so need to strip that off
        String fullMessage = FormAuthenticationPageLocators.getMessageBanner().getText();
        return fullMessage.split("\n")[0];
    }

    public void enterUsername(String username) {
        FormAuthenticationPageLocators.getUsernameInput().sendKeys(username);
    }

    public void enterPassword(String password) {
        FormAuthenticationPageLocators.getPasswordInput().sendKeys(password);
    }

    public boolean isLogoutButtonDisplayed() {
        return FormAuthenticationPageLocators.getLogoutButton().isDisplayed();
    }

    public String getLogoutButtonText() {
        return FormAuthenticationPageLocators.getLogoutButton().getText();
    }
}