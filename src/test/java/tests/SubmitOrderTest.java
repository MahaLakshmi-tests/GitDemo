package tests;

import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {
    String productName="ZARA COAT 3";

      @Test(dataProvider = "getData")
      public void submitOrder(HashMap<String,String>input) throws IOException, InterruptedException {

        String countryName="india";
        //Removing below line as its trggering @BeforeMethod,
        // You can get landing page by declaring it as public in BaseTest
        //LandingPage landingPage= launchApp();
        //As we creating number of objects like CartPage,CheckOutPage we trying to encapsulate it from other tests
       // ProductCataloguePage productCataloguePage=new ProductCataloguePage(driver);
        //placing above in loginApp() because once logged in it redirects to products page
        ProductCataloguePage productCataloguePage=landingPage.loginApp(input.get("email"),input.get("password"));
        productCataloguePage.addToCart(input.get("productName"));
        CartPage cartPage=productCataloguePage.goToCart();
        Boolean match= cartPage.verifyProductName(input.get("productName"));
        Assert.assertTrue(match);
        CheckOutPage checkOutPage=cartPage.goToCheckOut();
        checkOutPage.selectCountry(countryName);
        ConfirmationPage confirmationPage=checkOutPage.submitOrder();
        String confirmationMessage=confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));

    }
   @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistory(){
       ProductCataloguePage productCataloguePage=landingPage.loginApp("basi@gmail.com","maha@123Lakshmi");
       OrderPage orderPage=productCataloguePage.goToOrdersPage();
       //goToOrdersPage is returning OrderPage so OrderPage orderPage=productCataloguePage.goToOrdersPage();
       Assert.assertTrue(orderPage.verifyOrderDisplay(productName));

    }
//    @DataProvider
//    public Object[][] getData(){
//        return  new Object[][]{{"basi@gmail.com","maha@123Lakshmi","ZARA COAT 3"},{"maha@gmail.com","maha@123Lakshmi","ZARA COAT 3"}};
//    }

//    @DataProvider
//    public Object[][]  getData(){
//          HashMap<String,String> map=new HashMap<String,String>();
//          map.put("email","basi@gmail.com");
//          map.put("password","maha@123Lakshmi");
//          map.put("productName","ZARA COAT 3");
//        HashMap<String,String> map1=new HashMap<String,String>();
//        map1.put("email","maha@gmail.com");
//        map1.put("password","maha@123Lakshmi");
//        map1.put("productName","ADIDAS ORIGINAL");
//        return new Object[][]{{map},{map1}};
//      }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String,String>> data=  getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\Purchase.json");
        return new Object[][]{{data.get(0)},{data.get(1)}};
    }
}
