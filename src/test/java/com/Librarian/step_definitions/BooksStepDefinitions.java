package com.Librarian.step_definitions;

import com.Librarian.pages.BasePage;
import com.Librarian.pages.BooksPage;
import com.Librarian.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BooksStepDefinitions {
    LoginPage loginPage = new LoginPage();
    BooksPage booksPage = new BooksPage();

    @Given("user navigates to {string}")
    public void user_navigates_to(String module) {
        booksPage.navigateTo(module);
    }

    @Given("user clicks on edit book button")
    public void user_clicks_on_edit_book_button() {
        booksPage.editBookBtn(2);
    }

    @When("user edit book information")
    public void user_edit_book_information() {
    }

    @When("user put information on search box")
    public void user_put_information_on_search_box(io.cucumber.datatable.DataTable dataTable) {

    }

    @When("user clicks on save changes button")
    public void user_clicks_on_save_changes_button() {

    }












}
