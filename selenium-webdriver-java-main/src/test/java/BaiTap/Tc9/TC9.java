package BaiTap.Tc9;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POM.AddToCartPage;
import org.testng.Assert;
import driver.driverFactory;

public class TC9 {
    @Test
    public void Tc9() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://live.techpanda.org/");
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        addToCartPage.clickOnMobileMenu();
        addToCartPage.addToCartIphone();
        addToCartPage.enterCouponCode("GURU50");
        System.out.println("Before discount: "+addToCartPage.Price());
        addToCartPage.clickApplyCouponButton();
        System.out.println(""+addToCartPage.disSuccess());
        System.out.println("After discount: "+addToCartPage.DiscountedPrice());
        Assert.assertNotEquals(addToCartPage.DiscountedPrice(), addToCartPage.Price());
        System.out.println("Price is not discounted by 5%");
        driver.quit();
    }
}
