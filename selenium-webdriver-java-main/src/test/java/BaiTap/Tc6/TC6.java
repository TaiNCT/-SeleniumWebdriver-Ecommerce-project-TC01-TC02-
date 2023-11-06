package BaiTap.Tc6;

import POM.CartPage;
import POM.CheckOutPage;
import POM.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import driver.driverFactory;

import java.time.Duration;

public class TC6 {
    @Test
    public void Tc06() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://live.techpanda.org/");
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckOutPage checkoutPage = new CheckOutPage(driver);

        loginPage.clickOnMyAccountLink();
        loginPage.login("tai@gmail.com", "123456");

        cartPage.clickOnMyWishlistLink();
        cartPage.clickOnMyAddToCartLink();
        cartPage.enterShippingInformation("United States", "New York", "123456");
        cartPage.clickOnEstimateLink();

        String shippingCost = cartPage.getShippingCost();
        System.out.println("Shipping cost: " + shippingCost);

        cartPage.selectShippingCost();

        cartPage.updateTotalCost();
        String totalCost = cartPage.getTotalCost();
        System.out.println("Total cost: " + totalCost);

        checkoutPage.clickProceedToCheckout();
        checkoutPage.clickNewAddress();
        checkoutPage.enterBillingInformation("New Address", "Tai",
                "Thanh", "Nguyen", "FPT", "24",
                "SCK", "AlieZ", "New York", "123456",
                "United States", "1234567890", "654321");

        checkoutPage.clickShippingAddress();
        checkoutPage.enterBillingInformation("New Address", "Tai",
                "Thanh", "Nguyen", "FPT", "24",
                "SCK", "AlieZ", "New York", "123456",
                "United States", "1234567890", "654321");
        checkoutPage.click();

        checkoutPage.selectShippingMethod();

        checkoutPage.selectPaymentMethod();

        checkoutPage.clickPaymentInfo();

        checkoutPage.clickPlaceOrder();

        String expectedMessage = "THANK YOU FOR YOUR PURCHASE!";
        String actualMessage = checkoutPage.getOrderRecievedMessage();
        assert actualMessage.equals(expectedMessage) : "Order failed!";
        System.out.println("Order sent succeed");

        String orderNumber = checkoutPage.getOrderNumber();
        System.out.println(orderNumber);

        driver.quit();
    }
}
