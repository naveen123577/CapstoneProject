package com.automation.pages.mobile;

import com.automation.pages.Interfaces.SearchResultBus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BusSearchResultPageMobile extends BasePageMobile implements SearchResultBus {

    @FindBy (xpath = "//android.view.View[contains(@resource-id,'SrpTuple')]")
    List<WebElement> buses;

    @FindBy(xpath = "//android.widget.TextView[@text='No Buses Found']")
    WebElement noBusesMsg;

    @Override
    public boolean isSearchResultFound() {
//        String busNumber = busNum.getText();
//        ConfigReader.setConfigValue("busNumber", busNumber);
        return !buses.isEmpty() || noBusesMsg.isDisplayed();
    }

    @Override
    public void clickOnSleeperCheckBox() {

    }

    @Override
    public void clickOnAcCheckBox() {

    }

    @Override
    public void clickOnNonAcCheckBox() {

    }

    @Override
    public boolean isNonAcBusResultsDisplayed() {
        return false;
    }

    @Override
    public void clickOnClearAllFilterBtn() {

    }

    @Override
    public boolean isFullListOfBusesAreDisplayed() {
        return false;
    }

    @Override
    public boolean isClearAllFilterBtnDisplayed() {
        return false;
    }

    @Override
    public void clickOnBoardingAndDroppingPointsButton() {

    }

    @Override
    public boolean isBoardingAndDroppingPointsDisplayed() {
        return false;
    }

    @Override
    public void clickOnEmptySeat() {

    }

    @Override
    public void clickOnViewSeat() {

    }

    @Override
    public boolean isBoardingAndDroppingDetailsListPresent() {
        return false;
    }

    @Override
    public boolean isSeatsAreVisible() {
        return false;
    }

    @Override
    public void clickOnHideSeatsButton() {

    }

    @Override
    public void storeFirstBusPriceOfListingPage() {

    }

    @Override
    public boolean isPriceOfListingPageAndBoardingDroppingPageSame() {
        return false;
    }
}
