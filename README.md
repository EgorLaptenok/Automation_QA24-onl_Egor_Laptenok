# Automation_QA24-onl_Egor_Laptenok
# SauceDemo
## Generic Automation Framework
This project is a generic automation framework that uses Selenium, TestNG, and Maven.

### How to use this project
- Clone this repository to your local machine.
- Open the project in your preferred IDE.
- Update the pom.xml file with the latest versions of the dependencies.
- Run the tests using the following commands:

#### Update dependencies
To update all library versions in the project, use:
```shell
mvn versions:display-dependency-updates
Example output:
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java ............... 4.15.0 -> 4.16.1
[INFO]   org.testng:testng ..................................... 7.8.0 -> 7.9.0

Run tests
To run tests using Maven, use:
mvn clean test -Dsuite=lesson6
Example output:
Tests run: 16, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 17.518 s - in TestSuite

Run specific tests and methods
To run specific tests and methods with parameters from Maven command line into your test, follow the documentation provided and ensure that maven-surefire-plugin is updated.

For example, to run only the test class TEST_ONLY, use:
mvn clean test -Dsuite=TEST_ONLY

To access the parameter value in your test, use the System.getProperty() method.
For example, to get the value of the browser parameter, use:
String browser = System.getProperty("browser");