@Sample03
Feature: Cucumber example

  @LaunchBrowserV2 @CloseBrowserV2
  Scenario: Search article on Wikipedia
    Given I am on "https://www.wikipedia.org/" - Allure
    When I type "Selenium" on the search input - Allure
    And I click submit button - Allure
    Then I should see the title is "Selenium" - Allure
