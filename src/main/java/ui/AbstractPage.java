package ui;

import com.thoughtworks.selenium.Wait;
import config.WebDriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.xml.bind.Element;
import java.io.File;
import java.io.IOException;

public abstract class AbstractPage{

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static Logger LOGGER = Logger.getLogger(AbstractPage.class);

    public void dragAndDrop(WebElement toBeDragged, WebElement target){
        new Actions(driver).dragAndDrop(toBeDragged, target).build().perform();
        LOGGER.info("Object dragged and dropped");
    }

    public void waitElement (WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElement (By locator){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
    }

    public void jsClick(WebElement element, String name){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        LOGGER.info("Click element (js) " + name);
    }

    public void waitHighlightAndClickElement(By locator, String name){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor='red'", driver.findElement(locator));
        driver.findElement(locator).click();
        LOGGER.info("Element [" + name + "] hightlighted and clicked");
    }

    public void waitHighlightAndClickElement(WebElement element, String name){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor='red'", element);
        element.click();
        LOGGER.info("Element [" + name + "] hightlighted and clicked");
    }

    public void waitForElementInvisible(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void clickWebElement (WebElement element, String name){
        LOGGER.info("Click element " + "[" + name +"]");
        waitElement(element);
        element.click();
    }

    public void clickElementByLocator (By locator, String name){
        LOGGER.info("Click element " + "[" + name +"]");
        waitElement(driver.findElement(locator));
        driver.findElement(locator).click();
    }

    public void sendKeysWebElement (WebElement element, String value, String name){
        LOGGER.info("Enter " + "[" + value +"] "+ "to input " +"[" + name +"]");
        waitElement(element);
        element.sendKeys(value);
    }

    public void sendKeysElementByLocator (By locator, String value, String name){
        LOGGER.info("Enter " + "[" + value +"] "+ "to input " +"[" + name +"]");
        waitElement(driver.findElement(locator));
        driver.findElement(locator).sendKeys(value);
    }



}


