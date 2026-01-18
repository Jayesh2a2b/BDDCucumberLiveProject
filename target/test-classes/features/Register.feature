Feature: Register functionality

  Scenario: Register with valid details
    Given User is on Register page
Scenario: Verify Registering Account using only mandatory fields
Given User navigates to Register page
When User enters the below fields
|firstName	|Arun				|
|lastName	  |Motoori |
|telephone	|1234567890	|
|password		|12345			|
And User selects Privacy Policy field
And User clicks on Continue button
Then User Account should get created

Scenario:  register without entering any details in text field
Given User navigates to Register page
When user not enter any details in text field
And User selects Privacy Policy field
And User clicks on Continue button
Then user should not loged in and warning message shows

Scenario: Verify Registering Account without selecting privacy field 
Given User navigates to Register page
When User enters the below fields
|firstName	|Arun				|
|lastName		|Motoori		|
|telephone	|1234567890	|
|password		|12345			|
And User clicks on Continue button
Then User Account should not created and warning message shows on register page


