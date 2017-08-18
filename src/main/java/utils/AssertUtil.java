package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
    public static void assertEquals(String actual, String expected){
        LOGGER.info("Assert that actual [" + actual + "] equals expected [" + expected + "]");
        Assert.assertEquals(actual, expected);
    }

    public static void assertTrue(Boolean elementPresent){
        LOGGER.info("Assert that element [" + elementPresent + "] is present");
        Assert.assertTrue(elementPresent);
    }

    public static void assertFalse(Boolean elementNotPresent){
        try {
            LOGGER.info("Assert that element [" + elementNotPresent + "] is not present");
            Assert.assertTrue(elementNotPresent);
        } catch (Throwable e){
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
