package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusHomePage extends BasePage {

    @FindBy(xpath = "//h1[@class='sc-jAaTju fOJRFi' and text()=\"India's No. 1 Online Bus Ticket Booking Site\"]")
    WebElement Heading;

    @FindBy(css = "src")
    WebElement travelFrom;

    public void openWebsite() {
        
        driver.get(ConfigReader.getConfigValue("base.url"));
    }

    public boolean verifyUserIsOnHomePage() {
        return Heading.isDisplayed();
    }

<<<<<<< HEAD
    public void clickBookTrain() {

=======
    public void enterSourceCity(String sourceCity) {
        travelFrom.sendKeys(sourceCity);
>>>>>>> 10fcb2e1954e5e45372dbbec37180f13cd49ded3
    }
}
