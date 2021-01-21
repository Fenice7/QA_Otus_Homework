@lkTests
Feature: Login user

  Scenario: Success auth on the site

    Given I open the main page
    When I click on button Login and Registration
    And I enter email
    And I enter password
    And I click button Login
    Then I see button My courses

  Scenario: Fail auth on the site
    Given I open the main page
    When I click on button Login and Registration
    And I enter fail mail
    And I enter fail pass
    And I click button Login
    Then I see error message
