Feature: Validate the back to top button functionality

  Scenario: Scroll to top using the Back to Top arrow button
    Given user opens the website
    Then verify user is on homepage
    And user scroll down the page
    Then verify the Back to Top arrow button appear
    When user click on the Back to Top arrow button
    Then verify the page scrolls to the top of the page
    And verify the Back to Top arrow button is no longer displayed
