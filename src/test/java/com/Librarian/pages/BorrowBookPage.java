package com.Librarian.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BorrowBookPage extends BasePage{


    @FindBy(xpath = "(//a[.=' Borrow Book'])[2]")
    public WebElement borrowBookBtn;

    @FindBy(xpath = "//span[.='Borrowing Books']")
    public WebElement borrowedBooksBtn;





}
