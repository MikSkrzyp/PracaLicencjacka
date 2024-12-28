# Automation Testing for Management Department Website - University of Gdańsk

## Description
This project focuses on the automation testing of the Management Department website of the University of Gdańsk.


## Technologies Used
- **Programming Language:** Java
- **Testing Frameworks:** Selenium, TestNG
- **BDD:** Cucumber
- **CI/CD Tool:** Jenkins
- **Reporting:** Allure

## Getting Started

### Prerequisites
- Java 21
- Maven 3.9
- Google Chrome, Mozilla Firefox

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/MikSkrzyp/UG_WZR_TESTING
   ```
2. Navigate to the project directory:
   ```bash
   cd UG_WZR_TESTING
   ```
3. Install dependencies:
      ```bash
      mvn dependency:resolve
      ```

## Usage
1. Run tests:
      ```bash
      mvn clean install
      ```
2. Generate test report:
     ```bash
     mvn allure:serve
     ``` 


---
*Happy Testing!*
