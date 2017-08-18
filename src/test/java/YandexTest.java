import businessobjects.Constants;
import businessobjects.YandexLogin;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.yandex.Yandex;
import ui.yandex.YandexDisk;
import utils.AssertUtil;

import java.util.List;

/**
 * Created by Maryia_Shynkarenka on 6/21/2017.
 */
public class YandexTest extends BaseTest {


    @Test
    public void trashTest() {
        driver.get("https://yandex.by");
        Yandex yandex = new Yandex(driver);
        //yandex.sendKeysLogin("maria1.tester");
        //yandex.sendKeysPassword("Password1");
        yandex.yandexLogin(new YandexLogin(Constants.LOGIN_YANDEX, Constants.PASSWORD));
        yandex.clickSubmitButton();

        YandexDisk disk = new YandexDisk(driver);
        disk.clickDisk()
                .openTheDisk();

        WebElement randomPicture = disk.getRandomPicture();
        String pictureSrc = disk.getElementScr(randomPicture);

        AssertUtil.assertListContainsElementWithSrc(pictureSrc, disk.getPictures());
        disk.movePictureIntoBin(randomPicture);
        AssertUtil.assertListNotContainElementWithSrc(pictureSrc, disk.getPictures());
        disk.clickBin()
                .clickOpenBinButton();
        AssertUtil.assertListContainsElementWithSrc(pictureSrc, disk.getPictures());
        disk.tickCheckBox()
                .clickRestoreButton();
        AssertUtil.assertListNotContainElementWithSrc(pictureSrc, disk.getPictures());
        disk.returnToDisk();
        AssertUtil.assertListContainsElementWithSrc(pictureSrc, disk.getPictures());
    }
}