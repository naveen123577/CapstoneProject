package com.automation.pages.mobile;

import com.automation.pages.Interfaces.HomepageTrain;
import org.openqa.selenium.WebDriver;

public class TrainHomePageMobile implements HomepageTrain {
    @Override
    public void clickTrainTicket() {

    }

    @Override
    public void enterSourceCity(String from) throws InterruptedException {

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
