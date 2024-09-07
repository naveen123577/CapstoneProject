Feature: Validate the Bus Search Functionalities

  Background:
    Given user opens the website
    Then verify user is on homepage
    When user enter "Bus.travelFrom" as the source city
    And user enter "Bus.travelTo" as the destination city
    And user select the date of travel as "Bus.travelDate"

  Scenario: Search for buses between two cities
    And user click on the search button
    Then verify the list of buses are displayed

  Scenario: Filter buses by sleeper bus type
    And user click on the search button
    Then verify the list of buses are displayed
    When user selects Sleeper from the bus type filter
    Then verify that sleeper buses are only displayed in the listing page

  Scenario: Filter buses by AC bus type
    And user click on the search button
    Then verify the list of buses are displayed
    When user selects AC from the bus type filter
    Then verify that AC buses are only displayed in the listing page

  Scenario: Filter buses by NonAC bus type
    And user click on the search button
    Then verify the list of buses are displayed
    When user selects NonAC from the bus type filter
    Then verify that NonAC buses are only displayed in the listing page

  Scenario: Verify that the Clear All Filters button works correctly
    And user click on the search button
    Then verify the list of buses are displayed
    When user selects AC from the bus type filter
    Then verify that AC buses are only displayed in the listing page
    When user clicks on the Clear All Filters button
    Then verify the full list of buses are displayed
    And verify clear all filters button is not present

  Scenario: Verify user can view the boarding and dropping details
    And user click on the search button
    Then verify the list of buses are displayed
    When user clicks on the boarding & dropping points of first bus
    Then verify the boarding and dropping details are displayed
