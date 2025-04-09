import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/BmahaLakshmi47//Documents//Selenium Practice//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //1.count number of links in the page
        System.out.println(driver.findElements(By.tagName("a")).size());
        //2.count number of links in footer driver
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());
        //3.Count number of links in column of first footer driver
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());
        //4.click on each link in column and check if the pages are opening
        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
            String click = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(click);
            Thread.sleep(5000L);
        }
        //5.Get title of child tabs
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }

}
