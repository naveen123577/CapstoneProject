Feature: Validate the various status of train in the application
  Scenario: verify the Live train status
    Given user opens the website
    Then verify user is on homepage
    When user clicks on the Train Tickets option
    Then verify user is on Train home page
    When clicks the Live train Status Option
    And enters "16343" in the search bar
    When user clicks the check status button
    Then verify status of the train is displayed