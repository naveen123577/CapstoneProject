package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrainHomePage extends BasePage {

    @FindBy(xpath ="//li[@id='rail_tickets_vertical']")
    WebElement ticketButton;
    public void clickTrainTicket() {
        ticketButton.click();
    }

    public void enterSourceCity() {

    }
}
