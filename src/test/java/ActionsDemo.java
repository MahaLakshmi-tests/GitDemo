import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ActionsDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        Actions a=new Actions(driver);
//        Thread.sleep(2000);
    //        WebElement move=driver.findElement(By.cssSelector("a[class='spiceFare']:nth-child(1)"));
//        //move to specific element
//        a.moveToElement(move).build().perform();
//        driver.quit();

        //composite actions
        driver.get("https://www.google.com/");
        Actions a=new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//textarea[@class='gLFyf']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        Thread.sleep(2000);
        driver.quit();

    }
}
