Feature: Checking number of courses in categories

  @parameter
  Scenario Outline: Checking the number of courses in categories
    Given I open the main page
    When I go to the <section>
    Then I have to see that the <number of courses>
    Examples:
      | section                     | number of courses |
      | Программирование            | 58                |
      | Инфраструктура              | 36                |
      | Информационная безопасность | 4                 |
      | Data Science                | 11                |
      | Управление                  | 8                 |
      | Тестирование                | 11                |