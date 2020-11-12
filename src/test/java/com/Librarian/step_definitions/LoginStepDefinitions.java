package com.Librarian.step_definitions;

import com.Librarian.pages.BooksPage;
import com.Librarian.pages.LoginPage;
import com.Librarian.utils.BrowserUtils;
import com.Librarian.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefinitions {
    //WebDriver driver;
    LoginPage loginPage = new LoginPage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("http://library2.cybertekschool.com/login.html");
    }

    @When("user logs in")
    public void user_logs_in() throws InterruptedException {
        loginPage.login();
        Thread.sleep(3000);
    }

    @Then("user should see Dashboard page")
    public void user_should_see_Dashboard_page() {
        String expected = "Dashboard".toLowerCase();
        String actual = loginPage.getPageSubTitleText().trim().toLowerCase();

        Assert.assertEquals("Title is not correct!", expected, actual);
        System.out.println("I see the Dashboard page!");
        Driver.closeDriver();
    }
    @Then("user should see Books page")
    public void user_should_see_Books_page() {

       BrowserUtils.wait(2);
       // new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf("Books"));

        String expected = "Books".toLowerCase();
        String actual = loginPage.getPageSubTitleText().trim().toLowerCase();

        Assert.assertEquals("Title is not correct!", expected, actual);
        System.out.println("I see the Book Management page!");
        Driver.closeDriver();
    }

    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string) {
        loginPage.login(string);
    }

    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
        loginPage.login(string, string2);
    }

    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String expected) {
        String actualResult = loginPage.getWarningMessageText();
        Assert.assertEquals(expected, actualResult);
        Driver.closeDriver();
    }
}
