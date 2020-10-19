package com.cybertek.bitrix.Zeyneb;

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



    /*Given User is on the login page

When user enter valid username and password
And user click login button
Then user  should be able to see Activity Stream
When user click  the message text
And  user click on visual editor icon
Then user should be able see the editor text-bar displays on top of the message box.

 */



    public class EditorTaskBar {

        WebDriver driver;

        @BeforeMethod
        public void setup() {

            driver = WebDriverFactory.getDriver("chrome");

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("https://login2.nextbasecrm.com/");

            //Username
            WebElement username = driver.findElement(By.xpath("//input[@placeholder='Login']"));
            username.sendKeys("helpdesk5@cybertekschool.com");

            //Password
            WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            password.sendKeys("UserUser");

            //Login
            WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
            login.click();



        }

        @Test
        public void US1_AC7()  {

            //click "message" text
            WebElement messageText = driver.findElement(By.xpath("//span[.='Message']"));
            messageText.click();
            BrowserUtils.wait(5);

            //click "visual editor icon 'A'
            WebElement visualEditorIcon = driver.findElement(By.xpath("//span[@title='Visual editor']"));
            visualEditorIcon.click();
            BrowserUtils.wait(5);

            //check "editor task bar" is displayed
            WebElement editorTaskBarDisplay = driver.findElement(By.xpath("//div[@id='bx-html-editor-tlbr-idPostFormLHE_blogPostForm']"));
            Assert.assertTrue(editorTaskBarDisplay.isDisplayed(), "Editor task bar is displayed!!!");
        }

        @AfterMethod
        public void tearDown(){
            BrowserUtils.wait(3);

            driver.close();
            System.out.println("Editor task bar is displayed on top of the message box");
        }
}
