package com.the_internet.herokuapp.pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.the_internet.herokuapp.steps.CommonSteps.driver;

public class DynamicControlsPageLocators {

    private static final By contentLocator = By.className("example");
    private static final By paragraphLocator = By.tagName("p");
    private static final By sectionHeaderLocator = By.className("subheader");
    private static final By horizontalRuleLocator = By.tagName("hr");
    private static final By checkboxExampleFormLocator = By.id("checkbox-example");
    private static final By inputExampleFormLocator = By.id("input-example");
    private static final By checkboxLocator = By.xpath("//input[@type=\"checkbox\"]");
    private static final By inputLocator = By.xpath("//input[@type=\"text\"]");
    private static final By buttonLocator = By.tagName("button");
    private static final By alternativeCheckboxLocator = By.id("checkbox");
    public static final By loadingBarLocator = By.id("loading");
    private static final By messageLocator = By.id("message");
    private static final String buttonByTextXpath = "//button[text()=\"%s\"]";

    public static WebElement getParagraph() {
        return driver.findElement(paragraphLocator);
    }

    public static List<WebElement> getSectionHeaders() {
        return driver.findElements(sectionHeaderLocator);
    }

    public static List<WebElement> getHorizontalRules() {
        return driver.findElement(contentLocator).findElements(horizontalRuleLocator);
    }

    public static WebElement getCheckboxExampleForm() {
        return driver.findElement(checkboxExampleFormLocator);
    }

    public static WebElement getInputExampleForm() {
        return driver.findElement(inputExampleFormLocator);
    }

    private static WebElement getSectionForm(String sectionName) {
        return sectionName.equals("Remove/add") ? DynamicControlsPageLocators.getCheckboxExampleForm() : DynamicControlsPageLocators.getInputExampleForm();
    }

    public static List<WebElement> getCheckboxesInSection(String sectionName) {
        WebElement sectionForm = getSectionForm(sectionName);
        return sectionForm.findElements(checkboxLocator);
    }

    public static List<WebElement> getInputsInSection(String sectionName) {
        WebElement sectionForm = getSectionForm(sectionName);
        return sectionForm.findElements(inputLocator);
    }

    public static List<WebElement> getButtonsInSection(String sectionName) {
        WebElement sectionForm = getSectionForm(sectionName);
        return sectionForm.findElements(buttonLocator);
    }

    public static WebElement getCheckbox() {
        return driver.findElement(alternativeCheckboxLocator);
    }

    public static WebElement getCheckboxParent() {
        return getCheckbox().findElement(BaseLocators.parentLocator);
    }

    public static WebElement getInputControl() {
        // This will return the first matching element only. The element could be found within a named form instead
        // (see getButton() below) to avoid potentially getting the wrong element but given the DOM this solution will
        // work well enough
        return driver.findElement(inputLocator);
    }

    public static WebElement getButton(String sectionName) {
        WebElement sectionForm = getSectionForm(sectionName);
        return sectionForm.findElement(buttonLocator);
    }

    public static WebElement getButtonByText(String buttonText) {
        return driver.findElement(By.xpath(buttonByTextXpath.replace("%s", buttonText)));
    }

    public static WebElement getLoadingBar() {
        return driver.findElement(loadingBarLocator);
    }

    public static WebElement getLoadingBarImg() {
        return driver.findElement(loadingBarLocator).findElement(BaseLocators.imageLocator);
    }

    public static WebElement getMessage() {
        return driver.findElement(messageLocator);
    }
}