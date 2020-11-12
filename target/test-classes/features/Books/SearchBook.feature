Feature:  As Librarian, I want to be able to search book by "Author and Name"

  @search_book
  Scenario: 1. search book by "Author and Name"
    Given user is on the login page
    When user logs in
    And user navigates to "Books"
    When user put information on search box
      | Book Name | The hunger games : the ultimate quiz book |
      | Author    | Goldstein, Jack                           |