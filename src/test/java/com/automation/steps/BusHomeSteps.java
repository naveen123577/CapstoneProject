package com.automation.steps;

import com.automation.pages.BusHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BusHomeSteps {

    BusHomePage busHomePage=new BusHomePage();

    @Given("user opens the website")
    public void user_opens_the_website() {
        busHomePage.openWebsite();
    }

    @Then("verify user is on homepage")
    public void verify_user_is_on_homepage() {
        Assert.assertTrue(busHomePage.verifyUserIsOnHomePage());
    }

    @When("user enter {string} as the source city")
    public void user_enter_as_the_source_city(String string) {
        
        
    }

    @When("user enter {string} as the destination city")
    public void user_enter_as_the_destination_city(String string) {
        
        
    }

    @When("user select the date of travel as {string}")
    public void user_select_the_date_of_travel_as(String string) {
        
        
    }

    @When("user click on the {string} button")
    public void user_click_on_the_button(String string) {
        
        
    }
}
