package com.the_internet.herokuapp.pages;

import static com.the_internet.herokuapp.pages.locators.BaseLocators.getHeader;
import static com.the_internet.herokuapp.pages.locators.BaseLocators.getSubheader;

public class BasePage {

    public String getHeaderText() {
        return getHeader().getText();
    }

    public String getSubheaderText() {
        return getSubheader().getText();
    }
}
