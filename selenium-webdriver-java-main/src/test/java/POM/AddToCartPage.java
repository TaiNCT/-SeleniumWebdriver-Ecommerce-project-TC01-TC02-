package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage{
    private WebDriver driver;
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By mobileMenu = By.linkText("MOBILE");
    private final By addToCartIphone = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(2) > div:nth-child(4) > button:nth-child(1)");
    private final By couponCodeInput = By.cssSelector("input[name='coupon_code']");
    private final By applyCouponButton = By.cssSelector("button[value='Apply']");
    private final By totalPrice = By.cssSelector("strong span[class='price']");
    private final By dis = By.xpath("//li[@class='success-msg']/ul/li/span");


    public String disSuccess(){
       return driver.findElement(dis).getText().toString();
    }
    public void clickOnMobileMenu() {
        driver.findElement(mobileMenu).click();
    }

    
    public void addToCartIphone() {
        driver.findElement(addToCartIphone).click();
    }

   
    public void enterCouponCode(String code) {
        driver.findElement(couponCodeInput).sendKeys(code);
    }

    public void clickApplyCouponButton() {
        driver.findElement(applyCouponButton).click();
    }

   
    public double Price() {
        return Double.parseDouble(driver.findElement(totalPrice).getText().replace("$", ""));
    }

    public double DiscountedPrice() {
        return Double.parseDouble(driver.findElement(totalPrice).getText().replace("$", ""));
    }
}