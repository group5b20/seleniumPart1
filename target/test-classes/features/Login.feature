@login
Feature: As user I want to be able to login under different roles
# this is a comment

  @librarian
  Scenario: Login as a librarian manger
    Given user is on the login page
    When user logs in
    Then user should see Dashboard page

  @student1
  Scenario: Parametrized login
    Given user is on the login page
    When user logs in as a "student1"
    Then user should see Books page

  @student2
  Scenario: Parametrized login
    Given user is on the login page
    When user logs in as a "student2"
    Then user should see Books page

  @negative_login1
  Scenario: Invalid password
    Given user is on the login page
    When user logs in with "test@gmail.com" username and "wrong" password
    Then user verifies that "Sorry, Wrong Email or Password" message is displayed

  @negative_login2
  Scenario: Invalid password
    Given user is on the login page
    When user logs in with "student1" username and "wrong" password
    Then user verifies that "Please enter a valid email address." message is displayed