Feature: Validate Wikipedia Edit page for Star Wars movies

  Scenario: Check Wikipedia article film page and click on the Edit Link
    Given I am at the Wikipedia Web Page
    When I request the SW film with ID number from SWAPI from a random number
    And I search for the SW films name on Wikipedia
    Then I should see the edit element correctly displayed and I click on it
    And the title of the Wikipedia edit page should match the film's name
