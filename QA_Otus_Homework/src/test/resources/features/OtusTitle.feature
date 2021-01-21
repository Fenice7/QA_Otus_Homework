#language:en
Feature: Title check on the main page
  @title
  Scenario: The title on the page actual
    Given I open the main page
    Then I compare the current title with the expected one

