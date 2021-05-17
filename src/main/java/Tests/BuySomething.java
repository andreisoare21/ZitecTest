package Tests;

import Misc.BrowserFactory;
import Pages.CheckoutPage;
import Pages.MainPage;
import Pages.ProductPage;
import Pages.WomenPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuySomething {

    WebDriver driver;

    @Test
    public void buy() {
        //Initialize driver
        //Select which browser to use
        //Set URL
        driver = BrowserFactory.startBrowser(driver, "Chrome", "http://automationpractice.com/index.php");

        //Initialize JavaFaker to generate test data
        Faker faker = new Faker();

        //Initialize necessary pages
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        WomenPage womenPage = PageFactory.initElements(driver, WomenPage.class);
        CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);

        Assert.assertTrue(mainPage.getWomenButton().isDisplayed());
        mainPage.openWomenPage();

        Assert.assertTrue(womenPage.getFirstProduct().isDisplayed());
        womenPage.openFirstProduct();

        productPage.switchToIframe();
        Assert.assertTrue(productPage.getIncreaseQuantity().isDisplayed());
        Assert.assertTrue(productPage.getAddToCart().isDisplayed());
        float productPrice = 2 * productPage.getProductPrice();

        productPage.setIncreaseQuantity();
        productPage.setAddToCart();

        String success = productPage.getSuccessMessage();
        float finalPrice = productPage.getTotalProductsPrice();
        Assert.assertEquals(productPrice, finalPrice);
        Assert.assertEquals(success, "There are 2 items in your cart.");

        Assert.assertTrue(productPage.getContinueShopping().isDisplayed());
        Assert.assertTrue(productPage.getProceedToCheckout().isDisplayed());
        productPage.setProceedToCheckout();

        Assert.assertTrue(checkoutPage.getProceedToCheckout().isDisplayed());
        checkoutPage.clickProceedToCheckout();

        Assert.assertTrue(checkoutPage.getEmailField().isDisplayed());
        Assert.assertTrue(checkoutPage.getCreateAccount().isDisplayed());
        checkoutPage.setCreateAccount(faker.name().firstName() + faker.name().lastName() + "@mailinator.com");

        Assert.assertTrue(checkoutPage.getSelectGender().isDisplayed());
        Assert.assertTrue(checkoutPage.getCustomerFirstName().isDisplayed());
        Assert.assertTrue(checkoutPage.getCustomerLastName().isDisplayed());
        Assert.assertTrue(checkoutPage.getCustomerPassword().isDisplayed());
        Assert.assertTrue(checkoutPage.getDeliveryFirstName().isDisplayed());
        Assert.assertTrue(checkoutPage.getDeliveryLastName().isDisplayed());
        Assert.assertTrue(checkoutPage.getDeliveryAddress().isDisplayed());
        Assert.assertTrue(checkoutPage.getDeliveryCity().isDisplayed());
        checkoutPage.fillPersonalInfo(faker.name().firstName(),faker.name().lastName(),faker.internet().password());
        checkoutPage.fillPersonalInfo(faker.address().fullAddress(), faker.address().cityName(),4,"12345",faker.phoneNumber().cellPhone());

        Assert.assertTrue(checkoutPage.getAdvanceToShipping().isDisplayed());
        checkoutPage.setAdvanceToShipping();

        checkoutPage.setAcceptTerms();
        checkoutPage.setAdvanceToPayment();

        Assert.assertTrue(checkoutPage.getSelectPaymentMethod().isDisplayed());
        checkoutPage.setSelectPaymentMethod();

        Assert.assertTrue(checkoutPage.getConfirmOrder().isDisplayed());
        checkoutPage.setConfirmOrder();

        Assert.assertTrue(checkoutPage.getOrderConfirmation().isDisplayed());
        String orderConfirmation = checkoutPage.verifyPlaceOrder();
        Assert.assertEquals(orderConfirmation, "Your order on My Store is complete.");

        BrowserFactory.quitBrowser(driver);

    }
}
