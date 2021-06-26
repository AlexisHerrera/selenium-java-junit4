package com.the_internet.herokuapp.pages;

import java.util.Map;

import static com.the_internet.herokuapp.pages.locators.BaseLocators.*;

public class BasePage {

    public final String BASE_URL = "https://the-internet.herokuapp.com";
    public final Map<String, String> PAGE_URLS = Map.ofEntries(
            Map.entry("home", BASE_URL + "/"),
            Map.entry("checkboxes", BASE_URL + "/checkboxes"),
            Map.entry("dropdown", BASE_URL + "/dropdown"),
            Map.entry("dynamic controls", BASE_URL + "/dynamic_controls"),
            Map.entry("form authentication", BASE_URL + "/login"),
            Map.entry("inputs", BASE_URL + "/inputs"),
            Map.entry("secure area", BASE_URL + "/secure")
    );

    public String getHeaderText() {
        return getHeader1().getText();
    }

    public String getHeader2Text() {
        return getHeader2().getText();
    }

    public String getPageTitleText() {
        // As there is no consistency in terms of the heaading level used for the page titles across the various pages
        // use a nested try-catch block to find the right heading to use as the page title
        try {
            return getHeader2Text();
        } catch (org.openqa.selenium.NoSuchElementException e1) {
            try {
                return getHeader3().getText();
            } catch (org.openqa.selenium.NoSuchElementException e2) {
                try {
                    return getHeader4().getText();
                } catch (org.openqa.selenium.NoSuchElementException e3) {
                    return "No page title element found";
                }
            }
        }
    }
}
