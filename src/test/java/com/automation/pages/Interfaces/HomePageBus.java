package com.automation.pages.Interfaces;

import org.openqa.selenium.WebDriver;

public interface HomePageBus {

    void openWebsite();
    boolean verifyUserIsOnHomePage();
    void enterSourceCity(String sourceCity);
    void enterDestinationCity(String destinationCity);
    void clickOnSearchButton();
    void selectAData(String date);
    void selectDate(String date, WebDriver driver);
    void scrollsToTheBottomOfThePage() throws InterruptedException;
    boolean isBackToScrollButtonPresent();
    void clickOnBackToScrollButton();
    boolean isPageScrollsToTopOfPage() throws InterruptedException;
    boolean isCitiesAreSwapped();
    void clickOnViewAllOffersBtn();
    void clickOnProfileDropDownBtn();
    void clickOnCancelTicket();
}
