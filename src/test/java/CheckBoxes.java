import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/BmahaLakshmi47//Documents//Selenium Practice//chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

        //validate if elements are displayed or enabled
        //System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
       // System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
        Thread.sleep(1000);
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
            System.out.println("Its enabled");
            Assert.assertTrue(true);
        }
        else{
            System.out.println("Its disabled");
            Assert.assertFalse(false);
        }
        driver.quit();




    }
}

