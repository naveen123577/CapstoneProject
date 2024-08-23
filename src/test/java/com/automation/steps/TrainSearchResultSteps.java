package com.automation.steps;

import com.automation.pages.TrainHomePage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class TrainSearchResultSteps {

    TrainHomePage trainHomePage=new TrainHomePage();


    @Then("verify user see results for the same")
    public void verify_user_see_results_for_the_same() {
        Assert.assertTrue(trainHomePage.verifyResultsForTrain());

    }
    @Then("verify {string} message is displayed")
    public void verifyMessageIsDisplayed(String msg) throws InterruptedException {
        String popup=trainHomePage.getPopupMessage();
        Assert.assertEquals(msg,popup);
    }

    @Then("verify status of the train is displayed")
    public void verifyStatusOfTheTrainIsDisplayed() {
        Assert.assertTrue(trainHomePage.verifyStatusOfTrain());
    }

    @Then("verify source and destination have been swapped after clicking the swap button")
    public void verifySourceAndDestinationHaveBeenSwappedAfterClickingTheSwapButton() {
        Assert.assertTrue(trainHomePage.verifySwapButton());
    }
}
