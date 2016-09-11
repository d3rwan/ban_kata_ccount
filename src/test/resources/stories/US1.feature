Feature: US1
  In order to save money
  As a bank client
  I want to make a deposit in my account

  Scenario: I want to make a deposit in my account
    Given I have an account with balance 1000
    When I am depositing 500
    Then It works
    And My account balance should be 1500

  Scenario: I want to make another deposit in my account
    Given I have an account with balance 1500
    When I am depositing 500
    Then It works
    And My account balance should be 2000
