
Feature: Test the manager login functionality
  I want to use this template for my feature file
  Background:
  Given Landed on the home page
  Scenario Outline: Test the manager login with valid inputs
    Given Click on the manager login button
    When Click on the add customer button and fill the deatils <Fname> , <Lname> and <pinCode> and click on the add button
    And  Click on the open account button and select user <user> and currency <currency> and click on the process button
    And  Click on the customers button and search the customer <customer>
    Then  Delete the recently added customer
    

    Examples: 
      | Fname  | Lname | pinCode  | user         | currency| customer|
      | Shivendra |  Pratap | 23456    | Harry Potter |  Rupee  | Harry   |
      
