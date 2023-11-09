package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;
    private By myOrder = By.linkText("MY ORDERS");
    private By  viewOrder = By.linkText("VIEW ORDER");
    private By printOrder = By.linkText("Print Order");
    private By reorder = By.linkText("REORDER");
    public void clickMyOrder() {
        driver.findElement(myOrder).click();
    }
    public void clickViewOrder(){
        driver.findElement(viewOrder).click();
    }
    public void clickPrintOrder(){
        driver.findElement(printOrder).click();
    }
    public void clickReOrder(){
        driver.findElement(reorder).click();
    }
}
