Feature: Login to the application

  Scenario: Valid user login
    Given the browser is open
    And user is on the login page
    When user enters username "Admin" and password "admin123"
    Then user should be navigated to the home page
