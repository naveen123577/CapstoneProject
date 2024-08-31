package com.automation.pages.mobile;

import com.automation.pages.Interfaces.HomePageBus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusHomePageMobile extends BasePageMobile implements HomePageBus {

    @FindBy(id = "in.redbus.android:id/continueButton")
    WebElement openPageContinueBtn;

    @FindBy(id = "in.redbus.android.onBoardingModule:id/container")
    WebElement openPageContainer;

    @FindBy(id = "in.redbus.android.onBoardingModule:id/skip")
    WebElement openPageSkipBtn;

    @Override
    public void openWebsite() {
        openPageContinueBtn.click();
//        String currentTitle = exploreStayFirstCard.getText();
//        String previousTitle = "";
        int n = 0;
        while (n<3) {
            int x = openPageContainer.getLocation().getX();
            int y = openPageContainer.getLocation().getY();
            int cardWidth = openPageContainer.getSize().getWidth();
            int cardHeight = openPageContainer.getSize().getHeight();

            scrollOrSwipe(x + cardWidth, y + cardHeight / 2, 0, y + cardHeight / 2);
            openPageSkipBtn = driver.findElement(By.id("in.redbus.android.onBoardingModule:id/skip"));
            n+=1;
        }
        openPageSkipBtn.click();
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
