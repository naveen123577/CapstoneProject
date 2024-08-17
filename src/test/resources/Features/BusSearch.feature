Feature: Validate the Bus Search Functionalities

  Scenario: Search for buses between two cities

    Given user opens the website
    Then verify the user is on the home page
    When user enter "Bangalore" as the source city
    And user enter "Chennai" as the destination city
    And user select the date of travel as "2024-08-30"
    And user click on the "Search Buses" button
    Then user should see a list of available buses for the selected route
