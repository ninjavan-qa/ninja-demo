@Sample01
Feature: Is it Friday yet?
  Everybody wants to know when it's Friday.

  Scenario: Sunday isn't Friday (uid:34658f52-2025-4562-9056-278af25e600c)
    Given today is "Sunday"
    When I ask whether it's "Friday" yet
    Then I should be told "false"
