package shopping;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForOllieTheAppControlledRobot() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyElements("error message", "Bestsellers", By.xpath("//h1[contains(text(),'Bestsellers')]"));
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Name A - Z')]"));
        mouseHover(By.xpath("//img[@class = 'photo ls-is-cached lazyloaded' and @alt='iPhone 5S']"));
        Thread.sleep(2000);
        mouseHoverAndClick(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-42')]//span[contains(text(),'Add to cart')]"));
        verifyElements("error message", "Product has been added to your cart", By.xpath("//li[@class='info']"));
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("(//a[@class='regular-button cart'])[1]"));
        verifyElements("error message", "Your shopping cart - 1 item", By.xpath("//h1[@id='page-title']"));
        verifyElements("subtotal error message", "299", By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[1]/span[1]/span[1]/span[2]"));
        verifyElements(" total integer error message", "309", By.xpath("//span[contains(text(),'309')]"));
        verifyElements("total decimal error message", "73", By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[4]/span[1]/span[1]/span[4]"));
        clickOnElement(By.xpath("//span[contains(text(),'Go to checkout')]"));
        verifyElements("error message", "Log in to your account", By.xpath("//h3[contains(text(),'Log in to your account')]"));
        sendTextToElement(By.id("email"), "lalita1234=@gmail.com");
        clickOnElement(By.xpath("//span[contains(text(),'Continue')]"));
        verifyElements("error message", "Secure Checkout", By.xpath("(//h1[normalize-space()='Secure Checkout'])[1]"));
        sendTextToElement(By.id("shippingaddress-firstname"), "Lalita");
        sendTextToElement(By.id("shippingaddress-lastname"), "Desia");
        sendTextToElement(By.id("shippingaddress-street"), "31,sea Drive");
        sendTextToElement(By.id("shippingaddress-city"), "London");
        sendTextToElement(By.id("shippingaddress-country-code"), "United Kingdom");
        sendTextToElement(By.id("shippingaddress-custom-state"), "London");
        sendTextToElement(By.id("shippingaddress-zipcode"), "LO1U1");
        sendTextToElement(By.id("shippingaddress-phone"), "+4475689099");
        clickOnElement(By.xpath("//input[@id='create_profile']"));
        sendTextToElement(By.id("password"), "lalit@123");
        clickOnElement(By.id("method128"));
        clickOnElement(By.id("pmethod6"));
        verifyElements("error message", "$311.03", By.xpath("(//span[normalize-space()='$311.03'])[1]"));
        clickOnElement(By.xpath("(//button[@class='btn regular-button regular-main-button place-order submit'])[1]"));


    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyElements("error message","Bestsellers",By.xpath("//h1[contains(text(),'Bestsellers')]"));
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Name A - Z')]"));
        Thread.sleep(2000);
        mouseHover(By.xpath("//a[@class='product-thumbnail next-previous-assigned']/img[@alt='Vinyl Idolz: Ghostbusters']"));
        mouseHoverAndClick(By.xpath("(//button[contains(@class,'regular-button add-to-cart product-add2cart productid-13')])[1]"));
        //mouseHoverAndClick(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-42')]//span[contains(text(),'Add to cart')]"));
        verifyElements("error message","Product has been added to your cart",By.xpath("//li[@class='info']"));
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("(//a[@class='regular-button cart'])[1]"));
        verifyElements("error message","Your shopping cart - 1 item",By.xpath("//h1[@id='page-title']"));
        clickOnElement(By.xpath("(//a[normalize-space()='Empty your cart'])[1]"));
        String message = getTextFromAlert();
        verifyMessageText("Are you sure you want to clear your cart?", message, "Error, Message not displayed as expected");
        Thread.sleep(500);
        acceptAlert();
        Thread.sleep(2000);
        verifyElements("error message","Item(s) deleted from your cart",By.xpath("//li[@class='info']"));
        verifyElements("error","Your cart is empty",By.xpath("//h1[@id='page-title']"));

    }


    @After
    public void tearDown() {
        // closeBrowser();
    }

}
