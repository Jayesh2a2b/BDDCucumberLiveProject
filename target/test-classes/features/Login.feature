Feature: Login Functionality
Scenario: Login with valid credentials
Given user should navigate to Login page
When user enter email and password in Email and Password text box field
And click on login button
Then user shouild loged in and navigate to My Account Page

Scenario: Login with invalid credentials
Given  user should navigate to Login page
When user enters invalid credentials
And click on login button
Then user should not logged in 

