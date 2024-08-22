Feature: validate the language functionality
  Scenario:Verify whether the language of the website change after selecting a language
    Given user opens the website
    Then verify user is on homepage
    When user clicks on the help button
    And clicks the language option
    And selects "Tamil" as Language
    Then verify that language have been applied to the application


  Scenario:Verify whether the language of the website change after selecting Telugu language
    Given user opens the website
    Then verify user is on homepage
    When user clicks on the help button
    And clicks the language option
    And selects "Telugu" as Language
    Then verify that language have been applied to the application

