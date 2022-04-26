package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() {
        //1.1 Click on the “Shipping” link
        clickOnElement(By.linkText("Shipping"));
        //Verify the text “Shipping”
        verifyElements("Shipping Texts does not match", "Shipping", By.id("page-title"));

    }

    @Test  //verifyUserShouldNavigateToNewPageSuccessfully()
    public void verifyUserShouldNavigateToNewPageSuccessfully() {
        //Click on the “New!” link
        clickOnElement(By.linkText("New!"));
        //Verify the text “New arrivals”
        verifyElements("New Texts Does Not Match", "New arrivals", By.id("page-title"));
    }

    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() {
        //click on element
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/descendant::span[contains(text(),'Coming soon')]"));
        //validate text
        verifyElements("Not Matching", "Coming soon", By.xpath("//h1[@id='page-title']"));
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() {
        //click on element
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/descendant::span[contains(text(),'Contact us')]"));
        verifyElements("Not Matching", "Contact us", By.xpath("//h1[@id='page-title']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
