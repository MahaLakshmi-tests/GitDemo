package tests;

import TestComponents.BaseTest;
import TestComponents.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.ConfirmationPage;
import pageObjects.ProductCataloguePage;

import java.io.IOException;

public class ErrorValidations extends BaseTest {

    @Test()
    public void LoginErrorValidation() throws IOException, InterruptedException {
        String productName="ZARA COAT 3";
        String countryName="india";
        landingPage.loginApp("bas@gmail.com","maha@123Lakshmi");
        Assert.assertEquals("Incorrect email password.",landingPage.getErrorMessage());
    }

    @Test
    public void productErrorValidation() throws IOException, InterruptedException {
        String productName="ZARA COAT 3";
        ProductCataloguePage productCataloguePage=landingPage.loginApp("basi@gmail.com","maha@123Lakshmi");
        productCataloguePage.addToCart(productName);
        CartPage cartPage=productCataloguePage.goToCart();
        Boolean match= cartPage.verifyProductName("ZARA COAT 33");
        Assert.assertFalse(match);
    }
}
