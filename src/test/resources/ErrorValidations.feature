Feature: Error Validations

  Background:
    Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Negative test with invalid login creds
    Given Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed


    Examples:
      |name|password|
      |basireddymahalakshmi.99@gmail.com|maha@123Lakshm|


