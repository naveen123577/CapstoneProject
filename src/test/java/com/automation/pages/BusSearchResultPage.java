package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BusSearchResultPage extends BasePage{

    @FindBy(xpath = "//div[@class='travels lh-24 f-bold d-color']")
    List<WebElement>buses;

    @FindBy(xpath = "//div[@class='msg' and text()='Oops! No buses found.']")
    WebElement noBusesMsg;

    public boolean isSearchResultFound() {
        return !buses.isEmpty() || noBusesMsg.isDisplayed();
    }
}
