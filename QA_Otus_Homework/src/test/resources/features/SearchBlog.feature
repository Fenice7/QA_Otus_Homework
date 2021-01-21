Feature: Search in the Blogs section of the site

  Scenario: I can search some blog
    Given I open the main page
    And I go to the Knowledge Base menu section
    When I search "QA и тестирование"
    And I click found
    And I choose tab Blogs
    And I select found blog in result page
    Then Checking that the blog title matches "QA и тестирование"


