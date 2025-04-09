import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class StreamSort {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/BmahaLakshmi47//Documents//Selenium Practice//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        //click on column
        //capture all webelements into list
        //capture text of all elements into new list
        //sort the new list
        //compare two list
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originalList = items.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> newList = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(originalList.equals(newList));
        driver.quit();
    }

}
