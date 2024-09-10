package com.automation.pages.mobile;

import com.automation.pages.Interfaces.SearchResultBus;
import com.automation.utils.ConfigReader;
import io.netty.util.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BusSearchResultPageMobile extends BasePageMobile implements SearchResultBus {

    @FindBy (xpath = "//android.view.View[contains(@resource-id,'SrpTuple')]")
    List<WebElement> buses;

    @FindBy(xpath = "//android.widget.TextView[@text='No Buses Found']")
    WebElement noBusesMsg;

    @FindBy(xpath = "//android.view.View[@resource-id='SrpContxlFilterUiId']/android.view.View[2]")
    WebElement filterBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Bus Type']")
    WebElement busTypeBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='android:id/content']/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.widget.CheckBox")
    WebElement sleeperCheckBox;

    @FindBy (xpath = "//android.view.ViewGroup[@resource-id='android:id/content']/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[3]/android.widget.CheckBox")
    WebElement acCheckBox;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='android:id/content']/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[4]/android.widget.CheckBox")
    WebElement nonAcCheckBox;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='android:id/content']/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[4]/android.widget.Button")
    WebElement filterApplyBtn;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Sleeper')]")
    List<WebElement> busTypeList;

    @FindBy(xpath = "//android.widget.TextView[@text='Clear All Filters']")
    WebElement clearAllFilterBtn;

    @FindBy(xpath = "//android.view.View[@resource-id='SrpContxlFilterUiId']/android.view.View[1]/android.view.View[1]")
    WebElement sortBtn;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Buses')]")
    WebElement busNum;

    @FindBy(xpath = "//android.widget.TextView[@text='End of the list']")
    WebElement endOfList;

    @FindBy(xpath = "//android.widget.TextView[@text='06 Sep']/following-sibling::android.widget.TextView[1]")
    WebElement boardingDetails;

    @FindBy(xpath = "//android.widget.TextView[@text='Boarding points']")
    WebElement boardingPointsBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='View all dropping points']")
    WebElement viewAllDroppingPointsBtn;

    @FindBy(xpath = "//android.widget.ScrollView/android.widget.HorizontalScrollView")
    WebElement seatElement;

    @FindBy(xpath = "//android.widget.Button")
    WebElement selectBoardingDroppingPointsBtn;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View")
    List<WebElement>boardingPointList;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View")
    WebElement droppingPointBtn;
    
    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View")
    List<WebElement> droppingPointList;

    @FindBy(xpath = "//android.view.View[@content-desc='Go back to previous page']")
    WebElement backBtn;

    @FindBy(xpath = "(//android.widget.TextView[contains(@text,'₹')])[1]")
    WebElement firstBusPriceInListingPage;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.widget.TextView[contains(@text,'₹')]")
    WebElement firstBusPriceAfterSelectingSeat;

    @Override
    public boolean isSearchResultFound() {
        String busNumber = busNum.getText();
        ConfigReader.setConfigValue("busNumber", busNumber);
        return !buses.isEmpty() || noBusesMsg.isDisplayed();
    }

    @Override
    public void clickOnSleeperCheckBox(){
        sortBtn.click();
        filterBtn.click();
        busTypeBtn.click();
        sleeperCheckBox.click();
        filterApplyBtn.click();
    }

    @Override
    public void clickOnAcCheckBox(){
        sortBtn.click();
        filterBtn.click();
        busTypeBtn.click();
        acCheckBox.click();
        filterApplyBtn.click();
    }

    @Override
    public void clickOnNonAcCheckBox() {
        sortBtn.click();
        filterBtn.click();
        busTypeBtn.click();
        nonAcCheckBox.click();
        filterApplyBtn.click();
    }

    @Override
    public boolean isNonAcBusResultsDisplayed() {
        int count = 0;
        boolean nonAcPresent = false;
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresent(clearAllFilterBtn) && count <= 10) {
            scrollOrSwipe(width / 2, height / 2, width / 2, 0);
            for (WebElement bus: busTypeList){
                count +=1;
                if (bus.getText().toUpperCase().contains("NON A/C") || bus.getText().toUpperCase().contains("NON AC")){
                    nonAcPresent = true;
                }
                else {
                    return false;
                }
            }
        }
        return nonAcPresent;
    }

    @Override
    public void clickOnClearAllFilterBtn() {
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresent(clearAllFilterBtn)) {
            scrollOrSwipe(width / 2, height / 2, width / 2, 0);
        }
        clearAllFilterBtn.click();
    }

    @Override
    public boolean isFullListOfBusesAreDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        String busNumber = busNum.getText();
        return busNumber.equals(ConfigReader.getConfigValue("busNumber"));
    }

    @Override
    public boolean isClearAllFilterBtnDisplayed() {
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresent(endOfList)) {
            scrollOrSwipe(width / 2, height / 2, width / 2, 0);
        }
        return isPresent(endOfList);
    }

    @Override
    public void clickOnBoardingAndDroppingPointsButton() {
        sortBtn.click();
        buses.get(0).click();
        String dateElement = driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.ImageView\n" +
                "/following-sibling::android.widget.TextView[2]")).getText();
        String date = dateElement.substring(dateElement.length()-6);
        System.out.println(date);
        ConfigReader.setConfigValue("boardingDate",date);
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
        scrollOrSwipe(width / 2, height-150, width / 2, 0);
        boardingPointsBtn.click();
    }

    @Override
    public boolean isBoardingAndDroppingPointsDisplayed() {
        String datePath = "//android.widget.TextView[@text='%s']/following-sibling::android.widget.TextView[1]";
        String date = String.format(datePath,ConfigReader.getConfigValue("boardingDate"));
        WebElement boardingPointsElement = driver.findElement(By.xpath(date));
        boolean boardingPoints;
        boolean droppingPoints = false;
        boardingPoints= isPresent(boardingPointsElement);
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresent(viewAllDroppingPointsBtn)) {
            scrollOrSwipe(width / 2, height / 2, width / 2, 0);
            String droppingPointsPath = "//android.widget.TextView[@text='%s']/following-sibling::android.widget.TextView";
            String droppingPoint = String.format(droppingPointsPath,ConfigReader.getConfigValue("Bus.travelTo"));
            WebElement droppingPointsElement = driver.findElement(By.xpath(droppingPoint));
            droppingPoints = isPresent(droppingPointsElement);
        }
        return boardingPoints && droppingPoints;
    }

    @Override
    public void clickOnEmptySeat(){
        var seat_dimension = seatElement.getSize();
        var seat_center_x = seat_dimension.getWidth()+10;
        var seat_center_y = seat_dimension.getHeight()-10;

        int x = 10, y = 10;

        while (x<seat_center_x && y< seat_center_y && !isPresent(selectBoardingDroppingPointsBtn)){
            clickOnSingleEmptySeat(seatElement,x,y);
            x=x+10;
            y=y+10;
        }
    }

    public void clickOnSingleEmptySeat(WebElement canvas, int x, int y){
        new Actions(driver)
                .moveToElement(canvas,x,y)
                .click().pause(1000).build().perform();
    }

    @Override
    public void clickOnViewSeat() {
        sortBtn.click();
        buses.get(0).click();
    }

    @Override
    public boolean isBoardingAndDroppingDetailsListPresent() {
        selectBoardingDroppingPointsBtn.click();
        boolean boardingPointPresent = false;
        boolean droppingPointPresent = false;
        if (!boardingPointList.isEmpty()){
            boardingPointPresent = true;
        }
        droppingPointBtn.click();
        if(!droppingPointList.isEmpty()){
            droppingPointPresent = true;
        }
        return boardingPointPresent && droppingPointPresent;
    }

    @Override
    public boolean isSeatsAreVisible() {
        return true;
    }

    @Override
    public void clickOnHideSeatsButton() {

    }

    @Override
    public void storeFirstBusPriceOfListingPage() {
        String firstBusPrice = firstBusPriceInListingPage.getText();
        ConfigReader.setConfigValue("firstBusPriceListingPage",firstBusPrice);
    }

    @Override
    public boolean isPriceOfListingPageAndBoardingDroppingPageSame() {
        backBtn.click();
        String firstBusPrice = firstBusPriceAfterSelectingSeat.getText();
        String priceOfFirstBus = firstBusPrice.substring(2).replace(",", "");
        int firstBusPriceIntValue = Integer.parseInt(priceOfFirstBus);
        String firstBusPriceListingPage = ConfigReader.getConfigValue("firstBusPriceListingPage");
        String priceWithoutFirstChar = firstBusPriceListingPage.substring(3).replace(",", "");
        int firstBusPriceListingPageIntValue = Integer.parseInt(priceWithoutFirstChar);
        return firstBusPriceIntValue >= firstBusPriceListingPageIntValue;
    }

    @Override
    public boolean isAcBusResultsDisplayed() {
        int count = 0;
        boolean acPresent = false;
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresent(clearAllFilterBtn) && count <= 10) {
            scrollOrSwipe(width / 2, height / 2, width / 2, 0);
            for (WebElement bus: busTypeList){
                count +=1;
                if (bus.getText().toUpperCase().contains("A/C") || bus.getText().toUpperCase().contains("AC") && !bus.getText().contains("Non AC") && !bus.getText().toUpperCase().contains("NON A/C")){
                    acPresent = true;
                }
                else {
                    return false;
                }
            }
        }
        return acPresent;
    }

    @Override
    public boolean isSleeperBusResultsDisplayed() {
        int count = 0;
        boolean sleeperPresent = false;
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresent(clearAllFilterBtn) && count <= 10) {
            scrollOrSwipe(width / 2, height / 2, width / 2, 0);
            for (WebElement bus: busTypeList){
                count +=1;
                if (bus.getText().toLowerCase().contains("sleeper")){
                    sleeperPresent = true;
                }
                else {
                    return false;
                }
            }
        }
        return sleeperPresent;
    }
}
