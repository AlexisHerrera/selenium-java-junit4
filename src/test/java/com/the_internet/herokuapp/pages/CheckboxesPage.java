package com.the_internet.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class CheckboxesPage extends BasePage {

    private static final By pageTitleLocator = By.tagName("h3");
    private static final By checkboxesFormLocator = By.id("checkboxes");
    private static final By checkboxLocator = By.tagName("input");

    private WebElement getPageTitle() {
        return driver.findElement(pageTitleLocator);
    }

    private WebElement getCheckboxesForm() {
        return driver.findElement(checkboxesFormLocator);
    }

    private List<WebElement> getAllCheckboxes() {
        return getCheckboxesForm().findElements(checkboxLocator);
    }

    @Override
    public String getPageTitleText() {
        return getPageTitle().getText();
    }

    public int getNumCheckboxes() {
        return getAllCheckboxes().size();
    }

    public List<String> getAllCheckboxLabels() {
        String[] checkboxLabels = getCheckboxesForm().getText().split("\n");
        return Arrays.asList(checkboxLabels.clone());
    }

    public boolean getCheckboxCheckedState(int index) {
        List<WebElement> checkboxes = getAllCheckboxes();
        return checkboxes.get(index).getAttribute("checked") != null;
    }

    public void clickOnCheckbox(int index) {
        List<WebElement> checkboxes = getAllCheckboxes();
        checkboxes.get(index).click();
    }
}
