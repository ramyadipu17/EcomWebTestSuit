Feature: Add to Cart Functionality

Scenario: Add an item to the cart
Given I am logged in and on the inventory page
When I add the "Sauce Labs Backpack" to the cart
Then the item should be added to the cart successfully

Scenario: Add multiple items to the cart
Given I am logged in and on the inventory page
When I add multiple items to the cart:
Then all the items should be added to the cart

