package com.Librarian.pages;

import com.Librarian.utils.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "inputEmail")
    private WebElement username;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(css = "[class='alert alert-danger']")
    private WebElement warningMessage;

    public String getWarningMessageText() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return warningMessage.getText().trim();
    }

    public void login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login() {
        String usernameValue = ConfigurationReader.getProperty("librarian.username");
        String passwordValue = ConfigurationReader.getProperty("librarian.password");

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(String role) {
        String usernameValue = "";
        String passwordValue = "";

        if (role.equalsIgnoreCase("student1")) {
            usernameValue = ConfigurationReader.getProperty("student1.username");
            passwordValue = ConfigurationReader.getProperty("student1.password");
        } else if (role.equalsIgnoreCase("student2")) {
            usernameValue = ConfigurationReader.getProperty("student2.username");
            passwordValue = ConfigurationReader.getProperty("student2.password");
        }

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }


}
