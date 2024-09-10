package com.automation.pages.mobile;

import com.automation.pages.Interfaces.CouponsPageBus;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CouponsPageMobile extends BasePageMobile implements CouponsPageBus {

    @FindBy(xpath = "//android.widget.TextView[@text='Offers']")
    WebElement offersHeading;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.widget.Button")
    List<WebElement> coupons;

    @Override
    public boolean isOfferPageDisplayed() {
        return isPresent(offersHeading);
    }

    @Override
    public boolean isAllCouponsHaveCode() {
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
        boolean couponCode = false;
        int n = 0;
        while(n<3){
            scrollOrSwipe(width / 2, height/2, width / 2, 0);
            for(WebElement coupon : coupons){
                if(isPresent(coupon)){
                    couponCode = true;
                }
                else{
                    return false;
                }
            }
            n+=1;
        }
        return couponCode;
    }
}
