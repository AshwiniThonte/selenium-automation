Feature: Search
  As a end user
  I want to search for a product
  So that i can view respective products


 # @smoke @live
  @search
  Scenario Outline: valid search
    Given I am on the home page
    When I search for a product "<searchTerm>"
    Then I should see all products of "<searchTerm>"

   Examples:
     |searchTerm|
     |Nike|
#     |puma|
#     |adidas|
#     |sony  |



