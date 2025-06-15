API AUTOMATION FRAMEWORK - ReqRes API
=====================================

This project is a Java-based API Test Automation Framework built using:
- RestAssured
- TestNG
- ExtentReports
- Maven

It performs CRUD operations on the public API: https://reqres.in


PROJECT STRUCTURE
------------------
ApiAutomationFramework/
├── pom.xml
├── testng.xml
├── readme.txt
├── test-output/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── ApiUtils/
│   │       │   ├── Utils.java
│   │       │   └── ExtentReportManager.java
│   │       └── PojoClasses/
│   │           └── User.java
│   └── test/
│       └── java/
│           └── CRUDOperation/
│               └── UserCRUDTest.java


FEATURES
---------
- Handles Create, Read, Update, Delete operations using RestAssured
- POJO classes for request/response structure
- ExtentReports for HTML reporting
- TestNG for test flow control and assertions
- Easy to execute via Maven or Jenkins


HOW TO RUN TESTS
------------------

1. From Command Line:
   > mvn clean test

2. Using testng.xml:
   > mvn clean test -DsuiteXmlFile=testng.xml

3. From Jenkins:
   - Create a Maven job
   - Add 'clean test' in the build step
   - Use HTML Publisher Plugin to view reports


REPORTS
--------
After execution, view the report at:
> test-output/ExtentReport.html


API TEST CASES COVERED
------------------------

Test Case         | Method   | Expected Status Code
------------------|----------|----------------------
Create User       | POST     | 201
Get User          | GET      | 200
Update User       | PUT      | 200
Delete User       | DELETE   | 204
Invalid Get User  | GET      | 404


FUTURE IMPROVEMENTS
---------------------
- Request chaining
- Data-driven tests with JSON/Excel
- Allure Reports integration
- Retry logic for unstable endpoints


AUTHOR
Om Yadav

Api Automation
