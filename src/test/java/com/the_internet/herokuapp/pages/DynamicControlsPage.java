package com.the_internet.herokuapp.pages;

import com.the_internet.herokuapp.pages.locators.DynamicControlsPageLocators;
import com.the_internet.herokuapp.steps.CommonSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class DynamicControlsPage extends BasePage {

    public String getOpeningParagraphText() {
        return DynamicControlsPageLocators.getParagraph().getText();
    }

    public List<String> getSectionHeadersText() {
        List<String> headers = new ArrayList<>();
        for (WebElement sectionHeader : DynamicControlsPageLocators.getSectionHeaders()) {
            headers.add(sectionHeader.getText());
        }
        return headers;
    }

    public int getNumHorizontalRules() {
        return DynamicControlsPageLocators.getHorizontalRules().size();
    }

    public int getNumCheckboxesInSection(String sectionName) {
        return DynamicControlsPageLocators.getCheckboxesInSection(sectionName).size();
    }

    public int getNumInputsInSection(String sectionName) {
        return DynamicControlsPageLocators.getInputsInSection(sectionName).size();
    }

    public int getNumButtonsInSection(String sectionName) {
        return DynamicControlsPageLocators.getButtonsInSection(sectionName).size();
    }

    public String getCheckboxLabel() {
        if (DynamicControlsPageLocators.getCheckbox().getTagName().equals("input")) {
            return DynamicControlsPageLocators.getCheckboxParent().getText();
        }
        return DynamicControlsPageLocators.getCheckbox().getText();
    }

    public boolean isCheckboxChecked() {
        return DynamicControlsPageLocators.getCheckbox().getAttribute("checked") != null;
    }

    public String getInputControlText() {
        return DynamicControlsPageLocators.getInputControl().getText();
    }

    public boolean isInputControlEnabled() {
        return DynamicControlsPageLocators.getInputControl().isEnabled();
    }

    public String getButtonText(String sectionName) {
        return DynamicControlsPageLocators.getButton(sectionName).getText();
    }

    public void clickButtonByText(String buttonText) {
        DynamicControlsPageLocators.getButtonByText(buttonText).click();
    }

    public boolean isLoadingBarDisplayed() {
        return DynamicControlsPageLocators.getLoadingBar().isDisplayed();
    }

    public String getLoadingBarLabel() {
        return DynamicControlsPageLocators.getLoadingBar().getText();
    }

    public String getMessageText() {
        return DynamicControlsPageLocators.getMessage().getText();
    }

    public void waitForLoadingBarToDisplay() {
        new WebDriverWait(CommonSteps.driver, 10).until(ExpectedConditions.visibilityOf(DynamicControlsPageLocators.getLoadingBarImg()));
    }

    public void waitForLoadingBarToDisappear() {
        new WebDriverWait(CommonSteps.driver, 10).until(ExpectedConditions.invisibilityOf(DynamicControlsPageLocators.getLoadingBarImg()));
    }
}