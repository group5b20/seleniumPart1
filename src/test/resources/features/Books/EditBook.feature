Feature:  As Librarian, I want to be able to edit book

  @edit_book
  Scenario: 1. edit some book
    Given user is on the login page
    When user logs in
    And user navigates to "Books"
    And user clicks on edit book button
    When user edit book information
      | Book Name      | The hunger games : the ultimate quiz book |
      | ISBN           | 9781781662717 |
      | Year           | 2014 |
      | Author         | Goldstein, Jack |
      | Book Category  | FICTION |
      | Description    | How much do you know about the three books that make up the Hunger Games series? Prove your knowledge with this fascinating quiz book containing 200 questions (and answers!) to test the knowledge of any Hunger Games fan. |
    And user clicks on save changes button

