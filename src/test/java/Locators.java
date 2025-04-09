import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args){
        //Invoke Browser
        //Chrome
        //chromedriver.exe->Chrome Browser
        //step to invoke chrome driver
        //Selenium manager is doing that job
        //other way of doing
        System.setProperty("webdriver.chrome.driver","C:/Users/BmahaLakshmi47//Documents//Selenium Practice//chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        driver.findElement(By.cssSelector("a.register-btn")).click();
        driver.findElement(By.id("email")).sendKeys("");

}
}
