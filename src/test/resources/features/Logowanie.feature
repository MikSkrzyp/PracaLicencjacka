@firefox
Feature: Strona Logowania


  Scenario: Pozytywne Logowanie
    Given I open the login page
    When I input correct username, passowrd and click button
    Then I am moved to Home Page