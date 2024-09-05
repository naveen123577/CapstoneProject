package com.automation.pages.mobile;

import com.automation.pages.Interfaces.HomePageBus;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//android.widget.EditText")
    WebElement sourceInput;

    @FindBy(xpath = "//android.view.View[@resource-id='View_destination']")
    WebElement destinationSelect;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement destinationInput;

    @FindBy(xpath = "//android.widget.TextView[@text='Date of Journey']")
    WebElement dateSelect;

    @FindBy(id = "in.redbus.android:id/calendar_right_arrow")
    WebElement nextBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Search buses']")
    WebElement searchBusBtn;

//    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']//android.view.View/android.view.View/android.view.View")
//    WebElement firstSourceSelect;

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
        String xpath = "//android.widget.TextView[@text='%s']";
        String fullXpath = String.format(xpath, sourceCity);
        waitForElementToBePresentNotVisible(fullXpath);
        driver.findElement(By.xpath(fullXpath)).click();
    }

    @Override
    public void enterDestinationCity(String destinationCity) {
        destinationSelect.click();
        destinationInput.sendKeys(destinationCity);
        String xpath = "(//android.widget.TextView[@text='%s'])[1]";
        String fullXpath = String.format(xpath, destinationCity);
        waitForElementToBePresentNotVisible(fullXpath);
        driver.findElement(By.xpath(fullXpath)).click();
    }

    @Override
    public void clickOnSearchButton() {
        searchBusBtn.click();
    }

    @Override
    public void selectADate(String date) {
        dateSelect.click();
        selectDate(date, driver);
    }

    @Override
    public void selectDate(String date, WebDriver driver) {
        String monthYear = date.substring(date.indexOf(" ")+1).toUpperCase();
        String day = date.substring(0,date.indexOf(" "));

        WebElement monthYearElement = driver.findElement(By.id("in.redbus.android:id/calendar_month_year_textview"));

        String lastFourChars = monthYearElement.getText().substring(monthYearElement.getText().length() - 4);

        while(!monthYear.equals(monthYearElement.getText().substring(0,3)+ " " + lastFourChars)){
            nextBtn.click();
            monthYearElement = driver.findElement(By.id("in.redbus.android:id/calendar_month_year_textview"));
            lastFourChars = monthYearElement.getText().substring(monthYearElement.getText().length() - 4);
        }

        String xpath = "//android.widget.TextView[@resource-id='in.redbus.android:id/cal_text' and @text='%s']";
        WebElement dayElement = driver.findElement(By.xpath(String.format(xpath,day)));
        dayElement.click();
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
