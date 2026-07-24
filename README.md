# Automation Exercise Hybrid Framework 🚀

## Project Overview

This project is a Selenium Hybrid Automation Framework developed using Java, Selenium WebDriver, TestNG and Maven.

The framework automates end-to-end scenarios of Automation Exercise website like user registration, login, product search, cart operations, checkout and order placement.

This framework follows **Page Object Model (POM)** design pattern and supports data-driven testing, reporting, logging and parallel execution.

---

## Technology Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Apache POI
- Log4j2
- Extent Reports
- Faker Library
- Git & GitHub
- IntelliJ IDEA

---

## Framework Features

✔ Page Object Model (POM)  
✔ Hybrid Framework Architecture  
✔ ThreadLocal WebDriver  
✔ Parallel Execution Support  
✔ Explicit Wait Implementation  
✔ Excel Driven Testing  
✔ TestNG DataProvider  
✔ Screenshot Capture on Failure  
✔ Extent HTML Reports  
✔ Log4j2 Logging  
✔ Faker Test Data Generation  
✔ Maven Integration  
✔ Reusable Utility Classes

---

# Project Structure

```
AutomationExerciseFramework
│
├── src/main/java
│
│── Base
│    └── Base.java
│
│── DriverFactory
│    └── DriverFactory.java
│
│── Pages
│    ├── LoginPage.java
│    ├── HomePage.java
│    ├── ProductPage.java
│    └── CheckoutPage.java
│
│── Utils
│    ├── ScreenshotUtils.java
│    ├── LoggerUtils.java
│    ├── ExcelUtils.java
│    └── ExtentManager.java
│
│── DataProvider
│    └── DataProviderUtils.java
│
├── src/test/java
│
│── TestCases
│    ├── LoginTest.java
│    ├── RegisterUserTest.java
│    ├── AddToCartTest.java
│    └── PlaceOrderTest.java
│
├── TestData
│    └── TestData.xlsx
│
├── Reports
│
├── Screenshots
│
├── testng.xml
│
└── pom.xml
```

---

# Automated Test Scenarios

## User Management

- Register User
- Login User
- Logout User
- Delete Account


## Product Management

- Verify Products
- Search Product
- Add Product To Cart
- Remove Product From Cart


## Order Management

- Add Product
- Checkout Process
- Place Order
- Payment Validation
- Download Invoice

---

# Setup & Installation

## Prerequisites

Install below tools:

- Java JDK 21
- Maven
- IntelliJ IDEA
- Chrome Browser
- Git


---

# Clone Repository

```bash
git clone <your-github-repository-url>
```

Navigate to project:

```bash
cd AutomationExerciseFramework
```

---

# Install Dependencies

Run below command:

```bash
mvn clean install
```

---

# Execute Tests

Run complete test suite:

```bash
mvn test
```

Or execute using:

```
testng.xml
```

---

# Reports

After execution:

### Extent Report

Generated inside:

```
Reports/
```

### Failed Test Screenshots

Generated inside:

```
Screenshots/
```

---

# Logging

Framework uses Log4j2 for maintaining execution logs.

Logs capture:

- Test execution details
- Browser actions
- Failures
- Debug information

---

# Parallel Execution

Framework supports parallel execution using:

- TestNG Parallel Execution
- ThreadLocal WebDriver

Each test runs with an independent browser session.

---

# Future Enhancements

- Jenkins CI/CD Integration
- Selenium Grid Execution
- Docker Support
- API Automation Integration
- Allure Reporting
- Cross Browser Testing

---

# Author

**Anurag Pandey**

SDET | Automation Test Engineer

Skills:

Java | Selenium | TestNG | RestAssured | API Testing | Maven | Git

---

# Application Under Test

Automation Exercise

https://automationexercise.com/

---

⭐ This framework demonstrates industry-level Selenium automation practices using Java.