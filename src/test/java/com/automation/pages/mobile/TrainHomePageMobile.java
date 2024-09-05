package com.automation.pages.mobile;

import com.automation.pages.Interfaces.HomepageTrain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrainHomePageMobile extends BasePageMobile implements HomepageTrain {

    @FindBy(xpath = "(//android.view.View[@resource-id='view_tab_header'])[2]")
    WebElement trainTicketBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.redbus.android.redrailsDynamicModule:id/fromEditView']")
    WebElement fromBtn;

    @FindBy(id = "in.redbus.android.redrailsDynamicModule:id/queryField")
    WebElement fromInput;

    @FindBy(xpath="(//android.widget.TextView[@resource-id='in.redbus.android.redrailsDynamicModule:id/cityName'])[10]")
    WebElement  firstSourceOption;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.redbus.android.redrailsDynamicModule:id/buttonTitle']")
    WebElement trainSearchBtn;

    @FindBy(xpath ="//android.widget.TextView[@resource-id='in.redbus.android.redrailsDynamicModule:id/toEditView']")
    WebElement toBtn;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='in.redbus.android.redrailsDynamicModule:id/queryField']")
    WebElement toInput;

    @FindBy(xpath ="//android.widget.TextView[@resource-id='in.redbus.android.redrailsDynamicModule:id/recentSearchTitle']")
    WebElement destFirstOption;

    @FindBy(xpath ="//android.widget.ImageView[@resource-id='in.redbus.android.redrailsDynamicModule:id/dateImage']")
    WebElement dateIcon;

    @FindBy(xpath ="//android.widget.ImageButton[@content-desc='Next month']")
    WebElement nextBtn;

    @Override
    public void clickTrainTicket() {
        trainTicketBtn.click();
    }

    @Override
    public void enterSourceCity(String from) throws InterruptedException {
        fromBtn.click();
        fromInput.sendKeys(from);
        waitForElementToBeClickable(firstSourceOption);
        firstSourceOption.click();
    }

    @Override
    public void enterDestinationCity(String to) throws InterruptedException {
        waitForElementToBeVisible(toBtn);
        toBtn.click();
        waitForElementToBeVisible(toInput);
        toInput.sendKeys(to);
        waitForElementToBeClickable(destFirstOption);
        destFirstOption.click();
    }

    @Override
    public void clickSearchButton() {

    }

    @Override
    public void pickADate(String date) {
        dateIcon.click();
        selectDate(date,driver);
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
    public boolean verifyResultsForTrain() {
        return false;
    }

    @Override
    public String getPopupMessage() throws InterruptedException {
        return "";
    }

    @Override
    public boolean verifySwapButton() {
        return false;
    }

    @Override
    public void clickLiveTrainStatus() {

    }

    @Override
    public void enterTrainNumber(String trainNo) throws InterruptedException {

    }

    @Override
    public void clickCheckStatus() throws InterruptedException {

    }

    @Override
    public boolean verifyStatusOfTrain() {
        return false;
    }

    @Override
    public String getErrorMessage() {
        return "";
    }

    @Override
    public boolean verifyTrainHomePage() {
        return trainSearchBtn.isDisplayed();
    }
}
