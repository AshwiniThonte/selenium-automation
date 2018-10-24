Feature: Search to basket test

  As a user
  I want to search for product and add to basket
  So that i can view added product in basket
@searchtobasket
  Scenario: Add a product to Basket
    Given I am on the home page
    When I search for a product "nike"
    And I select any product
    And I add the selected product to trolley
    And I go to trolley
    Then I should see the product in trolley