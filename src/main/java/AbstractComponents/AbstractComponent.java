package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CartPage;
import pageObjects.OrderPage;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;
    public AbstractComponent(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="button[routerlink*='cart']")
    WebElement cartHeader;

    @FindBy(css="button[routerlink*='myorders']")
    WebElement orderHeader;

    public void waitForElementToAppear(By findBy) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
  }

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }
    public void waitForElementToDisappear(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }
    public void waitForElementToClick(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }
    public CartPage goToCart(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",cartHeader);
        CartPage cartPage=new CartPage(driver);
        return cartPage;
    }
    public OrderPage    goToOrdersPage(){
        orderHeader.click();
        OrderPage orderPage=new OrderPage(driver);
        return orderPage;
    }

}