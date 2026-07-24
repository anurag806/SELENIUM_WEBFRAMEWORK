# Automation Exercise Hybrid Framework

## Technology Used

- Java
- Selenium WebDriver
- TestNG
- Maven

## Framework Features

✔ ThreadLocal Driver  
✔ Page Object Model  
✔ Screenshot on Failure  
✔ Excel Driven Testing

AutomationExerciseHybridFramework
│
├── Base
│   └── Base.java
│
├── DriverFactory
│   └── DriverFactory.java
│
├── Pages
│   ├── LoginPage.java
│   ├── SignupPage.java
│   ├── HomePage.java
│   ├── ProductPage.java
│   └── CheckoutPage.java
│
├── TestCases
│   ├── LoginTest.java
│   ├── RegisterUserTest.java
│   ├── CartTest.java
│   └── PlaceOrderTest.java
│
├── Utils
│   ├── ScreenshotUtils.java
│   ├── ExcelUtils.java
│   ├── LoggerUtils.java
│   └── ExtentManager.java
│
├── Listeners
│   └── TestListeners.java
│
├── TestData
│   └── TestData.xlsx
│
├── Reports
│
└── pom.xml
