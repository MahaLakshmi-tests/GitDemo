import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssignment {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElements(By.tagName("frame")).size());
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
        driver.quit();
    }
}
