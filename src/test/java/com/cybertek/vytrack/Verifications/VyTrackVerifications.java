package com.cybertek.vytrack.Verifications;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class VyTrackVerifications {

    WebDriver driver;

    public void pageLoadTimeout() {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    public void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    By vyTrackLogo = By.cssSelector("[class*='logo logo-text']");
    String expectedText = "Fleet Management".toUpperCase();

    public VyTrackVerifications(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLogoIsPresent() {
        pageLoadTimeout();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        String actualLogoText = wait.until(ExpectedConditions.visibilityOfElementLocated(vyTrackLogo)).getText();
        Assert.assertEquals(actualLogoText, expectedText);
    }

    By pageTitleText = By.xpath("//h1[@class = 'oro-subtitle']");
    String expectedTitleText = "Vehicles Odometers";

    public void verifyVehicleOdometerPageIsDisplayed() {
        pageLoadTimeout();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        String actualTitleText = wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitleText)).getText();
        Assert.assertEquals("Condition true", expectedTitleText, actualTitleText);
    }

    public void verifyEditPageIsOpened(){
        pageLoadTimeout();
        String expectedTitle = "Vehicle Odometer - Entities - System - Car - Entities - System";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println("I add this line to make sure everything works fine!");


    }
}
