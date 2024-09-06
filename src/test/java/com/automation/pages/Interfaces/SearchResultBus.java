package com.automation.pages.Interfaces;

public interface SearchResultBus {

    boolean isSearchResultFound();

    void clickOnSleeperCheckBox() throws InterruptedException;

    void clickOnAcCheckBox() throws InterruptedException;

    void clickOnNonAcCheckBox();

    boolean isNonAcBusResultsDisplayed();

    void clickOnClearAllFilterBtn() throws InterruptedException;

    boolean isFullListOfBusesAreDisplayed() throws InterruptedException;

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

    boolean isAcBusResultsDisplayed();

    boolean isSleeperBusResultsDisplayed();
}
