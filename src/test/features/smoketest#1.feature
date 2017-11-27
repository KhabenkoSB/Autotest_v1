
@withdrawal
Feature: Login to 10Bet

  @success
  Scenario: Login  exist
    Given I have login
    When I am logining to 10bet
    Then I can see balase

  @fail
  Scenario: Login  doen't exist
    Given I have login
    When I am logining to 10bet
    Then I can see error