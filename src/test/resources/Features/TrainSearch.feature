Feature: Validate the train search functionality
  Scenario: verify user can search trains
    Given user opens the website
    Then verify user is on homepage
    When user clicks on the Train Tickets option
    And chooses from location
    And chooses to location
    When user clicks the Search Train Button
    Then verify user see results for the same
