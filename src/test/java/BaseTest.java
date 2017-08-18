import config.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import utils.Screenshoter;

import java.io.IOException;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public WebDriver init() {

        driver = WebDriverSingleton.getWebDriverInstance();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Screenshoter.takeScreenshot();
        }
    }

    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }
}
