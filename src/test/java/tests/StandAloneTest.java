package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.LandingPage;

import javax.swing.*;
import java.util.List;

import java.time.Duration;

public class StandAloneTest {
    public static void main(String[] args) throws InterruptedException {
        String productName="ADIDAS ORIGINAL";
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");
        driver.findElement(By.id("userEmail")).sendKeys("basi@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("maha@123Lakshmi");
        driver.findElement(By.id("login")).click();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));

        WebElement prod=products.stream().filter(product->
                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));


        //ng-animating icon to disappear
        //performance issue so lets use other
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();

        List<WebElement> cartProducts=  driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);

        js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(".totalRow button")));
        //driver.findElement(By.cssSelector(".totalRow button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[placeholder='Select Country']")));
      //  WebElement country=driver.findElement(By.cssSelector("[placeholder='Select Country']"));
        Thread.sleep(5000);
//       js.executeScript("arguments[0].value='india';", country);
//        js.executeScript("arguments[0].dispatchEvent(new Event('input'));", country);
        Actions actions=new Actions(driver);
        actions.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
//         WebElement country=driver.findElement(By.cssSelector("[placeholder='Select Country']"));
//         actions.moveToElement(country).click().perform();
//         actions.sendKeys(country,"india").perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

       js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")));
        //css-->.ta-item:nth-of-type(2)
       //driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
        js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(".action__submit")));
        //driver.findElement(By.cssSelector(".action__submit")).click();
        String confirmationMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));
        driver.close();
        driver.quit();
    }
}
