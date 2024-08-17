Feature: Validate the Bus Search Functionalities

  Scenario: Search for buses between two cities

    Given user opens the website
    Then verify user is on homepage
    When user enter "Bangalore" as the source city
    And user enter "Chennai" as the destination city
    And user select the date of travel as "20 Oct 2024"
    And user click on the search button
    Then verify the list of buses are displayed
