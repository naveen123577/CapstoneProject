package com.automation.steps;

import com.automation.pages.TrainBookingPageWeb;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TrainBookingStep {

    TrainBookingPageWeb trainBookingPage=new TrainBookingPageWeb();


    @When("user clicks on a seat in a train")
    public void userClicksOnASeatInATrain() throws InterruptedException {
        trainBookingPage.clickASeat();
    }



//    @And("clicks go ahead button")
//    public void clicksGoAheadButton() throws InterruptedException {
//        trainBookingPage.clickGoAhead();
//
//    }

    @And("enters the user name {string} in the field")
    public void entersTheUserNameInTheField(String username) {
       trainBookingPage.enterUsername(username);
    }

    @Then("verify {string} is displayed")
    public void verifyIsDisplayed(String errorMsg) {
        String msg= trainBookingPage.verifyUsername();
        Assert.assertEquals(msg,errorMsg);
    }

    @And("click on check username button")
    public void clickOnCheckUsernameButton() {
        trainBookingPage.clickOnCheckUserName();
    }
}
