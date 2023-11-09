package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebElement Elem = null;
    WebDriverWait wait = null;
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By myAccountLinkSelector = By.linkText("MY ACCOUNT");
    private By emailAddressBox = By.cssSelector("#email");
    private By passwordBox = By.cssSelector("#pass");
    private By loginButtonSelector = By.cssSelector("button[id='send2'] span span");


    public void clickOnMyAccountLink() {
        driver.findElement(myAccountLinkSelector).click();
    }

    public void login(String emailAddress, String password) {
        Elem = driver.findElement(emailAddressBox);
        Elem.clear();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(emailAddressBox, "value", ""));
        Elem.sendKeys(emailAddress);

        Elem = driver.findElement(passwordBox);
        Elem.clear();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(passwordBox, "value", ""));
        Elem.sendKeys(password);

        driver.findElement(loginButtonSelector).click();
    }
}
