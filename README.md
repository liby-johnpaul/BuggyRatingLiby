# Buggy Cars Rating
 * [Url of the Buggy Car site](https://buggy.justtestit.org)

## Prerequisites
1. Programming Language: Java 11 or above
2. Build Management: Maven 3.8.3
3. IDE- Eclipse 

### Frameworks: 
1. Cucumber (BDD)
2. Selenium WebDriver (Chrome Driver ChromeDriver 100.0.4896.60)
3. JUnit (For running cucumber test

### Design:
 * BDD - Scenarios, Data Tables, Scenario Outline, Examples,hooks, tags
 * Pages - Page Object model
 * All the Step definitions are in login_test class
 * Elements and Methods are in each individual page as in page object model
![Alt text](Test_Architecture.png?raw=true "Title")
 
### Reports:
 Reports of running tests can be find in target folder.There are options to view result reports in json, html,junit

### Test Execution:
   * In a terminal navigate to project root directory and run `mvn test`
   * Open Eclipse and run Testrunner.java under Step defintions

