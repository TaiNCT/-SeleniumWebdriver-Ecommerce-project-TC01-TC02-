package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLogin {
    private WebDriver driver;
    private WebDriverWait wait;

    public AdminLogin(WebDriver driver) {
        this.driver = driver;
    }

    private final By Username = By.id("username");
    private final By Password = By.id("login");
    private final By SubmitBtn = By.cssSelector("input[type='submit']");
    private final By CloseBtn = By.cssSelector("a[title='close'] span");
    private final By NavBar = By.id("nav");
    private final By DBSales = By.linkText("Sales");
    private final By Orders = By.linkText("Orders");

    private final By orderID = By.id("sales_order_grid_filter_real_order_id");
    private final By fromDate = By.name("created_at[from]");
    private final By toDate = By.name("created_at[to]");
    private final By search = By.xpath("//button[@title='Search']");
    public void login(String username, String password) {
        driver.findElement(Username).sendKeys(username);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(SubmitBtn).click();
    }

    public void closeMsgBox() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CloseBtn)).click();
    }

    public void goToOrders() {
        driver.findElement(NavBar).findElement(DBSales).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Orders)).click();
    }

    public void setOrderID(String id, String from, String to) {
        WebElement order = driver.findElement(orderID);
        WebElement fromD = driver.findElement(fromDate);
        WebElement toD = driver.findElement(toDate);
        order.clear();
        fromD.clear();
        toD.clear();
        order.sendKeys(id);
        fromD.sendKeys(from);
        toD.sendKeys(to);
        driver.findElement(search).click();
    }
}
