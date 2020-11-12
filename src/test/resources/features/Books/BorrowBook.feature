Feature: Borrow Book
  AC#2: Verify that user is able to borrow an available book by clicking on “Borrow Book” button. The borrowed book should be displayed under “Borrowing Books” module
  @borrow_book
  Scenario:student Borrowing book
    Given student is on the landing page
    When student logins with student credentials
    When student clicks on Book module
    And student clicks on "Borrow Book" button
    Then student should be able to borrow a book
