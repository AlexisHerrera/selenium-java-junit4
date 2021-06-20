package com.the_internet.herokuapp.pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.the_internet.herokuapp.steps.CommonSteps.driver;

public class CheckboxesPageLocators {

    private static final By checkboxesForm = By.id("checkboxes");
    private static final By checkbox = By.tagName("input");
    private static final By checkboxLabel = By.xpath("text()");

    public static WebElement getCheckboxesForm() {
        return driver.findElement(checkboxesForm);
    }

    public static List<WebElement> getAllCheckboxes() {
        return getCheckboxesForm().findElements(checkbox);
    }

    public static List<WebElement> getAllCheckboxLabels() {
        return getCheckboxesForm().findElements(checkboxLabel);
    }
}
