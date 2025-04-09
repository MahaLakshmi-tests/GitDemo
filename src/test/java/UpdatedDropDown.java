import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UpdatedDropDown {

        public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver","C:/Users/BmahaLakshmi47//Documents//Selenium Practice//chromedriver.exe");
            WebDriver driver=new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
            System.out.println((driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()));
            driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
            System.out.println((driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()));
            //count number of checkboxes
            System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
            driver.findElement(By.cssSelector("div.paxinfo")).click();
            Thread.sleep(3000);
            System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
            for(int i=1;i<5;i++) {
                driver.findElement(By.id("hrefIncAdt")).click();
            }
            driver.findElement(By.id("btnclosepaxoption")).click();
            System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
            driver.close();
            driver.quit();

    }

}



