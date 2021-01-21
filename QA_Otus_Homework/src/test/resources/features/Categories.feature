Feature: Working with course categories

  @parameter
  Scenario Outline: Checking the following link
    Given I open the main page
    When I go to the <section>
    Then Page title corresponds to <section>
    And Navigation item <section> active

    Examples:
      | section                     |
      | Программирование            |
      | Инфраструктура              |
      | Информационная безопасность |
      | Data Science                |
      | Управление                  |
      | Тестирование                |


