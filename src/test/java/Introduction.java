import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.sound.midi.SysexMessage;

public class Introduction {
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
        driver.getTitle();
        System.out.println(driver.getTitle());
        driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.quit();

        //Firefox launch
        //System.setProperty("wedriver.gecko.driver","");
        //Edge launch
        //System.setProperty("wedriver.edge.driver","");


    }
}
