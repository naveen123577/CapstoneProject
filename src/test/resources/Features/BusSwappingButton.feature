Feature: Validate the swap button functionality
  Scenario: Swap the From and To locations using the Swap button
    Given user opens the website
    Then verify user is on homepage
    When user enter "Bangalore" as the source city
    And user enter "Chennai" as the destination city
    And user select the date of travel as "20 Oct 2024"
    Then verify the cities are swapped after clicking the swap button