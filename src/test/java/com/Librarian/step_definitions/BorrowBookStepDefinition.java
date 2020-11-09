package com.Librarian.step_definitions;

import com.Librarian.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BorrowBookStepDefinition {

    LoginPage loginPage = new LoginPage();
    @Given("student is on the landing page")
    public void student_is_on_the_landing_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("student logins with student credentials")
    public void student_logins_with_student_credentials() {

    }

    @When("student clicks on Book module")
    public void student_clicks_on_book_module() {

    }
    @When("student clicks on {string} button")
    public void student_clicks_on_button(String string) {

    }
    @Then("student should be able to borrow a book")
    public void student_should_be_able_to_borrow_a_book() {

    }

}
