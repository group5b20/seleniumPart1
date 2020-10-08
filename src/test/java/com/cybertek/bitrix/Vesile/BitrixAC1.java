package com.cybertek.bitrix.Vesile;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BitrixAC1 {

    public class Project5{

        WebDriver driver;

        @BeforeMethod
        public void setup() {

            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
        public void US1_AC1() throws InterruptedException{

            //clicking on message box
            WebElement messageBox = driver.findElement(By.xpath("//span[.='Send message …']"));
            messageBox.click();
            BrowserUtils.wait(3);

            WebElement addMore = driver.findElement(By.id("bx-destination-tag"));
            addMore.click();
            BrowserUtils.wait(3);

            //Then I should be able to add users from selecting a contact from Recent contact lists
            WebElement recent = driver.findElement(By.xpath("(//a[@class='bx-finder-box-tab bx-lm-tab-last bx-finder-box-tab-selected'])"));
            recent.click();
            BrowserUtils.wait(2);

            WebElement recentEmployees = driver.findElement(By.xpath("//div[contains(text(),'helpdesk23@cybertekschool.com')]"));
            recentEmployees.click();
            BrowserUtils.wait(2);

            WebElement MyGroup = driver.findElement(By.xpath("//a[contains(@id,'destGroupTab_destination')]"));
            MyGroup.click();
            BrowserUtils.wait(2);

            WebElement userName = driver.findElement(By.xpath("//div[contains(text(),'Corporate Christmas Party')]"));
            userName.click();
            BrowserUtils.wait(2);
            //--- (//span[@class='feed-add-post-destination-text'])[2] ==> Corporate Christmas Party

            //And I should be able to add users from selecting a contact from Employees and Departments

            WebElement employeesandDepartments = driver.findElement(By.xpath("(//a[@class='bx-finder-box-tab bx-lm-tab-department'])"));
            employeesandDepartments.click();
            BrowserUtils.wait(3);

            WebElement employeesName = driver.findElement(By.xpath("//div[@class='bx-finder-company-department-employee-name' and contains(text(), 'The Professor')]"));

            //---//div[.='The Professor']
            employeesName.click();
            BrowserUtils.wait(3);

            //And I should be able to add users from selecting a contact from E-mail users
            WebElement emailUsers = driver.findElement(By.xpath("//a[contains(@id,'destEmailTab_destination')]"));
            //---//div[@class='bx-finder-box-tabs']/a[4] ==> static parent-child relation

            // to go from child to parent first find child locator then /.. ==> yukari dogru cikiyor

            // --  /../../../.. ==> yukari cikiyor
            // /../../../../div/div/div/a[4] ==> asagiya iniyor

            emailUsers.click();
            BrowserUtils.wait(2);

            driver.close();

            //bx-finder-box-tab bx-lm-tab-last bx-finder-box-tab-selected


        }
    }

}
