package com.automation.steps;

import com.automation.pages.BusHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TrainHomeSteps {

    BusHomePage homePage=new BusHomePage();
    @Given("user opens the website")
    public void user_opens_the_website() {
        homePage.openWebsite();
    }

    @Then("verify user is on homepage")
    public void verify_user_is_on_homepage() {
        Assert.assertTrue(homePage.verifyUserIsOnHomePage());
    }

    @When("user clicks on the Train Tickets option")
    public void user_clicks_on_the_train_tickets_option() {
        homePage.clickBookTrain();

    }

    @When("chooses from location")
    public void chooses_from_location() {

    }

    @When("chooses to location")
    public void chooses_to_location() {

    }

    @When("user clicks the Search Train Button")
    public void user_clicks_the_search_train_button() {

    }

    @Then("verify user see results for the same")
    public void verify_user_see_results_for_the_same() {

    }
}
