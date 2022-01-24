# Cucumber_Example

This Cucumber-JVM example shows the following Gherkin features:

- Scenario and Scenario Outline + Examples
- Given, When, Then, And
- Tags

"Cucumber" documentation is available on: https://cucumber.io/docs/installation/java/

## Feature files

### CheckLocation.feature
This feature contains Gherkin Scenarios and Scenario Outlines and is compatible with other test frameworks that implement the Gherkin syntax.
For example Cucumber and SpecFlow. See https://github.com/Gerard-A/SpecFlow_Example for a SpecFlow C# project, and https://github.com/Gerard-A/Behave_example for a Python Behave project, that use the same feature file.

## Test execution

Prerequisites:
- JDK and maven must be installed on your system.

To run the tests, execute commands:
- `runTest.bat` to run all tests
- `runSmokeTest.bat` to run all test cases that are tagged with '@SmokeTest'
- `runNightTest.bat` to run all test cases that are tagged with '@NightTest'
