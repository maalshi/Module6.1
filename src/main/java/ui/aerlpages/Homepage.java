package ui.aerlpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.AbstractPage;
import businessobjects.Route;

public class Homepage extends AbstractPage {

    By originField = By.xpath("//input[@id='origin']");
    By suggestion = By.xpath("//a[@data-test-id='test_booker_list_of_cities']");
    By destinationField = By.xpath("//input[@id='dest']");
    By findFlightButton = By.xpath("//button[@data-test-id='test_booker_search']");


    By tabHotel = By.xpath("//*[contains(@id,'partner-tab') and contains(.,'HOTELS')]");
    By buttonViewHotels = By.id("hotel-link-1");

    By tabCarHire = By.xpath("//*[contains(@id,'partner-tab') and contains(.,'CAR')]");
    By buttonMoreInfo = By.id("car-rental-link-1");

    public Homepage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void clickOrigin(){
        super.waitElement(originField);
        driver.findElement(originField).click();
    }

    public void clearOrigin(){
        driver.findElement(originField).clear();
    }

    public void setRoute (Route route){
        clickElementByLocator(originField, "Origin");
        driver.findElement(originField).clear();
        //sendKeysElementByLocator(driver.findElement(originField), "Send Keys origin");
        driver.findElement(originField).sendKeys(route.getOrigin());
        clickElementByLocator(suggestion, "suggestion");
        waitElement(destinationField);
        driver.findElement(destinationField).sendKeys(route.getDestination());
        clickElementByLocator(suggestion, "suggestion");
    }
/*
    public void sendKeysOrigin(String originCity){
        driver.findElement(originField).sendKeys(originCity);
    }

    public void clickOriginSuggestion(){
        driver.findElement(suggestion).click();
    }

    public void clickDestination(){
        driver.findElement(destinationField).click();
    }

    public void sendKeysDestination(String destinationCity){
        driver.findElement(destinationField).sendKeys(destinationCity);
    }

    public void clickDestinationSuggestion(){
        driver.findElement(suggestion).click();
    }*/

    public void clickFindFlightButton(){
        super.waitHighlightAndClickElement(findFlightButton);
    }

    public void clickTabHotel(){
        clickElementByLocator(tabHotel, "Tab Hotel Button");
    }

    public void clickButtonViewHotels(){
        clickElementByLocator(buttonViewHotels, "View Hotel button");
    }

    public void clickTabCarHire(){
        clickElementByLocator(tabCarHire, "Tab Car Hire");
    }

    public void clickButtonMoreInfo(){
        clickElementByLocator(buttonMoreInfo, "button More info");
    }
}
