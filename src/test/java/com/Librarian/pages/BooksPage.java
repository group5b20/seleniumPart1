package com.Librarian.pages;

import com.Librarian.utils.BrowserUtils;
import com.Librarian.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BooksPage extends BasePage {
    @FindBy(xpath = "//table[@id='tbl_books']//tr[1]/td[1]")
    private WebElement editBookBtn;


    public void editBookBtn(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.elementToBeClickable(editBookBtn)).click();
        System.out.println("Clicking on 'Edit book' button");
    }

    WebDriver driver;
    public void editBookBtn(int number){
       if (number>=1) {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
            WebElement editBookBtnN = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='tbl_books']//tr["+number+"]/td[1]")));
            wait.until(ExpectedConditions.elementToBeClickable(editBookBtnN)).click();
            System.out.println("Clicking on 'Edit book' button line "+number);
        }else {
            System.out.println("Number cannot be 0");
      }
    }

}
