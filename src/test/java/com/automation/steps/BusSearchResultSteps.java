package com.automation.steps;

import com.automation.pages.BusSearchResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BusSearchResultSteps {

    BusSearchResultPage busSearchResultPage = new BusSearchResultPage();

    @Then("verify the list of buses are displayed")
    public void verifyTheListOfBusesAreDisplayed() {
        Assert.assertTrue(busSearchResultPage.isSearchResultFound());
    }

    @When("user selects Sleeper from the bus type filter")
    public void userSelectsSleeperFromTheBusTypeFilter() {
        busSearchResultPage.clickOnSleeperCheckBox();
    }

    @Then("verify that sleeper buses are only displayed in the listing page")
    public void verifyThatSleeperBusesAreOnlyDisplayedInTheListingPage() {
        Assert.assertTrue(busSearchResultPage.isSleeperBusResultsDisplayed());
    }

    @When("user selects AC from the bus type filter")
    public void userSelectsACFromTheBusTypeFilter() {
        busSearchResultPage.clickOnAcCheckBox();
    }

    @Then("verify that AC buses are only displayed in the listing page")
    public void verifyThatACBusesAreOnlyDisplayedInTheListingPage() {
        Assert.assertTrue(busSearchResultPage.isAcBusResultsDisplayed());
    }

    @When("user selects NonAC from the bus type filter")
    public void userSelectsNonACFromTheBusTypeFilter() {
        busSearchResultPage.clickOnNonAcCheckBox();
    }

    @Then("verify that NonAC buses are only displayed in the listing page")
    public void verifyThatNonACBusesAreOnlyDisplayedInTheListingPage() {
        Assert.assertTrue(busSearchResultPage.isNonAcBusResultsDisplayed());
    }

    @And("user clicks on the Clear All Filters button")
    public void userClicksOnTheClearAllFiltersButton() throws InterruptedException {
        busSearchResultPage.clickOnClearAllFilterBtn();
    }

    @Then("verify the full list of buses are displayed")
    public void verifyTheFullListOfBusesAreDisplayed() throws InterruptedException {
        Assert.assertTrue(busSearchResultPage.isFullListOfBusesAreDisplayed());
    }

    @And("verify clear all filters button is not present")
    public void verifyClearAllFiltersButtonIsNotPresent() {
        Assert.assertFalse(busSearchResultPage.isClearAllFilterBtnDisplayed());
    }

    @When("user clicks on the boarding & dropping points of first bus")
    public void userClicksOnTheBoardingDroppingPointsOfFirstBus() {
        busSearchResultPage.clickOnBoardingAndDroppingPointsButton();
    }

    @Then("verify the boarding and dropping details are displayed")
    public void verifyTheBoardingAndDroppingDetailsAreDisplayed() {
        Assert.assertTrue(busSearchResultPage.isBoardingAndDroppingPointsDisplayed());
    }

    @And("user clicks on an empty seat")
    public void userClicksOnAnEmptySeat() throws InterruptedException {
        busSearchResultPage.clickOnEmptySeat();
    }

    @When("user clicks on the view seats button")
    public void userClicksOnTheViewSeatsButton() {
        busSearchResultPage.clickOnViewSeat();
    }

    @Then("verify the boarding and dropping details list are not null")
    public void verifyTheBoardingAndDroppingDetailsListAreNotNull() {
        Assert.assertTrue(busSearchResultPage.isBoardingAndDroppingDetailsListPresent());
    }

    @Then("verify the seat page is displayed")
    public void verifyTheSeatPageIsDisplayed() {
        Assert.assertTrue(busSearchResultPage.isSeatsAreVisible());
    }

    @When("user clicks on the hide seat button")
    public void userClicksOnTheHideSeatButton() {
        busSearchResultPage.clickOnHideSeatsButton();
    }

    @Then("verify the seats are not visible")
    public void verifyTheSeatsAreNotVisible() {
        Assert.assertFalse(busSearchResultPage.isSeatsAreVisible());
    }

    @And("store the price in the listing page of first bus")
    public void storeThePriceInTheListingPageOfFirstBus() {
        busSearchResultPage.storeFirstBusPriceOfListingPage();
    }

    @Then("verify the price in the boarding and dropping section is greater than the price in listing page")
    public void verifyThePriceInTheBoardingAndDroppingSectionIsGreaterThanThePriceInListingPage() {
        Assert.assertTrue(busSearchResultPage.isPriceOfListingPageAndBoardingDroppingPageSame());
    }
}
