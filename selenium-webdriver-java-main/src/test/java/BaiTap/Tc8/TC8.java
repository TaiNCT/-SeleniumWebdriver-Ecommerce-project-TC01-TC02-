package BaiTap.Tc8;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POM.CheckOutPage;
import POM.LoginPage;
import POM.MyAccountPage;
import POM.ShoppingCart;
import driver.driverFactory;

public class TC8 {
     @Test
    public void Tc7() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://live.techpanda.org/");
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage accountPage = new MyAccountPage(driver);
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        CheckOutPage checkoutPage = new CheckOutPage(driver);
        loginPage.clickOnMyAccountLink();
        loginPage.login("tai@gmail.com", "123456");
        accountPage.clickReOrder();
        String before = shoppingCart.getGrandTotal();
        System.out.println("Before update: "+before);
        shoppingCart.setQty("10");
        shoppingCart.clickUpdate();
        String after = shoppingCart.getGrandTotal();
        System.out.println("After update: "+after);
        if(!before.equals(after)){
            System.out.println("Grand Total has Change");
        }
        checkoutPage.clickProceedToCheckout();

        checkoutPage.enterBillingInformation("New Address", "Tai",
                "Thanh", "Nguyen", "FPT", "24",
                "SCK", "AlieZ", "New York", "123456",
                "United States", "1234567890", "654321");

        checkoutPage.enterBillingInformation("New Address", "Tai",
                "Thanh", "Nguyen", "FPT", "24",
                "SCK", "AlieZ", "New York", "123456",
                "United States", "1234567890", "654321");

        checkoutPage.selectShippingMethod();
        checkoutPage.selectPaymentMethod();
        checkoutPage.clickPaymentInfo();
        checkoutPage.clickPlaceOrder(); 
        String expectedMessage = "THANK YOU FOR YOUR PURCHASE!";
        String actualMessage = checkoutPage.getOrderRecievedMessage();
        if(expectedMessage.equals(actualMessage)){
            System.out.println("Order sent succeed");
        }else{
            System.out.println( "Order failed!");
        }
        String orderNumber = checkoutPage.getOrderNumber();
        System.out.println(orderNumber);

        driver.quit();
    }
}
