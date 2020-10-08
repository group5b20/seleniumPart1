package com.cybertek.bitrix.Talant;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VisualEditor {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //Open Chrome
        driver = WebDriverFactory.getDriver("chrome");
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize
        driver.manage().window().maximize();
        //Go to "https://login2.nextbasecrm.com/"
        driver.get("https://login2.nextbasecrm.com/");
        //Enter username and password
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk5@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser" + Keys.ENTER);
        //driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Test
    //User should be able to click on Visual Editor and
    // see the editor text-bar displays on top of the message box.
    public void verifyVisualEditor(){
        //locate "Task" and click
        driver.findElement(By.xpath("//span[.='Task']")).click();
        //locate Visual Editor Icon
        WebElement VisualEditorIcon = driver.findElement(By.xpath("//span[@id='lhe_button_editor_task-form-lifefeed_task_form']"));
        VisualEditorIcon.click();
        //verify if Editor text-bar is displayed
        WebElement EditorTextBar = driver.findElement(By.xpath("//div[@id='bx-html-editor-tlbr-lifefeed_task_form']"));
        Assert.assertTrue(EditorTextBar.isDisplayed(),"Text-Bar is NOT Displayed");
    }

    @Test
    //User should be able to add attendees by selecting contacts individually,add group and department
    public void add_meeting_attendees()throws InterruptedException{
        //locate "Event" and click
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']")).click();
        //Locate "Add person,group or department"
        driver.findElement(By.xpath("//a[@id='feed-event-dest-add-link']")).click();
        BrowserUtils.wait(1);
        //Locate "Employee and Departments" and click
        driver.findElement(By.xpath("//a[@id='destDepartmentTab_calnAJEM3']")).click();

        //add Attendees
        WebElement attendee = driver.findElement(By.xpath("//div[@id='bx-lm-category-relation-129']//a//div//div"));
        attendee.click();
        BrowserUtils.wait(1);

        //add Department and Click
        //IT Dropdown and Click
        driver.findElement(By.xpath("//div[@class='bx-finder-company-department']//a//div[2]")).click();
        BrowserUtils.wait(1);
        WebElement department = driver.findElement(By.xpath("//span[@class='bx-finder-company-department-check-inner']//div[2]"));
        department.click();

        //add groups
        //Go to My Group
        driver.findElement(By.xpath("//a[@id='destGroupTab_calnAJEM3']")).click();
        //Click on Soccer team
        BrowserUtils.wait(1);
        WebElement group = driver.findElement(By.xpath("//a[@id='calnAJEM3_group_SG4']"));
        group.click();

        //Verify if Attendee,Department & Group Added
        //Locate Input
        WebElement AddedInput = driver.findElement(By.xpath("//span[@id='feed-event-dest-item']"));

        if(AddedInput.getText().contains(attendee.getText()) &&
                AddedInput.getText().contains(department.getText()) &&
                AddedInput.getText().contains(group.getText())){
            System.out.println("Verification PASSED");
        }else{
            System.out.println("Verification FAILED!!!");
        }

    }
    @AfterMethod
    public void close(){
        driver.close();
    }
}