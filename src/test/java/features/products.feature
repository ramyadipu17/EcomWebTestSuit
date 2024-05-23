Feature: Products Page Validations

Scenario: Verify presence of products on the products page
Given I am logged in and on the inventory page
Then I should see a list of available products

Scenario: Verify sorting functionality on the products page
Given I am logged in and on the inventory page
When I sort the products by price
Then I should see the products sorted by name