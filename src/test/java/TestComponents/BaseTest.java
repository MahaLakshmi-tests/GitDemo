package TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LandingPage landingPage;

    public WebDriver initializeDriver() throws IOException {

        //initialization code
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//GlobalData.properties");
        prop.load(fis);
        //to read value coming from maven we should pass below
        String browserName=System.getProperty("browser")!=null? System.getProperty("browser"): prop.getProperty("browser");
        //for now by default we reading from GlobalData.properties file

        //String browserName= prop.getProperty("browser");
        if(browserName.contains("chrome")) {
            //run in headless mode
            ChromeOptions options=new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if(browserName.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));//full screen mode
        } else if (browserName.equalsIgnoreCase("edge")) {
            //edge code
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        //1.read json to String
        String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
        //2.String to Hashmap-jackson databind
        ObjectMapper mapper=new ObjectMapper();
        List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
        });
        //list with two hashmaps
        return data;
    }



  public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
     TakesScreenshot ts= (TakesScreenshot)driver;
     File source=ts.getScreenshotAs(OutputType.FILE);
     File file =new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
     FileUtils.copyFile(source,file);
     return System.getProperty("user.dir")+"//results//"+testCaseName+".png";
  }

    @BeforeMethod(alwaysRun = true)
   public LandingPage launchApp() throws IOException {
        driver=initializeDriver();
        //the below is generic for any test so we placing in BaseTest
        landingPage=new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
   }

   @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
   }
}

//java -jar jenkins.war -httpPort=9090