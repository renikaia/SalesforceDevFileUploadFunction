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

    @FindBy (xpath = "(//a[.='Delete'])[1]")
    public WebElement deleteLinkAfterSelectButton;

    @FindBy (xpath = "//button[.='Delete']")
    public WebElement deleteButtonPopup;

    @FindBy (xpath = "//input[@type='file']")
    public WebElement fileUploadButton;

    @FindBy (xpath = "//button[. = 'Done']")
    public WebElement doneButtonAfterUploadingFile;

    @FindBy (xpath = "//button[. = 'Close this window']")
    public WebElement closeButtonAfterUploadingFile;

    @FindBy (xpath = "(//span[.='Notes & Attachments'])[6]")
    public WebElement viewAllButton;

    @FindBy (xpath = "(//th[@class='slds-cell-edit cellContainer'])[3]//span[@title='fileToUploadAsWebP']")
    public WebElement webPFileInTheViewAllPage;







}
