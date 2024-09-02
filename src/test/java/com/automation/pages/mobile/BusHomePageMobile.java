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

   /* @FindBy(xpath = "//android.widget.TextView[@content-desc='Easy Booking, Booking your preferred bus ticket is just a few taps away']")
    WebElement headText;*/

    @FindBy(xpath ="android.widget.TextView[@resource-id='in.redbus.android.authmodule:id/buttonSkip']")
    WebElement skipBtn;

    @FindBy(xpath ="//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']")
    WebElement denyBtn;

    @FindBy(xpath ="//android.widget.ImageView[@resource-id='in.redbus.android:id/btnBsClose']")
    WebElement closeBtn;

    @Override
    public void openWebsite() {
        System.out.println(openPageContinueBtn);
        openPageContinueBtn.click();
        int n = 1;
        while (n<3) {
            int x = openPageContainer.getLocation().getX();
            System.out.println(x);
            int y = openPageContainer.getLocation().getY();
            System.out.println(y);
            int cardWidth = openPageContainer.getSize().getWidth();
            System.out.println(cardWidth);
            int cardHeight = openPageContainer.getSize().getHeight();
            System.out.println(cardHeight);

            scrollOrSwipe(x + cardWidth-200, y + cardHeight / 2, 0, y + cardHeight / 2);
           // openPageSkipBtn = driver.findElement(By.id("in.redbus.android.onBoardingModule:id/skip"));
            n+=1;
        }


        openPageSkipBtn.click();
        waitForElementToBeVisible(skipBtn);

        skipBtn.click();
        clickOnElementIfPresent(denyBtn);
        clickOnElementIfPresent(closeBtn);
    }

    @Override
    public boolean verifyUserIsOnHomePage() {
        return true;
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
