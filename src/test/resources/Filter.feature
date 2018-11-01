@filter
Feature: filter by user preference

  As a user
  I want to filter products
  So that i want to only see the products of selected filter

  @filterreview
  Scenario Outline: Filtering products based on review
    Given I am on the home page
    When I search for a product "nike"
    And I click on filter option "<reviewFilter>" review
    Then I should see all products of review "<reviewFilter>"
    Examples:
    |reviewFilter|
    |5only       |
#    |4or more    |
#    |3or more    |
#    |2or more    |

  @filterprice
    Scenario Outline: Filtering products based on price
      Given I am on the home page
      When I search for a product "nike"
      And I click on filter option "<priceFilter>" price
      Then I should see all products with price "<priceFilter>"
      Examples:
        |priceFilter|
        |£5 - £10   |
#        |£10 - £15  |
#        |£15 - £20  |

#Sort By option
#Feature: Sort
#
#  As a end user
#  I want to sort products by price:low to high,price:high to low,customer rating
#  So that I want to see only sorted products

  @filtersort
  Scenario Outline: Sorting products based on price[Low to High or High to Low]
    Given I am on the home page
    When I search for a product "nike"
    And I click on sort by option for "<sortByOption>"
    Then I should see all products in ascending order of price "<sortByOption>"
   Examples:
    |sortByOption|
    |Price: Low - High|
    |Price: High - Low|



