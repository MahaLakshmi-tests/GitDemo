import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AutoSuggestiveDropDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/BmahaLakshmi47//Documents//Selenium Practice//chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.cssSelector("input#autosuggest")).sendKeys("ind");
        Thread.sleep(2000);
        List<WebElement> options=driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        for(WebElement option:options){
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }
    }
}
