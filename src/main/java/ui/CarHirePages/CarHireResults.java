package ui.CarHirePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ui.AbstractPage;

/**
 * Created by Maryia_Shynkarenka on 6/19/2017.
 */
public class CarHireResults extends AbstractPage{

    @FindBy(xpath = "//input[@id='pickupLocation']")
    WebElement outboundAirport;

    @FindBy(id = "pickupLocation")
    WebElement outboundDate;

    @FindBy(xpath = "//input[@id='returnLocation']")
    WebElement inboundAirport;

    @FindBy(id = "pickupLocation")
    WebElement inboundDate;

    public CarHireResults(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 100);
        PageFactory.initElements(driver, this);
    }

    public String getOutboundAirportText(){
        waitElement(outboundAirport);
        return outboundAirport.getAttribute("value");
    }

    public String getInboundAirportText(){
        waitElement(inboundAirport);
        return inboundAirport.getAttribute("value") ;
    }
}
