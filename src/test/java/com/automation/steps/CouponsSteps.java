package com.automation.steps;

import com.automation.pages.BusSearchResultPageWeb;
import com.automation.pages.CouponsPageWeb;
import com.automation.pages.Interfaces.CouponsPageBus;
import com.automation.pages.Interfaces.SearchResultBus;
import com.automation.pages.mobile.BusSearchResultPageMobile;
import com.automation.pages.mobile.CouponsPageMobile;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CouponsSteps {

    CouponsPageBus couponsPage;
    public CouponsSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            couponsPage = new CouponsPageMobile();
        }else{
            couponsPage = new CouponsPageWeb();
        }
    }

    @Then("verify offer coupons page is displayed")
    public void verifyOfferCouponsPageIsDisplayed() {
        Assert.assertTrue(couponsPage.isOfferPageDisplayed());
    }

    @And("verify each offer coupon should have a coupon code displayed")
    public void verifyEachOfferCouponShouldHaveACouponCodeDisplayed() {
        Assert.assertTrue(couponsPage.isAllCouponsHaveCode());
    }
}
