import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/BmahaLakshmi47//Documents//Selenium Practice//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Java methods to call urls to get status code
        //step-1 get all urls tied up to links using selenium
        //step-2 is status code>400 then url is not working which means link is broken
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        String url=driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
//        HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
//        conn.setRequestMethod("HEAD");
//        conn.connect();
//        int responseCode= conn.getResponseCode();
//        System.out.println(responseCode);
//        driver.quit();

        //iterate over all links
        List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a =new SoftAssert();
        for(WebElement link:links){
           String url=link.getAttribute("href");
           HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
           conn.setRequestMethod("HEAD");
           conn.connect();
           int responseCode= conn.getResponseCode();
           a.assertTrue(responseCode<400,"The link with Text "+link.getText()+" is broken with "+responseCode);

        }
        a.assertAll();
        driver.quit();

    }
}
