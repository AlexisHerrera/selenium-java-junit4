package com.the_internet.herokuapp.pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.the_internet.herokuapp.steps.CommonSteps.driver;

public class HomePageLocators extends BaseLocators {

    private static final By subPageList = By.xpath("//*[@id=\"content\"]/ul");

    public static WebElement getSubPageList() {
        return driver.findElement(subPageList);
    }

    public static List<WebElement> getAllSubPageListElements() {
        return getSubPageList().findElements(listElement);
    }

    public static List<WebElement> getAllSubPageLinks() {
        List<WebElement> pageList = getAllSubPageListElements();
        List<WebElement> pageLinks = new ArrayList<>();
        for (WebElement page: pageList) {
            pageLinks.add(page.findElement(anchor));
        }
        return pageLinks;
    }
}
