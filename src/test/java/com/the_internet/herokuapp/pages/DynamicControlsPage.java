package com.the_internet.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class DynamicControlsPage extends BasePage {

    @FindBy(tagName = "p")
    WebElement paragraph;

    @FindBy(className = "subheader")
    List<WebElement> sectionHeaders;

    @FindBy(xpath = "//div[@class=\"example\"]/hr")
    List<WebElement> horizontalRules;

    @FindBy(id = "checkbox-example")
    WebElement checkboxExampleForm;

    @FindBy(id = "input-example")
    WebElement inputExampleForm;

    @FindBy(xpath = "//input[@type=\"text\"]")
    WebElement input;

    @FindBy(id = "checkbox")
    WebElement checkbox;

    @FindBy(id = "loading")
    WebElement loadingBar;

    @FindBy(id = "message")
    WebElement message;

    public DynamicControlsPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    private static final By checkboxLocator = By.xpath("//input[@type=\"checkbox\"]");
    private static final By inputLocator = By.xpath("//input[@type=\"text\"]");
    private static final By buttonLocator = By.tagName("button");
    private static final String buttonByTextXpath = "//button[text()=\"%s\"]";

    private WebElement getSectionForm(String sectionName) {
        return sectionName.equals("Remove/add") ? checkboxExampleForm : inputExampleForm;
    }

    private List<WebElement> getCheckboxesInSection(String sectionName) {
        return getSectionForm(sectionName).findElements(checkboxLocator);
    }

    private List<WebElement> getInputsInSection(String sectionName) {
        return getSectionForm(sectionName).findElements(inputLocator);
    }

    private List<WebElement> getButtonsInSection(String sectionName) {
        return getSectionForm(sectionName).findElements(buttonLocator);
    }

    private WebElement getCheckboxParent() {
        return checkbox.findElement(parentLocator);
    }

    private WebElement getButton(String sectionName) {
        return getSectionForm(sectionName).findElement(buttonLocator);
    }

    private WebElement getButtonByText(String buttonText) {
        return driver.findElement(By.xpath(buttonByTextXpath.replace("%s", buttonText)));
    }

    private WebElement getLoadingBarImg() {
        return loadingBar.findElement(imageLocator);
    }

    public String getOpeningParagraphText() {
        return paragraph.getText();
    }

    public List<String> getSectionHeadersText() {
        List<String> headers = new ArrayList<>();
        for (WebElement sectionHeader : sectionHeaders) {
            headers.add(sectionHeader.getText());
        }
        return headers;
    }

    public int getNumHorizontalRules() {
        return horizontalRules.size();
    }

    public int getNumCheckboxesInSection(String sectionName) {
        return getCheckboxesInSection(sectionName).size();
    }

    public int getNumInputsInSection(String sectionName) {
        return getInputsInSection(sectionName).size();
    }

    public int getNumButtonsInSection(String sectionName) {
        return getButtonsInSection(sectionName).size();
    }

    public String getCheckboxLabel() {
        if (checkbox.getTagName().equals("input")) {
            return getCheckboxParent().getText();
        }
        return checkbox.getText();
    }

    public boolean isCheckboxChecked() {
        return checkbox.getAttribute("checked") != null;
    }

    public String getInputControlText() {
        return input.getText();
    }

    public boolean isInputControlEnabled() {
        return input.isEnabled();
    }

    public String getButtonText(String sectionName) {
        return getButton(sectionName).getText();
    }

    public void clickButtonByText(String buttonText) {
        getButtonByText(buttonText).click();
    }

    public boolean isLoadingBarDisplayed() {
        return loadingBar.isDisplayed();
    }

    public String getLoadingBarLabel() {
        return loadingBar.getText();
    }

    public String getMessageText() {
        return message.getText();
    }

    public void waitForLoadingBarToDisplay() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(getLoadingBarImg()));
    }

    public void waitForLoadingBarToDisappear() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOf(getLoadingBarImg()));
    }
}