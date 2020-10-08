package com.cybertek.bitrix.fatih;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Us3Ac2_link {
/*
User Story – 3 As a user, I should be able to create events
by clicking on Event tab under Activity Stream..


 2. User should be able to attach link by clicking on the link icon

3. User should be able to insert videos by clicking on the video icon
and entering the video URL.
*/
    @Test
    public void AC2_attaching_link_and_text_under_event_of_activity_stream() {

//Open a browser and enter the bitrix web site
        Driver.getDriver().get(ConfigurationReader.getProperty("BitrixUrl"));

       // String actualTitle = Driver.getDriver().getTitle(); Assert.assertTrue(actualTitle.equals("Authorization"));

        //login the website by using correct credentials under conf properties
        Driver.getDriver().findElement(By.name("USER_LOGIN")).sendKeys(ConfigurationReader.getProperty("BitrixUsername"));
        Driver.getDriver().findElement(By.name("USER_PASSWORD")).sendKeys(ConfigurationReader.getProperty("BitrixPassword"));
        Driver.getDriver().findElement(By.className("login-btn")).click();

      //  String actualTitle2 = Driver.getDriver().getTitle(); Assert.assertTrue(actualTitle2.equals("(3) Portal"));

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // find event option under activestream
        Driver.getDriver().findElement(By.xpath("//*[text()='Event']")).click();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //find the link icon
        Driver.getDriver().findElement(By.xpath("//*[@id='bx-b-link-blogPostForm_calendar']/span/i")).click();
        //find the text box and enter the text "Gropu5"
        Driver.getDriver().findElement(By.id("linkoCalEditorcal_3Jcl-text")).sendKeys("Group5");
        //find the link box and the enter our group link and click ENTER
        Driver.getDriver().findElement(By.id("linkoCalEditorcal_3Jcl-href")).sendKeys("https://github.com/group5b20/seleniumPart1", Keys.ENTER);

        //Verify whether we enter the right group name
        WebElement link=Driver.getDriver().findElement(By.linkText("Group5"));
        String link1=link.getText();
        Assert.assertEquals(link1,"Group5","The link and the text were not properly insterted !!!");
        //close the browser
        Driver.getDriver().close();


    }
}