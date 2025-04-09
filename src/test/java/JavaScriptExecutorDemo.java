import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import javax.swing.plaf.TableHeaderUI;
import java.util.List;

public class JavaScriptExecutorDemo {

        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:/Users/BmahaLakshmi47//Documents//Selenium Practice//chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            JavascriptExecutor js=(JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)");
            Thread.sleep(5000);
            js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

            List<WebElement> list=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
            int sum=0;
            for(int i=0;i<list.size();i++){
               sum=sum+Integer.parseInt(list.get(i).getText());
            }
            System.out.println("Sum is "+sum);
           int total= Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
            Assert.assertEquals(sum,total);
            driver.quit();

        }
    }
