package com.cybertek.bitrix.Pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BitrixLoginPage {

    By usernameField = By.name("USER_LOGIN");
    By passwordField = By.name("USER_PASSWORD");
    By logInButton = By.className("login-btn");

    public void pageLoadTimeout() {
        Driver.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    public void implicitlyWait() {
        Driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void login() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        pageLoadTimeout();
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(ConfigurationReader.getProperty("BitrixUsername"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(ConfigurationReader.getProperty("BitrixPassword"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logInButton)).click();
    }
}