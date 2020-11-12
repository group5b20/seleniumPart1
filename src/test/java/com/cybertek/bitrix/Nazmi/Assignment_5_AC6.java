package com.cybertek.bitrix.Nazmi;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assignment_5_AC6 {
//Given I am on the Message box
//When I click on Link button
//And I enter the text to display in the window
//And I enter the Links URL
//And I click 'Save'
//And I click SEND
//Then my Text should with link attachment was successfully added to Activity Stream

    // US 2 #AC6. User should be able to attach link by clicking on the link icon.

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://login2.nextbasecrm.com/");

        // Login part with credentials
        //Username
        WebElement inputElement = driver.findElement(By.xpath("//input[@placeholder='Login']"));
        inputElement.sendKeys("helpdesk5@cybertekschool.com");
        //Password
        WebElement passwordElement = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordElement.sendKeys("UserUser");
        //login button
        WebElement LoginElement = driver.findElement(By.xpath("//input[@type='submit']"));
        LoginElement.click();

    }

    @Test
    public void US3_AC4() throws InterruptedException {

        //clicking on message box
        WebElement messageBox = driver.findElement(By.xpath("//span[.='Send message …']"));
        messageBox.click();
        BrowserUtils.wait(3);

        //clicling on Link icon
        WebElement clickLinkButton = driver.findElement(By.xpath("//span[@title='Link']"));
        clickLinkButton.click();
        BrowserUtils.wait(3);

        // adding text "Java"
        WebElement inputText = driver.findElement(By.id("linkidPostFormLHE_blogPostForm-text"));
        inputText.sendKeys("Java");
        BrowserUtils.wait(3);

        // adding Link
        WebElement inputLink = driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-href']"));
        inputLink.sendKeys("https://www.geeksforgeeks.org/oops-object-oriented-design/?ref=lbp");
        BrowserUtils.wait(3);

        // then clicking on saving button
        WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save']"));
        saveButton.click();
        BrowserUtils.wait(3);

        // checking if link displayed on message box
        WebElement taskDisplay = driver.findElement(By.partialLinkText("Java"));
        Assert.assertTrue(taskDisplay.isDisplayed(),"Message is NOT displayed, verification FAILED!!!");




    }

    @AfterMethod
    public void tearDown(){

        driver.close();
        System.out.println("Test successfully PASSED!");
    }
}
