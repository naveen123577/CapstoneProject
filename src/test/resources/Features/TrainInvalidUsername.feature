Feature: Validate the invalid IRTC user name
  Scenario Outline: verify whether the application recognize invalid user names
    Given user opens the website
    Then verify user is on homepage
    When user clicks on the Train Tickets option
    Then verify user is on Train home page
    When chooses from location
    And chooses to location
    And picks a date
    When user clicks the Search Train Button
    Then verify user see results for the same
    When user clicks on a seat in a train
    And enters the user name "<username>" in the field
    And click on check username button
    Then verify "Invalid User ID" is displayed

    Examples:
    |username|
    |Naveen shukla|
    |Naveen Singh|
