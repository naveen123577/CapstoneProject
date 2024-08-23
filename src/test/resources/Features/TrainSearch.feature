Feature: Validate the train search functionality
  Scenario: verify user can search trains
    Given user opens the website
    Then verify user is on homepage
    When user clicks on the Train Tickets option
    Then verify user is on Train home page
    When chooses from location
    And chooses to location
    And picks a date
    When user clicks the Search Train Button
    Then verify user see results for the same


  Scenario:verify user cannot see results if source and destination are the same
    Given user opens the website
    Then verify user is on homepage
    When user clicks on the Train Tickets option
    Then verify user is on Train home page
    When chooses Source destination
    And chooses To Destination
    And picks a date
    When user clicks the Search Train Button
    Then verify "Source and Destination are same" message is displayed

  Scenario:verify whether button for swapping source and destination is working
    Given user opens the website
    Then verify user is on homepage
    When user clicks on the Train Tickets option
    Then verify user is on Train home page
    When chooses from location
    And chooses to location
    Then verify source and destination have been swapped after clicking the swap button


  Scenario:verify whether the results are not shown when giving dates of distant future
    Given user opens the website
    Then verify user is on homepage
    When user clicks on the Train Tickets option
    Then verify user is on Train home page
    When chooses from location
    And chooses to location
    And chooses a date "29 OCT 2030"
    When user clicks the Search Train Button
    Then verify "No Trains Found"  is displayed





