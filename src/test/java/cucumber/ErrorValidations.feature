Feature: Error Validations

  Scenario Outline: Error Validations for Invalid Creds
    Given I landed on Ecommerce Page
    When User logged in with username <username> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples:
      |username      |password       |
      |mah@gmail.com|maha@123Lakshmi |