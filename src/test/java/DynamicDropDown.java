import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicDropDown {
    public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver","C:/Users/BmahaLakshmi47//Documents//Selenium Practice//chromedriver.exe");
            WebDriver driver=new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
            Thread.sleep(2000);
            driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
            driver.findElement(By.xpath("//a[@value='BLR']")).click();
            Thread.sleep(2000);
            //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
            //Instead of using index as above we can use parent-child traverse
            driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
            Thread.sleep(2000);
            //calendar-ui
            driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
            driver.close();
            driver.quit();
    }
}
