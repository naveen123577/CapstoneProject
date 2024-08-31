package com.automation.steps;

import com.automation.pages.TicketCancelPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TicketCancelSteps {

    TicketCancelPageWeb ticketCancelPage = new TicketCancelPageWeb();

    @Then("verify the ticket cancellation page is displayed")
    public void verifyTheTicketCancellationPageIsDisplayed() {
        Assert.assertTrue(ticketCancelPage.isTicketCancelPageDisplayed());
    }

    @When("user enter incorrect {string} and {string}")
    public void userEnterIncorrectAnd(String ticketNum, String mobNum) {
        ticketCancelPage.enterInvalidTicketDetails(ticketNum,mobNum);
    }

    @And("user click on SelectPassengers Button")
    public void userClickOnSelectPassengersButton() {
        ticketCancelPage.clickOnSelectPassengerBtn();
    }

    @Then("verify the error message is displayed")
    public void verifyTheErrorMessageIsDisplayed() {
        String getMsg = ticketCancelPage.isErrorMsgReceived();
        Assert.assertEquals(ConfigReader.getConfigValue("cancelticket.errormessage"),getMsg);
    }
}
