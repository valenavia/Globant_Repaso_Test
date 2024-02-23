Feature: Validate Wikipedia Articles for Star Wars Characters

    In order to ensure that the Star Wars characters information is correctly represented on Wikipedia
    As a user who retrieves information from the SWAPI service
    I want to verify that the Wikipedia page for each character displays the correct information

  //Background:


  Scenario Outline: Check Wikipedia article is correctly displayed for Star Wars Characters
    Given I am a user at the Wikipedia Web Page
    When I request the SW character with ID <number> from SWAPI
    And I search for the SW character's name on Wikipedia
    Then I should see the character's Wikipedia page correctly displayed
    And all the main sections of the article should be displayed

  Examples:
    | number |
    | 1      |
    | 2      |
    | 3      |
    | 4      |