package com.the_internet.herokuapp.pages;

import static com.the_internet.herokuapp.pages.locators.BasePageLocators.*;

public class BasePage {

    public static final String BASE_URL = "https://the-internet.herokuapp.com";

    public static String getHeaderText() {
        return getPageHeader().getText();
    }
}
