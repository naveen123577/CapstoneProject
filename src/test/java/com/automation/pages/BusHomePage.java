package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusHomePage extends BasePage {

    @FindBy(xpath = "//h1")
    WebElement Heading;

    @FindBy(css = "src")
    WebElement travelFrom;

    public void openWebsite() {
        
        driver.get(ConfigReader.getConfigValue("base.url"));
    }

    public boolean verifyUserIsOnHomePage() {
        return Heading.isDisplayed();
    }

    public void enterSourceCity(String sourceCity) {
        travelFrom.sendKeys(sourceCity);
    }

    public void enterDestinationCity() {
    }

    public void clickOnSearchButton() {
    }
}
