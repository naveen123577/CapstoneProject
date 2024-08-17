package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusHomePage extends BasePage {

    @FindBy(xpath = "//h1[@class='sc-jAaTju fOJRFi' and text()=\"India's No. 1 Online Bus Ticket Booking Site\"]")
    WebElement Heading;

    @FindBy(css = "#src")
    WebElement travelFromInput;

    @FindBy(xpath = "//ul[@class='sc-dnqmqq dZhbJF']/li[1]")
    WebElement sourceSelect;

    @FindBy(id = "dest")
    WebElement travelToInput;

    @FindBy(xpath = "//ul[@class='sc-dnqmqq dZhbJF']/li[1]")
    WebElement destinationSelect;

    @FindBy(css = "#onwardCal")
    WebElement dateSelect;

    @FindBy(xpath = "(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD']/following-sibling::div)[1]")
    WebElement monthYearDate;

    @FindBy(xpath = "//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][3]")
    WebElement nextBtn;

    @FindBy(css = "#search_button")
    WebElement searchBusBtn;

    public void openWebsite() {
        
        driver.get(ConfigReader.getConfigValue("base.url"));
    }

    public boolean verifyUserIsOnHomePage() {
        return Heading.isDisplayed();
    }

    public void enterSourceCity(String sourceCity) {
        travelFromInput.sendKeys(sourceCity);
        sourceSelect.click();
    }

    public void enterDestinationCity(String destinationCity) {
        travelToInput.sendKeys(destinationCity);
        destinationSelect.click();
    }

    public void clickOnSearchButton() {
        searchBusBtn.click();
    }

    public void selectData(String date) {
        String travelDate = date;
//        String checkOutDate = "13 November 2024";

        dateSelect.click();
        selectDate(travelDate, driver);
//        selectDate(checkOutDate, driver);


    }
    public void selectDate(String date, WebDriver driver){
        String monthYear = date.substring(date.indexOf(" ")+1);
        String day = date.substring(0,date.indexOf(" "));

        WebElement monthYearElement = driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD']/following-sibling::div)[1]"));

        while(!monthYearElement.getText().substring(0,8).equals(monthYear)){
            // clicking the next button
            nextBtn.click();
            monthYearElement = driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD']/following-sibling::div)[1]"));
        }

        String xpath = "//span[contains(@class,'DayTiles__CalendarDaysSpan') and text() = %s]";
        WebElement dayElement = driver.findElement(By.xpath(String.format(xpath,day)));
        dayElement.click();
    }

}
