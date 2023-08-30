@Stories
Feature: Update User
  As user
  Want to update the data of a user
  To update the information

  @UpdateUser
  Scenario: Update user information successfully
    When The user consumes the endpoint and updates the data of the: email, userName, password, firstName, lastName
    Then The user can validate if the update was successful with the response service userName

