Feature: rabotaBy test

  @smoke
  Scenario: Поиск вакансий QA Automation
    Given site user opens
    When user enters "QA Automation" in the search field
    And the user clicks the "Find a job" button
    Then the page title contains the text "Работа QA automation в Минске"
    And the number of vacancies found is greater than or equal to expected "20"