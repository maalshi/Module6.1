package ui.aerlpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.AbstractPage;

/**
 * Created by Maryia_Shynkarenka on 6/13/2017.
 */
public class PaxInfoPage extends AbstractPage {

    @FindBy(xpath = "//option[text()='Mr']")
    WebElement titleMr;

    @FindBy(id = "test_adultFname-0-1")
    WebElement firstName;

    @FindBy(id = "test_adultLname-0-2")
    WebElement familyName;

    @FindBy(xpath = "//*[@id='test_email-3']")
    WebElement email;

    @FindBy(xpath = "//*[@id='test_confirmemail-6']")
    WebElement confirmEmail;

    @FindBy(xpath = "//*[@id='test_acode-4']")
    WebElement areaCode;

    @FindBy(xpath = "//*[@id='test_mobnumber-5']")
    WebElement localNumber;

    @FindBy(id = "test_continueTravelEsstl")
    WebElement continueButton;

    public PaxInfoPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void clickTitleMr(){
        clickWebElement(titleMr, "Title Mr");
    }

    public void sendKeysFirstName(String name){
        sendKeysWebElement(firstName, name, "Name");
    }

    public void sendKeysFamilyName(String surname){
        sendKeysWebElement(familyName, surname, "Family name");
    }

    public void sendKeysEmail(String emailAddress){
        sendKeysWebElement(email, emailAddress, "Email");
    }

    public void sendKeysConfirmEmail(String confirmEmailAddress){
        sendKeysWebElement(confirmEmail, confirmEmailAddress, "Confirm Email");
    }

    public void sendKeysAreaCode(String area){
        sendKeysWebElement(areaCode, area, "Area Code");
    }

    public void sendKeysLocalNumber(String local){
        sendKeysWebElement(localNumber, local, "Local Number");
    }

    public void clickContinue(){
       clickWebElement(continueButton, "Continue button");
    }
}
