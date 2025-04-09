package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="userEmail")
    WebElement username;

    @FindBy(id="userPassword")
    WebElement password;

    @FindBy(id="login")
    WebElement login;

    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;

    public ProductCataloguePage loginApp(String userName, String userPassword){
        username.sendKeys(userName);
        password.sendKeys(userPassword);
        login.click();
        ProductCataloguePage productCataloguePage=new ProductCataloguePage(driver);
        return productCataloguePage;
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }

    public String getErrorMessage(){
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    }
