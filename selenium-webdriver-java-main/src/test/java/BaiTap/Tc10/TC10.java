package BaiTap.Tc10;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import POM.AdminLogin;
import driver.driverFactory;

public class TC10 {
    @Test
    public void Tc10() {

        WebDriver driver = driverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        try {
            driver.get("http://live.techpanda.org/index.php/backendlogin");
            AdminLogin admin = new AdminLogin(driver);
            admin.login("user01", "guru99com");
            admin.closeMsgBox();
            admin.goToOrders();
            admin.setOrderID("100021250", "1/1/2023", "11/11/2023");
            Thread.sleep(4000);
            TakesScreenshot tc10 = ((TakesScreenshot) driver);
            File srcFile1 = tc10.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile1, new File(
                    "C:\\Users\\ADMIN\\OneDrive\\Máy tính\\Swt301\\selenium-webdriver-java-main\\src\\test\\java\\BaiTap\\Tc10\\Tc10.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}