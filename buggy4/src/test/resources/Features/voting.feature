@Regression
Feature: Voting for a car model
  

  @Register
  Scenario: A logged in user tries to vote for a car model
    Given I am in Buggy Home page
    And I log in as a Registered user
    When I click on Overall Ratings Tile
    And I click on a model
    And click on Vote button
    Then I get a thankyou message
    And Number of votes has increased by one
    
  Scenario: user tries to vote for a car model without logging
    Given I am in Buggy Home page
    When I click on Overall Ratings Tile
    And I click on a model
    Then I get a message that you have to be logged in
