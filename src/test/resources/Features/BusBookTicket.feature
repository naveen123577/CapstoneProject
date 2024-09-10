Feature: Validate the boarding points and dropping points after selecting the view seats

  Background:
    Given user opens the website
    Then verify user is on homepage
    When user enter "Bus.travelFrom" as the source city
    And user enter "Bus.travelTo" as the destination city
    And user select the date of travel as "Bus.travelDate"
    And user click on the search button
    Then verify the list of buses are displayed

  Scenario: Verify the boarding and dropping points are not empty
    When user clicks on the view seats button
    And user clicks on an empty seat
    Then verify the boarding and dropping details list are not null

  Scenario: Verify the seats are not visible when user clicks on the hide seat button
    When user clicks on the view seats button
    Then verify the seat page is displayed
    When user clicks on the hide seat button
    Then verify the seats are not visible

  Scenario: Verify the price in the boarding and dropping point section is greater than the price in listing section
    And store the price in the listing page of first bus
    When user clicks on the view seats button
    And user clicks on an empty seat
    Then verify the boarding and dropping details list are not null
    And verify the price in the boarding and dropping section is greater than or equal to the price in listing page
