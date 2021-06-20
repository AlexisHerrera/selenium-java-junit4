package com.the_internet.herokuapp.pages;

import java.util.Map;

import static com.the_internet.herokuapp.pages.locators.BaseLocators.getHeader;
import static com.the_internet.herokuapp.pages.locators.BaseLocators.getSubheader;

public class BasePage {

    public final String BASE_URL = "https://the-internet.herokuapp.com";
    public final Map<String, String> PAGE_URLS = Map.ofEntries(
            Map.entry("home", BASE_URL),
            Map.entry("checkboxes", BASE_URL + "/checkboxes"),
            Map.entry("dropdown", BASE_URL + "/dropdown"),
            Map.entry("dynamic controls", BASE_URL + "/dynamic_controls"),
            Map.entry("form authentication", BASE_URL + "/login"),
            Map.entry("inputs", BASE_URL + "/inputs")
    );

    public String getHeaderText() {
        return getHeader().getText();
    }

    public String getSubheaderText() {
        return getSubheader().getText();
    }
}
