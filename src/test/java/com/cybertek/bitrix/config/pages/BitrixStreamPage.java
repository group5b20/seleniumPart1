package com.cybertek.bitrix.config.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BitrixStreamPage {

    public By eventTab = By.id("feed-add-post-form-tab-calendar");
    public By editorTextBar = By.id("lhe_button_editor_blogPostForm_calendar");

    public void goToEventTab() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        Driver.pageLoadTimeout();
        wait.until(ExpectedConditions.visibilityOfElementLocated(eventTab)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(editorTextBar)).click();
    }
}
