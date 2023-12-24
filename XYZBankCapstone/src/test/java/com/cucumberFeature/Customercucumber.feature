
Feature: Test the customer login functionality of XYZ Bank
  I want to use this template for my feature file

   Background:
   Given user landed on the home page

  Scenario Outline: Test customer login with valid inputs
    Given User click on the CustomerLogin button
    When User select the name <name> from dropdown and click on login button 
    And User click on the Deposite button and fill deposite amount <amount> and click deposite button
    And user click on the Withdrawl button and fill withdrawl amount <withdrawl> and click withdrawl button
    And User click on the transaction button and get all details 
    And User click on the logout button
    Then User redirected to the Home page

    Examples: 
      | name         | amount | withdrawl  |
      | Harry Potter | 1000   | 500        |
      
