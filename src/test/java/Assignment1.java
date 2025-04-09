import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/BmahaLakshmi47//Documents//Selenium Practice//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("input[name*='Option1']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='Option1']")).isSelected());
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name*='Option1']")).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("input[name*='Option1']")).isSelected());
        Thread.sleep(2000);
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        driver.quit();
    }

}
