package com.the_internet.herokuapp.steps;

import com.the_internet.herokuapp.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static com.the_internet.herokuapp.steps.CommonSteps.driver;

public class HomePageSteps {

    private HomePage page = new HomePage();

    @Given("I have navigated to the 'the-internet' home page")
    public void navigateTo() {
        driver.get(page.PAGE_URL);
    }

    @When("I click on the {string} link")
    public void clickOnPageLink(String link) {
        page.clickOnPageLink(link);
    }

    @Then("a list of the following sub-pages is displayed")
    public void verifyListSubPages(DataTable dt) {
        List<String> subPages = dt.asList();
        assertEquals(subPages.size(), page.getNumSubPages());
        assertEquals(subPages, page.getSubPageNames());
    }

    @Then("the {string} page opens")
    public void verifyPageOpens(String pageName) {
        assertEquals(page.PAGE_URLS.get(pageName), driver.getCurrentUrl());
    }
}
