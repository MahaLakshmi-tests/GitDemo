import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SeleniumCartTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/BmahaLakshmi47//Documents//Selenium Practice//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String[] items = {"cucumber", "Brocolli", "Beetroot", "Tomato"};
        WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        addItems(driver, items);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));
        driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
        driver.quit();
    }

    public static void addItems(WebDriver driver, String[] items) {
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            //convert array into array list
            //check whether name you etxracted is present in array or not
            List arrayList = Arrays.asList(items);
            if (arrayList.contains(formattedName)) {
                j++;
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

                if (j == items.length) {
                    break;
                }
            }
        }
    }
}