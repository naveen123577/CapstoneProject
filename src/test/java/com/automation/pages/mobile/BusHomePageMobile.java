package com.automation.pages.mobile;

import com.automation.pages.Interfaces.HomePageBus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusHomePageMobile extends BasePageMobile implements HomePageBus {

    @FindBy(xpath ="//android.widget.Button[@resource-id='in.redbus.android:id/continueButton']")
    WebElement openPageContinueBtn;

    @FindBy(id = "in.redbus.android.onBoardingModule:id/container")
    WebElement openPageContainer;

    @FindBy(id = "in.redbus.android.onBoardingModule:id/skip")
    WebElement openPageSkipBtn;

    @FindBy(id = "in.redbus.android.authmodule:id/buttonSkip")
    WebElement openPageSecondSkipBtn;

    @FindBy(id = "in.redbus.android:id/btnBsClose")
    WebElement ratingClose;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='android:id/content']/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View")
    WebElement updateAddClose;

    @FindBy(xpath = "(//android.widget.TextView[@text='Bus Tickets'])[2]")
    WebElement homeHeading;

    @FindBy (xpath = "//android.view.View[@resource-id='View_source']")
    WebElement sourceSelect;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Search Boarding Point\"]\n")
    WebElement sourceInput;

    @FindBy(className = "android.view.View")
    WebElement firstSourceSelect;

    @Override
    public void openWebsite() {
        System.out.println(openPageContinueBtn);
        openPageContinueBtn.click();
        int n = 1;
        while (n<3) {
            int x = openPageContainer.getLocation().getX();
            int y = openPageContainer.getLocation().getY();
            int cardWidth = openPageContainer.getSize().getWidth();
            int cardHeight = openPageContainer.getSize().getHeight();

            scrollOrSwipe(x + cardWidth-200, y + cardHeight / 2, 0, y + cardHeight / 2);
            n+=1;
        }

        openPageSkipBtn.click();

        openPageSecondSkipBtn.click();
        clickOnElementIfPresent(updateAddClose);
        clickOnElementIfPresent(ratingClose);
    }

    @Override
    public boolean verifyUserIsOnHomePage() {
        return isDisplay(homeHeading);
    }

    @Override
    public void enterSourceCity(String sourceCity) {
        sourceSelect.click();
        sourceInput.sendKeys(sourceCity);
        firstSourceSelect.click();
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
