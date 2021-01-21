@lkTests
Feature: Checking sections invite friend

  Background:
    Given I open the main page
    And I click on button Login and Registration
    And I enter email
    And I enter password
    And I click button Login
    And I see button My courses
    And I open Personal Area page
    And I am opening the section invite a friend

  @parameter
  Scenario Outline: Invite friends by mail
    When I enter <email> in input
    Then I see an informational <message>

    Examples:
      | email                 | message                          |
      | fenicemail1@gmail.com | Такая почта уже зарегистрирована |
      | binafi8517@1adir.com  | Такая почта уже учавствует в     |

  Scenario: Error invite friends
    When I enter " " in input
    Then I see an error message

#Сработает только один раз
  Scenario: Successful invite friends
    When I enter feydohutri@nedoz.com in input
    Then I see an succes message
