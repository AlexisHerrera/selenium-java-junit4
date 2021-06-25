package com.the_internet.herokuapp.pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.the_internet.herokuapp.steps.CommonSteps.driver;

public class DropdownPageLocators {

    private static final By dropdownList = By.id("dropdown");
    private static final By genericDropdownList = By.tagName("select");

    public static Select getDropdownList() {
        return new Select(driver.findElement(dropdownList));
    }

    public static List<WebElement> getAllDropdownLists() {
        return driver.findElements(genericDropdownList);
    }
}
