Feature: Increase the quantity of selected product and checking price in trolly page

  As a user
  I want to increase product quantity in trolly page
  So that i want to view the increased priced for the product

  @prodCountIncrease @live
  Scenario: Increase product quantity
    Given I am on the home page
    When I search for a product "nike"
    And I select any product
    And I add the selected product to trolley
    And I go to trolley
    When I increase the quantity of product "3"
    Then i should see the corresponding increase in price for that product