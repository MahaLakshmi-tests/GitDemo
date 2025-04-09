import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CalendarTest {
    public static void main(String[] args) throws InterruptedException {
        String monthNumber = "6";
        String date = "12";
        String year = "2024";
        String[] expected={monthNumber,date,year};
        System.setProperty("webdriver.chrome.driver", "C:/Users/BmahaLakshmi47//Documents//Selenium Practice//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber) - 1).click();
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
        Thread.sleep(2000);
        List<WebElement> list=driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getAttribute("value"));
            Assert.assertEquals(list.get(i).getAttribute("value"),expected[i]);
        }
        driver.quit();
    }
}
