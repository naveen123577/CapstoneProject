package com.automation.steps;

import com.automation.pages.BusHomePageWeb;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BusHomeSteps {

    BusHomePageWeb busHomePage=new BusHomePageWeb();

    @Given("user opens the website")
    public void user_opens_the_website() {
        busHomePage.openWebsite();
    }

    @Then("verify user is on homepage")
    public void verify_user_is_on_homepage() {
        Assert.assertTrue(busHomePage.verifyUserIsOnHomePage());
    }

    @When("user enter {string} as the source city")
    public void user_enter_as_the_source_city(String travelFrom) {
        busHomePage.enterSourceCity(travelFrom);
    }

    @When("user enter {string} as the destination city")
    public void user_enter_as_the_destination_city(String travelTo) {
        busHomePage.enterDestinationCity(travelTo);
    }

    @When("user select the date of travel as {string}")
    public void user_select_the_date_of_travel_as(String date) {
        busHomePage.selectAData(date);
    }

    @When("user click on the search button")
    public void user_click_on_the_search_button() {
        busHomePage.clickOnSearchButton();
    }

    @And("user scroll down the page")
    public void userScrollDownThePage() throws InterruptedException {
        busHomePage.scrollsToTheBottomOfThePage();
    }

    @Then("verify the Back to Top arrow button appear")
    public void verifyTheBackToTopArrowButtonAppear() {
        Assert.assertTrue(busHomePage.isBackToScrollButtonPresent());
    }

    @When("user click on the Back to Top arrow button")
    public void userClickOnTheBackToTopArrowButton() {
        busHomePage.clickOnBackToScrollButton();
    }

    @Then("verify the page scrolls to the top of the page")
    public void verifyThePageScrollsToTheTopOfThePage() throws InterruptedException {
        Assert.assertTrue(busHomePage.isPageScrollsToTopOfPage());
    }

    @And("verify the Back to Top arrow button is no longer displayed")
    public void verifyTheBackToTopArrowButtonIsNoLongerDisplayed() {
        Assert.assertFalse(busHomePage.isBackToScrollButtonPresent());
    }

    @Then("verify the cities are swapped after clicking the swap button")
    public void verifyTheCitiesAreSwappedAfterClickingTheSwapButton() {
        Assert.assertTrue(busHomePage.isCitiesAreSwapped());
    }

    @When("user navigate to the offers page")
    public void userNavigateToTheOffersPage() {
        busHomePage.clickOnViewAllOffersBtn();
    }

    @When("user clicks on the profile dropdown button")
    public void userClicksOnTheProfileDropdownButton() {
        busHomePage.clickOnProfileDropDownBtn();
    }

    @And("user clicks on the cancel ticket option")
    public void userClicksOnTheCancelTicketOption() {
        busHomePage.clickOnCancelTicket();
    }
}
