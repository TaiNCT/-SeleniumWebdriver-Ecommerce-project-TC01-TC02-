package BaiTap.Tc3;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

//import java.io.File;

public class TC3 {
    @Test
    public void Tc3() {
        // 1. init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // 2. open target page
            driver.get("http://live.techpanda.org/index.php/");
            // 3: click on MOBILE menu
            WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
            mobileMenu.click();
            // 4: click Add to cart
            WebElement addToCart =  driver.findElement(By.xpath("//h2[a='Sony Xperia']/following-sibling::div//button[@title='Add to Cart']"));
            addToCart.click();
            // 5: select QTY
            WebElement qty = driver.findElement(By.xpath("//input[@title='Qty']"));
            qty.clear();
            qty.sendKeys("1000");
            // 6: click Update
            WebElement update = driver.findElement(By.xpath("//button[@title='Update']"));
            update.click();
            // 7: verify the error message
            WebElement errorMessage = driver.findElement(By.xpath("//li[@class='error-msg']"));
            String expectedErrorMessage = "The requested quantity for 'Sony Xperia' is not available";
            if(!errorMessage.getText().equals(expectedErrorMessage)){
                System.out.println("Error message is not matched");
            }else{
                System.out.println("Error message is matched");
            }
            // 8: click empty cart
            WebElement emptyCartLink = driver.findElement(By.xpath("//button[@title='Empty Cart']"));
            emptyCartLink.click();
            // 9: verify emty cart
            WebElement emptyCartMessage = driver.findElement(By.xpath("//h1[text()='Shopping Cart is Empty']"));
            if (emptyCartMessage.isDisplayed()) {
                System.out.println("Shopping cart is empty.");
            } else {
                System.out.println("Shopping cart is not empty.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 9. Quit browser session
        driver.quit();
    }
}
