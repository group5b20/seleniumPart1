package com.cybertek.bitrix.fatih;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class login {
/*
User Story – 3 As a user, I should be able to create events
by clicking on Event tab under Activity Stream..


 2. User should be able to attach link by clicking on the link icon

3. User should be able to insert videos by clicking on the video icon
and entering the video URL.
*/
    @Test
    public void open_web_page() {
        //Driver

        Driver.getDriver().get(ConfigurationReader.getProperty("BitrixUrl"));

        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertTrue(actualTitle.equals("Authorization"));


        Driver.getDriver().findElement(By.name("USER_LOGIN")).sendKeys(ConfigurationReader.getProperty("BitrixUsername"));
        Driver.getDriver().findElement(By.name("USER_PASSWORD")).sendKeys(ConfigurationReader.getProperty("BitrixPassword"));
        Driver.getDriver().findElement(By.className("login-btn")).click();
        String actualTitle2 = Driver.getDriver().getTitle();
        System.out.println("actualTitle = " + actualTitle2);
        Assert.assertTrue(actualTitle2.equals("Portal"));

        Driver.getDriver().get("https://login2.nextbasecrm.com");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().findElement(By.xpath("//*[text()='Task']")).click();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().findElement(By.xpath("//*[@id='bx-b-link-task-form-lifefeed_task_form']/span/i")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id='linklifefeed_task_form-href']")).sendKeys("link");
        String actualTitle3 = Driver.getDriver().getTitle();
        System.out.println("actualTitle = " + actualTitle3);
        Assert.assertTrue(actualTitle3.equals("(9) Portal"));


    }
}//*[text()='Task']