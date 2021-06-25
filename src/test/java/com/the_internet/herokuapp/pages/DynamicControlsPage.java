package com.the_internet.herokuapp.pages;

import com.the_internet.herokuapp.pages.locators.DynamicControlsLocators;
import com.the_internet.herokuapp.steps.CommonSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class DynamicControlsPage extends BasePage {

    public String getOpeningParagraphText() {
        return DynamicControlsLocators.getParagraph().getText();
    }

    public List<String> getSectionHeadersText() {
        List<String> headers = new ArrayList<>();
        for (WebElement sectionHeader : DynamicControlsLocators.getSectionHeaders()) {
            headers.add(sectionHeader.getText());
        }
        return headers;
    }

    public int getNumHorizontalRules() {
        return DynamicControlsLocators.getHorizontalRules().size();
    }

    public int getNumCheckboxesInSection(String sectionName) {
        return DynamicControlsLocators.getCheckboxesInSection(sectionName).size();
    }

    public int getNumInputsInSection(String sectionName) {
        return DynamicControlsLocators.getInputsInSection(sectionName).size();
    }

    public int getNumButtonsInSection(String sectionName) {
        return DynamicControlsLocators.getButtonsInSection(sectionName).size();
    }

    public String getCheckboxLabel() {
        if (DynamicControlsLocators.getCheckbox().getTagName().equals("input")) {
            return DynamicControlsLocators.getCheckboxParent().getText();
        }
        return DynamicControlsLocators.getCheckbox().getText();
    }

    public boolean isCheckboxChecked() {
        return DynamicControlsLocators.getCheckbox().getAttribute("checked") != null;
    }

    public String getInputControlText() {
        return DynamicControlsLocators.getInputControl().getText();
    }

    public boolean isInputControlEnabled() {
        return DynamicControlsLocators.getInputControl().isEnabled();
    }

    public String getButtonText(String sectionName) {
        return DynamicControlsLocators.getButton(sectionName).getText();
    }

    public void clickButtonByText(String buttonText) {
        DynamicControlsLocators.getButtonByText(buttonText).click();
    }

    public boolean isLoadingBarDisplayed() {
        return DynamicControlsLocators.getLoadingBar().isDisplayed();
    }

    public String getLoadingBarLabel() {
        return DynamicControlsLocators.getLoadingBar().getText();
    }

    public String getMessageText() {
        return DynamicControlsLocators.getMessage().getText();
    }

    public void waitForLoadingBarToDisplay() {
        new WebDriverWait(CommonSteps.driver, 10).until(ExpectedConditions.visibilityOf(DynamicControlsLocators.getLoadingBarImg()));
    }

    public void waitForLoadingBarToDisappear() {
        new WebDriverWait(CommonSteps.driver, 10).until(ExpectedConditions.invisibilityOf(DynamicControlsLocators.getLoadingBarImg()));
    }
}