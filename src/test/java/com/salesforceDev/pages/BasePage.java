package com.salesforceDev.pages;

import com.salesforceDev.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#username")
    public WebElement usernameInput;

    @FindBy(css = "#password")
    public WebElement passwordInput;

    @FindBy(id = "Login")
    public WebElement loginButton;

    @FindBy(xpath = "//button[. = 'App Launcher']")
    public WebElement appLauncherButton;

    @FindBy(xpath = "//button[. = 'View All']")
    public WebElement viewAllButton;

    @FindBy(xpath = "//a[@data-label='Accounts']/parent::*")
    public WebElement accountsParagraph;

    @FindBy(xpath = "//div/span[. = 'Accounts']")
    public WebElement accountsHeader;

    @FindBy(xpath = "//tr[1]//a[. = 'CyanGate']")
    public WebElement firstCyanGateAccount;

    @FindBy (xpath = "(//input[@type='search'])[3]")
    public WebElement inputSearchBox;








}
