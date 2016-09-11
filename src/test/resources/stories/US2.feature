Feature: US2
  In order to retrieve some or all of my savings
  As a bank client
  I want to make a withdrawal from my account

  Scenario: I want to make a withdrawal from my account
    Given I have an account with balance 2000
    When I am withdrawing 500
    Then It works
    And My account balance should be 1500

  Scenario: I want to make another withdrawal from my account
    Given I have an account with balance 1500
    When I am withdrawing 500
    Then It works
    And My account balance should be 1000

  Scenario: I want to make a withdrawal bigger than my savings from my account
    Given I have an account with balance 1000
    When I am withdrawing 1500
    Then It fails
    And My account balance should be 1000
