package com.automation.pages.Interfaces;

public interface SearchResultBus {

    boolean isSearchResultFound();
    void clickOnSleeperCheckBox();
    void clickOnAcCheckBox();
    void clickOnNonAcCheckBox();
    boolean isNonAcBusResultsDisplayed();
    void clickOnClearAllFilterBtn();
    boolean isFullListOfBusesAreDisplayed();
    boolean isClearAllFilterBtnDisplayed();
    void clickOnBoardingAndDroppingPointsButton();
    boolean isBoardingAndDroppingPointsDisplayed();
    void clickOnEmptySeat();
    void clickOnViewSeat();
    boolean isBoardingAndDroppingDetailsListPresent();
    boolean isSeatsAreVisible();
    void clickOnHideSeatsButton();
    void storeFirstBusPriceOfListingPage();
    boolean isPriceOfListingPageAndBoardingDroppingPageSame();
}
