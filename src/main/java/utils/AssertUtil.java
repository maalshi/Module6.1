package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ui.AbstractPage;

import java.util.List;

public class AssertUtil {

    private static Logger LOGGER = Logger.getLogger(AssertUtil.class);

    public static void assertListContainsElementWithSrc(String src, List<WebElement> webElements){
        for(WebElement picture: webElements){
            if(picture.getAttribute("src").equals(src))
                return;
        }
        Assert.fail("Element with src [" + src + "]\nis not present in the list");
    }

    public static void assertListNotContainElementWithSrc(String src, List<WebElement> webElements){
        for(WebElement picture: webElements){
            if(picture.getAttribute("src").equals(src))
                Assert.fail("Element with src [" + src + "]\nis present in the list");
        }
    }

    //Decorator
    public static void assertEquals(String actual, String expected) {
        try {
            LOGGER.info("Assert that actual [" + actual + "] equals expected [" + expected + "]");
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            Screenshoter.takeScreenshot();
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void assertTrue(Boolean elementPresent, String message) {
        try {
            LOGGER.info(message);
            Assert.assertTrue(elementPresent);
        } catch (Throwable e) {
            Screenshoter.takeScreenshot();
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void assertFalse(Boolean elementNotPresent, String message){
        try {
            LOGGER.info(message);
            Assert.assertTrue(elementNotPresent);
        } catch (Throwable e){
            Screenshoter.takeScreenshot();
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
