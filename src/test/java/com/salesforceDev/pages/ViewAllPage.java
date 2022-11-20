package com.salesforceDev.pages;

import com.salesforceDev.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAllPage {
    public ViewAllPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy ( xpath = "(//td[@role='gridcell']//a[@role='button'])[3]")
    public WebElement selectButton;

    @FindBy (xpath = "//a[.='Delete']")
    public WebElement deleteLinkAfterSelectButton;

    @FindBy (xpath = "//button[.='Delete']")
    public WebElement deleteButtonPopup;






}
