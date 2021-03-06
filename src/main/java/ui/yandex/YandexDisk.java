package ui.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ui.AbstractPage;

import java.util.List;
import java.util.Random;

/**
 * Created by Maryia_Shynkarenka on 6/22/2017.
 */
public class YandexDisk extends AbstractPage {

    @FindBy(xpath = "//a[@data-id='disk']")
    private WebElement disk;

    @FindBy(xpath = "//a[@class='_nb-popup-close js-dialog-close']")
    private WebElement closePopup;

    @FindBy(xpath = "//a[contains(@href,'https://disk.yandex.by')]")
    private WebElement openDisk;

    @FindBy(xpath = "//div[@class='ns-view-container-desc']//img[contains(@class,'resource')]")
    private List<WebElement> pictures;

    private By picturesLocator = By.xpath("//div[@class='ns-view-container-desc']//img[contains(@class,'resource')]");

    @FindBy(xpath = "//div[@class='ns-view-container-desc']/div[last()]")
    private WebElement bin;

    @FindBy(xpath = "//button//span[@class='ui-button-text']")
    private WebElement buttonOpenBin;

    @FindBy(xpath = "//button[@data-metrika-params='actions,with resources,restore,file']")
    private WebElement buttonRestore;

    @FindBy(xpath = "//div[@class='item-details']//span[@class='item-details__content']")
    private WebElement binSize;

    @FindBy(xpath = "//div[@class ='crumbs__path']//div[@class ='crumbs__item'][2]/a")
    private WebElement diskReturn;

    @FindBy(xpath = "//div[@class='b-progressbar__fill']")
    private WebElement loadingBar;

    @FindBy(xpath = "//span[@class='crumbs__current' and text()='Корзина']")
    private WebElement navBin;

    @FindBy(xpath = "//div[contains(@class,'preview')]/div[contains(@class,'nb-checkbox-resource')]")
    private WebElement pictureCheckBox;

    public YandexDisk(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public WebElement getRandomPicture(){
        wait.until(ExpectedConditions.elementToBeClickable(picturesLocator));
        return pictures.get(new Random().nextInt(pictures.size()));
    }

    public List<WebElement> getPictures(){
        return driver.findElements(By.xpath("//div[@class='ns-view-container-desc']//img[contains(@class,'resource')]"));
    }

    public String getElementScr(WebElement picture){
        return picture.getAttribute("src");
    }

    public YandexDisk clickDisk(){
        waitElement(disk);
        disk.click();
        return this;
    }

    public YandexDisk openTheDisk(){
        wait.until(ExpectedConditions.elementToBeClickable(openDisk));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", openDisk);
        return this;
    }


    public YandexDisk movePictureIntoBin(WebElement picture){
        super.dragAndDrop(picture, bin);
        waitElement(By.xpath("//div[@class='notifications__text js-message']"));
        return this;
    }

    public YandexDisk clickBin(){
        waitElement(bin);
        clickWebElement(bin, "Bin");
        return this;
    }

    public YandexDisk clickOpenBinButton(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonOpenBin));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", buttonOpenBin);
        wait.until(ExpectedConditions.elementToBeClickable(navBin));
        return this;
    }

    public YandexDisk clickRestoreButton(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='notifications__text js-message']")));
        clickWebElement(buttonRestore, "Button Restore");
        waitElement(By.xpath("//div[@class='notifications__text js-message']"));
        return this;
    }

    public YandexDisk returnToDisk(){
        waitElement(diskReturn);
        clickWebElement(diskReturn, "Return to disk button");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='crumbs__current' and text()='Корзина']")));
        return this;
    }

    public YandexDisk tickCheckBox(){
        wait.until(ExpectedConditions.elementToBeClickable(picturesLocator));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(picturesLocator)).click(pictureCheckBox).perform();
        return this;
    }
}