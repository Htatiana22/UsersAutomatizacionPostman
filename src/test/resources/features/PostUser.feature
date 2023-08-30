@Stories
Feature: Create User
  As user
  Want to create a user
  To send the information

@PostUser
Scenario Outline: Create user successfully
  When The user consumes the endpoint and sends the information of the email,userName,password,firstName,lastName
  Then the user can validate the response service <code>

  Examples:
    | code |
    | 200  |