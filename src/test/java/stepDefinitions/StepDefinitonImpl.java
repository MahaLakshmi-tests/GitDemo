package stepDefinitions;

import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.*;

import java.io.IOException;

public class StepDefinitonImpl extends BaseTest {

    public LandingPage landingPage;
    public ProductCataloguePage productCataloguePage;
    public ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException {
     landingPage=launchApp();
    }

    @Given("^User logged in with username (.+) and password (.+)$")
    public void logged_in_with_username_and_password(String username,String password){
        productCataloguePage=landingPage.loginApp(username,password);
    }

    @When("^I add product (.+) to Cart$")
    public void add_product_to_cart(String productName){

        productCataloguePage.addToCart(productName);
    }

    @And("^Checkout (.+) and submit the order$")
    public void checkout_and_submit_the_order(String productName) throws InterruptedException {
        String countryName="india";
        CartPage cartPage=productCataloguePage.goToCart();
        Boolean match= cartPage.verifyProductName(productName);
        Assert.assertTrue(match);
        CheckOutPage checkOutPage=cartPage.goToCheckOut();
        checkOutPage.selectCountry(countryName);
        confirmationPage=checkOutPage.submitOrder();
    }

    //only for Examples we must use (.+) starts with ^ and ends with $
    //In case of string enclose it in curly braces

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_is_displayed_on_confirmationpage(String string){
        String confirmationMessage=confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmationMessage.equalsIgnoreCase(string));
        driver.close();
    }

    @Then("{string} message is displayed")
    public void error_message_is_displayed(String string){
        Assert.assertEquals(string,landingPage.getErrorMessage());
        driver.close();
    }





}
