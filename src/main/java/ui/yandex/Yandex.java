package ui.yandex;

import businessobjects.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.AbstractPage;
import businessobjects.YandexLogin;

/**
 * Created by Maryia_Shynkarenka on 6/21/2017.
 */
public class Yandex extends AbstractPage {

    @FindBy(xpath = "//input[@name='login']")
    WebElement loginField;

    @FindBy(xpath = "//input[@name='passwd']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@class='checkbox__control']")
    WebElement alienComputerCheckbox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSubmit;

    public Yandex(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void yandexLogin(YandexLogin yandexLogin){
        waitElement(loginField);
        sendKeysWebElement(loginField, yandexLogin.getLogin(), "Login");
        sendKeysWebElement(passwordField, yandexLogin.getPassword(), "Password");
    }

    public void sendKeysLogin(String login){
        waitElement(loginField);
        loginField.sendKeys(login);
    }

    public void sendKeysPassword (String password){
        waitElement(loginField);
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton(){
        clickWebElement(buttonSubmit, "Submit button");
    }
}
