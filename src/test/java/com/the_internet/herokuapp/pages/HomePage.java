package com.the_internet.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li")
    List<WebElement> allSubPages;

    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    private List<WebElement> getAllSubPageLinks() {
        List<WebElement> pageLinks = new ArrayList<>();
        for (WebElement page : allSubPages) {
            pageLinks.add(page.findElement(anchorLocator));
        }
        return pageLinks;
    }

    public int getNumSubPages() {
        return allSubPages.size();
    }

    public List<String> getSubPageNames() {
        List<String> subPageNames = new ArrayList<>();
        for (WebElement subPage : allSubPages) {
            // Where a list element includes additional details in brackets e.g. login credentials exclude these from the page name
            subPageNames.add(subPage.getText().split(" \\(")[0]);
        }
        return subPageNames;
    }

    public void clickOnPageLink(String pageName) {
        for (WebElement subPage : getAllSubPageLinks()) {
            if (subPage.getText().startsWith(pageName)) {
                subPage.click();
                break;
            }
        }
    }
}