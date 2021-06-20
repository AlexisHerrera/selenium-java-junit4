package com.the_internet.herokuapp.pages;

import com.the_internet.herokuapp.pages.locators.CheckboxesPageLocators;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class CheckboxesPage extends BasePage {

    public int getNumCheckboxes() {
        return CheckboxesPageLocators.getAllCheckboxes().size();
    }

    public List<String> getAllCheckboxLabels() {
        String[] checkboxLabels = CheckboxesPageLocators.getCheckboxesForm().getText().split("\n");
        return Arrays.asList(checkboxLabels.clone());
    }

    public boolean getCheckboxCheckedState(int index) {
        List<WebElement> checkboxes = CheckboxesPageLocators.getAllCheckboxes();
        return checkboxes.get(index).getAttribute("checked") != null;
    }

    public void clickOnCheckbox(int index) {
        List<WebElement> checkboxes = CheckboxesPageLocators.getAllCheckboxes();
        checkboxes.get(index).click();
    }

}
