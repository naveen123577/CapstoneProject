package com.automation.pages.mobile;

import com.automation.pages.Interfaces.HomePageBus;
import org.openqa.selenium.WebDriver;

public class BusHomePageMobile extends BasePageMobile implements HomePageBus {
    @Override
    public void openWebsite() {

    }

    @Override
    public boolean verifyUserIsOnHomePage() {
        return false;
    }

    @Override
    public void enterSourceCity(String sourceCity) {

    }

    @Override
    public void enterDestinationCity(String destinationCity) {

    }

    @Override
    public void clickOnSearchButton() {

    }

    @Override
    public void selectAData(String date) {

    }

    @Override
    public void selectDate(String date, WebDriver driver) {

    }

    @Override
    public void scrollsToTheBottomOfThePage() {

    }

    @Override
    public boolean isBackToScrollButtonPresent() {
        return false;
    }

    @Override
    public void clickOnBackToScrollButton() {

    }

    @Override
    public boolean isPageScrollsToTopOfPage() {
        return false;
    }

    @Override
    public boolean isCitiesAreSwapped() {
        return false;
    }

    @Override
    public void clickOnViewAllOffersBtn() {

    }

    @Override
    public void clickOnProfileDropDownBtn() {

    }

    @Override
    public void clickOnCancelTicket() {

    }
}
