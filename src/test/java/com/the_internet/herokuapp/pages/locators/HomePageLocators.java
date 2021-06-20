package com.the_internet.herokuapp.pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.the_internet.herokuapp.steps.CommonSteps.driver;

public class HomePageLocators {

    private static final By subPageList = By.xpath("//*[@id=\"content\"]/ul");
    private static final By subPageListElement = By.tagName("li");

    public static WebElement getSubPageList() {
        return driver.findElement(subPageList);
    }

    public static List<WebElement> getAllSubPageListElements() {
        return getSubPageList().findElements(subPageListElement);
    }
}
