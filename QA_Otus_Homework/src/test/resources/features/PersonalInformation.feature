@lkTests
Feature: Change of personal data

  Background:
    Given I open the main page
    And I click on button Login and Registration
    And I enter email
    And I enter password
    And I click button Login
    And I see button My courses
    And I open Personal Area page

  Scenario: Change name
    Given I enter data in the field name
    And I enter data in the field last name
    And I enter data in the field blog name
    And Save changes
    Then Confirmation of successful save
    And Assert enter data

  Scenario: Change other information
    Given I choose "gender" in select
    And I enter the name of the company
    And I enter the title of the position
    And Save changes
    Then Confirmation of successful save
