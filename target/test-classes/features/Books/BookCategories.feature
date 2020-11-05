Feature:As a librarian ,I want to be able to click on "Book Categories"

  @book_Categories
  Scenario:Book Categories
    Given user is on the login page
    When user logs in
    And user navigates to "Books"
    And user should be see "Book Categories"
    Then user able to chose any category
