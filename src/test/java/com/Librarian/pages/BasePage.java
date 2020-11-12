package com.Librarian.pages;

import com.Librarian.utils.BrowserUtils;
import com.Librarian.utils.ConfigurationReader;
import com.Librarian.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    @FindBy(className = "spapp-created")
    protected WebElement pageSubTitle;

    @FindBy(xpath = "(//button[contains(text(),'Save and Close')])[1]")
    protected WebElement saveAndCloseBtn;

    @FindBy(css = "[class='loader-mask']")
    protected WebElement loaderMask;

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public String getPageSubTitleText() {
        return pageSubTitle.getAttribute("id");
    }

    public void navigateTo(String module) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        String moduleXpath = module.toLowerCase();

        WebElement moduleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@href='#"+moduleXpath+"']"))); ////*[@id="menu_item"]/li[1]/a
        wait.until(ExpectedConditions.elementToBeClickable(moduleElement)).click();

    }

    public void clickSaveAndClose(){
        BrowserUtils.clickOnElement(saveAndCloseBtn);
    }
}


