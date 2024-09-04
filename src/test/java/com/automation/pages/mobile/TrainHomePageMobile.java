package com.automation.pages.mobile;

import com.automation.pages.Interfaces.HomepageTrain;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrainHomePageMobile extends BasePageMobile implements HomepageTrain {

    @FindBy(xpath = "(//android.view.View[@resource-id='view_tab_header'])[2]")
    WebElement trainTicketBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='From']")
    WebElement fromBtn;

    @FindBy(id = "in.redbus.android.redrailsDynamicModule:id/queryField")
    WebElement fromInput;

    @FindBy(xpath ="//android.view.ViewGroup[@resource-id='in.redbus.android.redrailsDynamicModule:id/itemContainer'])[1])")
    WebElement  firstSourceOption;
    @Override
    public void clickTrainTicket() {
        trainTicketBtn.click();
        waitForElementToBeVisible(firstSourceOption);

    }

    @Override
    public void enterSourceCity(String from) throws InterruptedException {
        fromBtn.click();
        fromInput.sendKeys(from);
        waitForElementToBeVisible(firstSourceOption);
        firstSourceOption.click();

    }

    @Override
    public void enterDestinationCity(String to) throws InterruptedException {

    }

    @Override
    public void clickSearchButton() {

    }

    @Override
    public void pickADate(String date) {

    }

    @Override
    public void selectDate(String date, WebDriver driver) {

    }

    @Override
    public boolean verifyResultsForTrain() {
        return false;
    }

    @Override
    public String getPopupMessage() throws InterruptedException {
        return "";
    }

    @Override
    public boolean verifySwapButton() {
        return false;
    }

    @Override
    public void clickLiveTrainStatus() {

    }

    @Override
    public void enterTrainNumber(String trainNo) throws InterruptedException {

    }

    @Override
    public void clickCheckStatus() throws InterruptedException {

    }

    @Override
    public boolean verifyStatusOfTrain() {
        return false;
    }

    @Override
    public String getErrorMessage() {
        return "";
    }

    @Override
    public boolean verifyTrainHomePage() {
        return false;
    }
}
