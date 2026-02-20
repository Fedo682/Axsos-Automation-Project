
🧪 OrangeHRM Automation Testing Project (Selenium)
📌 Project Overview

This project contains automated test scripts for the OrangeHRM web application using Selenium WebDriver.

The purpose of this project is to:

Automate critical business workflows

Validate core HR functionalities

Ensure system stability through regression testing

Demonstrate automation framework design and implementation

The automation suite covers functional testing scenarios based on the defined Test Plan and Requirement Traceability Matrix (RTM).

🛠 Tech Stack

Language: Java (or replace with your language: Python / C#)

Automation Tool: Selenium WebDriver

Test Framework: TestNG / JUnit / PyTest (edit accordingly)

Build Tool: Maven / Gradle (if applicable)

IDE: IntelliJ / Eclipse / VS Code

Reporting: Extent Reports / Allure (if used)

📂 Project Structure
OrangeHRM-Automation/
│
├── src/main/java
│   ├── pages/              # Page Object Model classes
│   ├── tests/              # Test classes
│   ├── utilities/          # Driver setup, helpers
│
├── test-data/              # Test data files
├── reports/                # Generated test reports
├── test-output/            # Framework output files
│
├── pom.xml                 # Maven configuration (if applicable)
└── README.md
🎯 Application Under Test

Application Name: OrangeHRM

Type: Human Resource Management System (HRMS)

URL:[ (Orange HRM Link)](https://opensource-demo.orangehrmlive.com)

Modules Covered

Login

Dashboard

PIM (Employee Management)

Leave Management

Admin Module

Recruitment (if applicable)

📋 Test Artifacts
📑 Test Plan

Describes:

Scope of testing

Testing strategy

Test environment

Risks & mitigation

Entry & exit criteria

🔗 Test Plan Link:
[[Test Plan ]](https://docs.google.com/document/d/17ifLNM_507ibdg8njiQveWgRPELOSA2V/edit?usp=sharing&ouid=109288125554155642298&rtpof=true&sd=true)

📊 Requirement Traceability Matrix (RTM)

The RTM ensures:

All requirements are covered by test cases

Clear traceability between requirements and automation scripts

🔗 RTM Link:
[[RTM]
](https://docs.google.com/spreadsheets/d/1_Ddd8xgJh8D0MXKrEHRiDXvyVD3zSvf_US0Sv8S9jvo/edit?usp=sharing)
🎤 Presentation

Project presentation explaining:

Framework design

Test coverage

Challenges faced

Demo of execution

Reporting overview

🔗 Presentation Link:
[[Presentation]
](https://www.canva.com/design/DAG-HEAx7P0/P2VXm7U7wQsh1-yrveqSbg/edit?utm_content=DAG-HEAx7P0&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)
🏗 Automation Framework Design

This project follows:

✅ Page Object Model (POM)

✅ Reusable utilities

✅ Data-driven testing (if implemented)

✅ Separate test configuration

✅ Clean reporting structure

Key Design Decisions

Centralized WebDriver setup

Explicit waits for synchronization

Modular page classes

Parameterized test execution

▶ How to Run the Project
1️⃣ Clone the Repository
git clone https://github.com/your-username/Axsos-Automation-Project.git
2️⃣ Install Dependencies

If using Maven:

mvn clean install
3️⃣ Run Tests
mvn test

Or run directly from the IDE.

📊 Reporting

After execution, reports can be found in:

/test-output
/reports

Reports include:

Pass/Fail status

Execution logs

Screenshots (on failure if implemented)

🧪 Sample Test Scenarios Automated

Verify successful login with valid credentials

Verify login error with invalid credentials

Add new employee

Search employee

Apply leave

Approve leave request

Logout functionality

🔐 Test Data

Valid & invalid credentials

Employee details

Leave request scenarios

Test data can be:

Hardcoded

Excel-based

JSON-based

Environment-based (depending on your implementation)

🚀 Future Improvements

CI/CD integration (GitHub Actions / Jenkins)

Docker container execution

Cross-browser testing

Headless execution

Parallel execution

Cloud execution (Selenium Grid / BrowserStack)

👤 Authors 
Laith Faheem
QA LEAD

Ibraheem Ahmad 
QA ENGINEER

Mariam Abulail 
Scrum Master

Fadi Halaweh
QA Automation Engineer
