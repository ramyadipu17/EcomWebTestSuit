Feature: Login Functionality

  Scenario: User logs in with valid credentials
    Given I am on the login page
    When I enter valid username and password
    And I click the login button
    Then I should be redirected to the homepage
    And I should see a welcome message

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the login page
    When I enter invalid username and password
    And I click the login button
    Then I should see an error message

  Scenario: Login with empty username and password
    Given I am on the login page
    When I leave the username and password fields empty
    And I click the login button
    Then I should see a user id required error message