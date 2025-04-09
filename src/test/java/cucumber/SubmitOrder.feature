Feature: Purchase the order from Ecommerce website

  Background:
      Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test of submit order
    Given User logged in with username <username> and password <password>
    When  I add product <productName> to Cart
    And   Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples:
      |username      |password       |productName|
      |maha@gmail.com|maha@123Lakshmi|ZARA COAT 3|