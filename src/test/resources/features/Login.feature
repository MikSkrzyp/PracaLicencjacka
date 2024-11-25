Feature: Login Page Verification
  As a user
  I want to verify the login page
  So that I can ensure the correct branding and layout

  Scenario: Verify logo text on login page
    Given I open the login page
    When I check the logo text
    Then I should see the text "Swag Labs"

  Scenario: Verify
    Given I open the login page
    Then I should see the Login button
