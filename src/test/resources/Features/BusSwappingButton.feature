Feature: Validate the swap button functionality
  Scenario: Swap the From and To locations using the Swap button
    Given user opens the website
    Then verify user is on homepage
    When user enter "Bus.travelFrom" as the source city
    And user enter "Bus.travelTo" as the destination city
    And user select the date of travel as "Bus.travelDate"
    Then verify the cities are swapped after clicking the swap button