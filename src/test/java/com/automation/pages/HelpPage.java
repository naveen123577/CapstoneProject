package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.detectlanguage.DetectLanguage;
import com.detectlanguage.errors.APIError;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;
import java.util.Set;

public class HelpPage extends BasePage{

    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

    @FindBy(xpath = "//iframe[@src='//www.redbus.in/help?hideLayout=true']")
    WebElement iframeElement;

    @FindBy(xpath="(//div[@class='rb_main_secondary_item  link'])[1]")
    WebElement helpButton;

    @FindBy(xpath = "//span[@class='languagePreference']")
    WebElement languageButton;

    @FindBy(xpath = "//img[@alt='selectLanguage']")
    WebElement languageLogo;

    @FindBy(xpath = "//div[@class='login-textDiv']/div")
    WebElement title;

    @FindBy(xpath ="//div[@class='setLanguageButton']")
    WebElement setButton;

    String xpath="";

    public void clickOnHelp() {
        helpButton.click();
    }

    public void clickLanguageOption() {

        Set<String> handles = driver.getWindowHandles();
        String current = driver.getWindowHandle();
        for(String handle : handles){
            if(!handle.equals(current)){
                driver.close();
                driver.switchTo().window(handle);
            }
        }

        driver.switchTo().frame(iframeElement);



        languageButton.click();
        System.out.println(languageButton.getText());
    }

    public void selectALanguage() {

    }

    public boolean verifyLanguage() throws InterruptedException {

        WebElement clkLang= driver.findElement(By.xpath(xpath));
        String lang=clkLang.getText();
        System.out.println(xpath);
        System.out.println(clkLang.isDisplayed());
        System.out.println(setButton.isDisplayed());
//
        javaScriptExecutorClick(clkLang);
//
        setButton.click();


        WebElement element = null;
        boolean found = false;

        while (!found) {
            try {
                // Try to find the element
                Thread.sleep(3000);
                element = driver.findElement(By.xpath("//div[@class='login-textDiv']"));
                // Interact with the element (e.g., click it)
//                element.click();
                found = true;
            } catch (StaleElementReferenceException e) {
                // Handle the stale element exception
                System.out.println("Element is stale, retrying...");
                // Optionally, wait for a few seconds before retrying
                Thread.sleep(1000);
            }
        }


        DetectLanguage.apiKey = "e5e6e23c9433b864fb51406edfc6e0fd";

        String language1="";
        String language2="";
        try {
             language1 = DetectLanguage.simpleDetect(lang);
            language2=DetectLanguage.simpleDetect(element.getText());
        } catch (APIError e) {
            e.printStackTrace();
        }

        System.out.println(language1+" "+language2);
        return language1.equals(language2);
    }

    public void setALanguage(String language) {

        if (language.equals("Tamil"))
        {
            WebElement tamil= driver.findElement(By.xpath("(//input[@id='checkmark'])[2]"));
            tamil.click();
            xpath="//span[text()='தமிழ்']";
        } else if (language.equals("Telugu")) {
            WebElement telugu=driver.findElement(By.xpath("(//input[@id='checkmark'])[4]"));
            telugu.click();
            xpath ="//span[text()='తెలుగు']";;
        }
        else if (language.equals("Hindi")) {
                    WebElement hindi=driver.findElement(By.xpath("(//input[@id='checkmark'])[3]"));
                    hindi.click();
                    xpath="//span[text()='हिन्दी']";
        }
        else
        {
            System.out.println("Choose Language which is available in the Application");
        }

    }
}
