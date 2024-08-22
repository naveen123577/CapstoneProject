package com.automation.steps;

import com.automation.pages.HelpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HelpSteps {

    HelpPage helpPage = new HelpPage();

    @When("user clicks on the help button")
    public void user_clicks_on_the_help_button() {
        helpPage.clickOnHelp();
    }

    @When("clicks the language option")
    public void clicks_the_language_option() {
        helpPage.clickLanguageOption();
    }

    @When("selects a specific language")
    public void selects_a_specific_language() {
        helpPage.selectALanguage();
    }


    @And("selects {string} as Language")
    public void selectsAsLanguage(String language) {
        helpPage.setALanguage(language);
    }

    @Then("verify that language have been applied to the application")
    public void verifyThatLanguageHaveBeenAppliedToTheApplication() throws InterruptedException {
        Assert.assertTrue(helpPage.verifyLanguage());
    }
}
