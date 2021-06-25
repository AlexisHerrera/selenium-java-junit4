package com.the_internet.herokuapp.pages;

import com.the_internet.herokuapp.pages.locators.DropdownPageLocators;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropdownPage extends BasePage {

    public int getNumDropdownLists() {
        return DropdownPageLocators.getAllDropdownLists().size();
    }

    public String getCurrentDropdownValue() {
        return DropdownPageLocators.getDropdownList().getFirstSelectedOption().getText();
    }

    public List<String> getAllDropdownOptions() {
        List<String> options = new ArrayList<>();
        for (WebElement option : DropdownPageLocators.getDropdownList().getOptions()) {
            options.add(option.getText());
        }
        return options;
    }

    public boolean getDropdownMultiSelectionSupported() {
        return DropdownPageLocators.getDropdownList().getWrappedElement().getAttribute("multiple") != null;
    }

    public void selectDropdownOption(String option) {
        DropdownPageLocators.getDropdownList().selectByVisibleText(option);
    }

    public void selectDropdownOption(int index) {
        DropdownPageLocators.getDropdownList().selectByIndex(index);
    }
}
