Feature: Register functionality

  Scenario: Register with valid details
    Given User is on Register page

  Scenario: Verify Registering Account using only mandatory fields
    Given User navigates to Register page
    When User enters the below fields
      | firstName | Anuj       |
      | lastName  | singh      |
      | telephone | 1234567890 |
      | password  | 12345      |
    And User selects Privacy Policy field
    And User clicks on Continue button
    Then User Account should get created

  Scenario: register without entering any details in text field
    Given User navigates to Register page
    When user not enter any details in text field
    And User selects Privacy Policy field
    And User clicks on Continue button
    Then user should not loged in and warning message shows

  Scenario: Verify Registering Account without selecting privacy field
    Given User navigates to Register page
    When User enters the below fields
      | firstName | Mohit      |
      | lastName  | sahu       |
      | telephone | 1234567890 |
      | password  | 12345      |
    And User clicks on Continue button
    Then User Account should not created and warning message shows on register page

  Scenario: verify warning message on registering account without filling mandatory field
    Given User navigates to Register page
    When user clicks on Continue button
    Then proper warning message should be displayed in the register page

  Scenario: verify navigating to 'Register' option from my account drop menu
    Given user open url in any browser
    When user click on my account drop menu
    And user click on Register option
    Then user navigate to Register page

  Scenario: verify navigating to 'Register' page from my account drop menu login option
    Given user open url in any browser
    When user click on my account drop menu
    And user click on login option
    And click on continue button on login Page
    Then user navigate to Register page

  Scenario: verify navigating to 'Register'page from right coloumn option
    Given user open url in any browser
    When user click on my account drop menu
    And user click on login option
    And click on continue button on login Page
    And user click on register from Right coloum option
    Then user navigate to Register page

  Scenario: verify registering account by providing mismatch passwords
    Given User navigates to Register page
    When User enters the below fields
      | firstName   | Tharun     |
      | lastName    | Motoori    |
      | telephone   | 1234567890 |
      | password    | 12345      |
      | conPassword | 67890      |
    And User selects Privacy Policy field
    And User clicks on Continue button
    Then proper warning message regarding mismatch password should be displayed

  Scenario: verify registering account by existing email
    Given User navigates to Register page
    When User enters the below fields
      | firstName | jayesh     |
      | lastName  | choudhary  |
      | telephone | 1234567890 |
      | password  | 12345      |
    And user enter existing email into email field
    And User selects Privacy Policy field
    And User clicks on Continue button
    Then proper warnig message regarding  existing email should be displayed


  Scenario Outline: verify registering account using passwords not following complexity standards
    Given User navigates to Register page
    When user enter below fields except password field
      | firstName | jayesh     |
      | lastName  | choudhary  |
      | telephone | 1234567890 |
    And user enters <password> which is not following password complexity standards
    And User selects Privacy Policy field
    And User clicks on Continue button
    Then proper warning messsage should be displayed about password complexity not being followed

    Examples:
      | password |
      | 12345    |
      | abcdef   |
      | abcd1234 |
      | abcd123$ |
      | ABCD456! |
