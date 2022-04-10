@Regression
Feature: Verify Login with valid credentials

  Scenario Outline: Login as a Registered user
    Given I am in Buggy Home page
    When I log in using <userName> and <password>
    Then I see the customized Hello message with <firstName> displayed

    Examples: 
      | userName          | password   | firstName |
      | liby.jp@gmail.com |  Enid1312!!|lola      |

   Scenario: Login as a Unregistered user
   
    Given I am in Buggy Home page
    When I log in using RandomUser and Pass@word1
    Then I see the Invalid Username and password message is displayed
    