package com.automation.steps;

import com.automation.pages.TrainHomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TrainHomeSteps {

    String cityDest;
    TrainHomePage trainHomePage=new TrainHomePage();
    @When("user clicks on the Train Tickets option")
    public void user_clicks_on_the_train_tickets_option() {
        trainHomePage.clickTrainTicket();
    }

    @When("chooses from location")
    public void chooses_from_location() throws InterruptedException {
        trainHomePage.enterSourceCity(ConfigReader.getConfigValue("train.TravelFrom"));
    }

    @When("chooses to location")
    public void chooses_to_location() throws InterruptedException {
        trainHomePage.enterDestinationCity(ConfigReader.getConfigValue("train.TravelTo"));

    }

    @When("user clicks the Search Train Button")
    public void user_clicks_the_search_train_button() {
        trainHomePage.clickSearchButton();
    }



    @And("picks a date")
    public void picksADate(){
        trainHomePage.pickADate(ConfigReader.getConfigValue("train.travelDate"));
    }



    @And("chooses Source destination")
    public void choosesSourceDestination() throws InterruptedException {
        trainHomePage.enterSourceCity(ConfigReader.getConfigValue("train.TravelFrom"));
    }

    @And("chooses To Destination")
    public void choosesToDestination() throws InterruptedException {
        trainHomePage.enterDestinationCity(ConfigReader.getConfigValue("train.TravelFrom"));
    }




    @And("clicks the Live train Status Option")
    public void clicksTheLiveTrainStatusOption() {
        trainHomePage.clickLiveTrainStatus();
    }

    @And("enters {string} in the search bar")
    public void entersInTheSearchBar(String trainNo) throws InterruptedException {
        trainHomePage.enterTrainNumber(trainNo);
    }

    @When("user clicks the check status button")
    public void userClicksTheCheckStatusButton() throws InterruptedException {
        trainHomePage.clickCheckStatus();
    }

    @And("chooses a date {string}")
    public void choosesADate(String distantDate) {
        trainHomePage.pickADate(distantDate);
    }

    @Then("verify {string}  is displayed")
    public void verifyIsDisplayed(String errorMessage) {
        String msg=trainHomePage.getErrorMessage();
        Assert.assertEquals(msg,errorMessage);

    }

    @Then("verify user is on Train home page")
    public void verifyUserIsOnTrainHomePage() {
        Assert.assertTrue(trainHomePage.verifyTrainHomePage());
    }
}


