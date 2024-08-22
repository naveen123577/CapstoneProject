package com.automation.steps;

import com.automation.pages.CouponsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CouponsSteps {

    CouponsPage couponsPage = new CouponsPage();

    @Then("verify offer coupons page is displayed")
    public void verifyOfferCouponsPageIsDisplayed() {
        Assert.assertTrue(couponsPage.isOfferPageDisplayed());
    }

    @And("verify each offer coupon should have a coupon code displayed")
    public void verifyEachOfferCouponShouldHaveACouponCodeDisplayed() {
        Assert.assertTrue(couponsPage.isAllCouponsHaveCode());
    }
}
