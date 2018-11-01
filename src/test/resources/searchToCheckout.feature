@check
Feature: Search to checkout

  As a user I want to search for a product
  When i add the product to basket
  And Proceed for checkout
  Then I should see the product in checkout page

  //Scenario Outline:
    Given I am on the home page
    When I search for a product "<product>"
    And I select any product
    And I add the selected product to trolley
    When I enter my postcode to check stock "<postcode>" and click on collect
    Then I should see the store nearby mentioned postcode
    When I select the particular store "<store>"
    And I select the option "<shopoption>"
    Then I should land on pay now page

    //Examples:
      |product|postcode|store|shopoption|
      |nike   |e6  |eastham|collection|
      |puma   |e6  |barking|delivery  |