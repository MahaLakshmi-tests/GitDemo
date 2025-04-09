package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends AbstractComponent {

    WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    By selectCountryInput=By.cssSelector("[placeholder='Select Country']");

    @FindBy(css="[placeholder='Select Country']")
    WebElement selectCountry;

    By searchResults=By.cssSelector(".ta-results");

    @FindBy(css=".ta-item:nth-of-type(2)")
    WebElement country;

    @FindBy(css=".action__submit")
    WebElement submitOrder;

    public void selectCountry(String countryName) throws InterruptedException {
        waitForElementToClick(selectCountryInput);
        Thread.sleep(3000);
        Actions a=new Actions(driver);
        a.sendKeys(selectCountry,countryName).build().perform();
        waitForElementToAppear(searchResults);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", country);
    }

   public ConfirmationPage submitOrder(){
       JavascriptExecutor js=(JavascriptExecutor) driver;
       js.executeScript("arguments[0].click();", submitOrder);
//       ConfirmationPage confirmationPage=new ConfirmationPage(driver);
//       return confirmationPage;
       //other way
       return new ConfirmationPage(driver);
   }

}
