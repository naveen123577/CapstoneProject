Feature: Validate the Ticket Cancellation

  Scenario Outline: Verify the user is unable to cancel ticket with incorrect ticket number
    Given user opens the website
    Then verify user is on homepage
    When user clicks on the profile dropdown button
    And user clicks on the cancel ticket option
    Then verify the ticket cancellation page is displayed
    When user enter incorrect "<ticket number>" and "<mobile number>"
    And user click on SelectPassengers Button
    Then verify the error message is displayed
    Examples:
      | ticket number | mobile number |
      | quit5678fc    | 4572987659    |
      | pu67t5678fc   | 9572987659    |
