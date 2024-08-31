package com.automation.pages.Interfaces;

import org.openqa.selenium.WebDriver;

public interface HomepageTrain {

    void clickTrainTicket();

    void enterSourceCity(String from) throws InterruptedException;

    void enterDestinationCity(String to) throws InterruptedException;

    void clickSearchButton();

    void pickADate(String date);

    void selectDate(String date, WebDriver driver);

    boolean verifyResultsForTrain();

    String getPopupMessage() throws InterruptedException;

    boolean verifySwapButton();

    void clickLiveTrainStatus();

    void enterTrainNumber(String trainNo) throws InterruptedException;

    void clickCheckStatus() throws InterruptedException;

    boolean verifyStatusOfTrain();

    String getErrorMessage();

    boolean verifyTrainHomePage();
}
