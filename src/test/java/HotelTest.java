import org.testng.Assert;
import org.testng.annotations.Test;
import ui.HotelPages.HotelPage;
import ui.HotelPages.PlanPage;
import ui.aerlpages.Homepage;
import utils.AssertUtil;

public class HotelTest extends BaseTest {

    @Test
    public void verifyHotels() {
        driver.get("https://www-deva2.aerlingus.com/html/en-US/home.html");
        Homepage homepage = new Homepage(driver);
        homepage.clickTabHotel();
        String winHandleBefore = driver.getWindowHandle();
        homepage.clickButtonViewHotels();
        for (String winHandle : driver.getWindowHandles()) {
            if (!winHandle.equals(winHandleBefore)) {
                driver.switchTo().window(winHandle);
            }
        }
    }

    @Test(dependsOnMethods = {"verifyHotels"}, alwaysRun = true)
    public void assertText() {
        HotelPage hotelPage = new HotelPage(driver);
        Assert.assertEquals(hotelPage.verifyHotelsText(), "Hotels");
        Assert.assertEquals(hotelPage.verifyNewHotelsPartnerText(),"New Hotels partner coming soon!");
        Assert.assertEquals(hotelPage.verifyWerePartneringText(),"We are partnering with one of the world's leading accommodation suppliers with over a million properties throughout 225 countries worldwide.You can also look forward to superior booking functionality and payment options, and customer service tailored to your needs.\n" +
                "Flights and hotels sorted!" );
        Assert.assertEquals(hotelPage.verifyWereChangingText(),"We're changing our Hotels partner");
        hotelPage.clickButtonSearchFlights();
        PlanPage planPage = new PlanPage(driver);
        AssertUtil.assertEquals(planPage.verifyTextBookFlights(), "Book Flights");
    }
}






