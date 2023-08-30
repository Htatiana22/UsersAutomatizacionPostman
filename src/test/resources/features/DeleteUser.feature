@Stories
Feature: Delete User
  As user
  Want to delete a user
  To validate that it was removed successfully

  @DeleteUser
  Scenario: Delete a user successfully
    When The user consumes the endpoint and sends the id to delete the user
    Then The valid user with the phone in the reply message



