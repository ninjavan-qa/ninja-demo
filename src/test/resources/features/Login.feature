@Login
Feature: Login feature

  Scenario: User successfully login to the web app
    Given I am on the main page
    When I enter "myusername" into Username field
    And I enter "mypassword" into Password field
    And I click Login button
    Then I see "LOGIN SUCCESS" message

  Scenario: User fails to login to the web app with invalid credentials
    Given I am on the main page
    When I enter "invalid" into Username field
    And I enter "mypassword" into Password field
    And I click Login button
    Then I see "LOGIN FAILED" message
