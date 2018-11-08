@Sample02
Feature: Cucumber example

  @LaunchBrowser @CloseBrowser
  Scenario: Search article on Wikipedia
    Given I am on "https://www.wikipedia.org/"
    When I type "Selenium" on the search input
    And I click submit button
    Then I should see the title is "Selenium"

  @LaunchBrowser @CloseBrowser
  Scenario: Search article on Wikipedia - failed
    Given I am on "https://www.wikipedia.org/"
    When I type "Selenium" on the search input
    And I click submit button
    Then I should see the title is "Not Selenium"
