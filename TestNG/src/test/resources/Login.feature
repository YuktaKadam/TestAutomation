Feature: User Login

  Scenario: Login via Valid Credentials
    Given User enters valid username field
    And User enters valid password field
    When User clicks on the Submit Button
    Then User is logged in Successfully.

  Scenario: Login via Invalid Credentials
    Given User enters invalid username field
    And User enters invalid password field
    When User clicks on the Submit Button
    Then Error message is displayed.

