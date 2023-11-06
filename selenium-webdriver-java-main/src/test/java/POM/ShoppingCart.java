package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {
    private WebDriver driver;
    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
    }
    private By qty = By.xpath("//input[@title='Qty']");
    private By grandTotal = By.cssSelector("strong span[class='price']");
    private By update = By.xpath("//button[@title='Update']");
    public void setQty(String number){
        WebElement qtyElement = driver.findElement(qty);
        qtyElement.click();
        qtyElement.clear();
        qtyElement.sendKeys(number);
    }
    public String getGrandTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(grandTotal)).getText();
    }
    public void clickUpdate(){
        driver.findElement(update).click();
    }
}
