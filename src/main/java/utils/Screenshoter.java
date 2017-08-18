package utils;

import config.WebDriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshoter {
    private static final String SCREENSHOTS_NAME_TPL = "screenshots/scr";
    private static Logger LOGGER = Logger.getLogger(Screenshoter.class);

    public static void takeScreenshot() {
        WebDriver driver = WebDriverSingleton.getWebDriverInstance();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenshotName + ".png");
            FileUtils.copyFile(screenshot, copy);
            LOGGER.info("Saved screenshot: " + screenshotName);
        } catch (IOException e) {
            LOGGER.error("Failed to make screenshot");
        }
    }
}
