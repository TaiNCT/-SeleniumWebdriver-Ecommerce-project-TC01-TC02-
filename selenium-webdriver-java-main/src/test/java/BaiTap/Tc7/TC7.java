package BaiTap.Tc7;

import POM.LoginPage;
import POM.MyAccountPage;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC7 {
    @Test
    public void Tc7() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://live.techpanda.org/");
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage accountPage = new MyAccountPage(driver);

        loginPage.clickOnMyAccountLink();
        loginPage.login("tai@gmail.com", "123456");
        accountPage.clickMyOrder();
        accountPage.clickViewOrder();
        accountPage.clickPrintOrder();
        driver.quit();
    }
}
