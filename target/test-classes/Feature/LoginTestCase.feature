 Feature: Login Functionality 

    Scenario: Successful Login with valid credentials
        Given User navigates to the login page
        When User enters username "Admin" in the username field
        And User enters password "admin123" in the password field
        When User clicks the Login button
        Then User is successfully logged in and redirected to the home page

    Scenario: Failed Login with invalid username
        Given User navigates to the login page
        When User enters invalid "Admin12345" in the username field
        And User enters invalid "Admvdsd" in the password field
        When User clicks the Login button
        Then Error message "Invalid credentials" is displayed