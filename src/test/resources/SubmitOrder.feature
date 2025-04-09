Feature: Purchase the order

  Background:
    Given I landed on Ecommerce page

  Scenario Outline: Positive Test of Submitting order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
    Examples:
      |name|password|productName|
      |basireddymahalakshmi.99@gmail.com|maha@123Lakshmi|ZARA COAT 3|
      |basi@gmail.com                   |maha@123Lakshmi|ADIDAS ORIGINAL|


