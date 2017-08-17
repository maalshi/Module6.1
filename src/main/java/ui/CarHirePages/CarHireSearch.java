package ui.CarHirePages;


import businessobjects.CarHireDetails;
import businessobjects.Route;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.AbstractPage;

/**
 * Created by Maryia_Shynkarenka on 6/19/2017.
 */
public class CarHireSearch extends AbstractPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "pickupLocation")
    WebElement pickUpField;

    @FindBy(id = "item-0-0")
    WebElement suggestion;

    @FindBy(id = "pickupDate")
    WebElement startDate;

    @FindBy(xpath = "//td[@data-enabled=\"true\"][2]")
    WebElement outboundDate;

    @FindBy(id = "returnDate")
    WebElement endDate;

    @FindBy(xpath = "//td[@data-enabled=\"true\"][2]")
    WebElement inboundDate;

    @FindBy(id = "searchCarsFormBtn-searchcars")
    WebElement searchButton;

    public CarHireSearch(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void sendKeysPickUpLocation(CarHireDetails carHireDetails){
        waitElement(pickUpField);
        pickUpField.sendKeys(carHireDetails.getCity());
    }

    public void clickSuggestion(){
       clickWebElement(suggestion);
    }

    public void clickStartDate(){
        clickWebElement(startDate);
    }

    public void clickOutboiundDate(){
       clickWebElement(outboundDate);
    }

    public void clickEndDate(){
        clickWebElement(endDate);
    }

    public void clickInboundDate(){
        clickWebElement(inboundDate);
    }

    public void clickSearchButton(){
        clickWebElement(searchButton);
    }
}
