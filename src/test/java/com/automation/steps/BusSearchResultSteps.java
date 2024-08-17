package com.automation.steps;

import com.automation.pages.BusSearchResultPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class BusSearchResultSteps {

    BusSearchResultPage busSearchResultPage = new BusSearchResultPage();

    @Then("verify the list of buses are displayed")
    public void verifyTheListOfBusesAreDisplayed() {
        Assert.assertTrue(busSearchResultPage.isSearchResultFound());
    }
}
