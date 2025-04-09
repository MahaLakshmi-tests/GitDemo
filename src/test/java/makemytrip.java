import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class makemytrip {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/BmahaLakshmi47//Documents//Selenium Practice//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/flights/");
        Thread.sleep(2000);
//        System.out.println(driver.findElement(By.cssSelector("div[class='flt_fsw_inputBox dates reDates inactiveWidget ']")).isEnabled());
        driver.findElement(By.cssSelector("li[data-cy='oneWayTrip']")).click();
        Thread.sleep(2000);
//        System.out.println(driver.findElement(By.cssSelector("div[class='flt_fsw_inputBox dates reDates inactiveWidget  ']")).isEnabled());
        System.out.println(driver.findElement(By.cssSelector("div[class*='reDates']")).getAttribute("class"));
        if(driver.findElement(By.cssSelector("div[class*='reDates']")).getAttribute("class").contains("flt_fsw_inputBox dates reDates inactiveWidget  ")){
            System.out.println("its enabled");
        }
        else{
            System.out.println("its disabled");
        }
        driver.quit();
        driver.close();
    }

}
