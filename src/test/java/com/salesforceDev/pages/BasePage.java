package com.salesforceDev.pages;

import com.salesforceDev.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#Username")
    public WebElement usernameInput;

    @FindBy(css = "#Password")
    public WebElement passwordInput;

    @FindBy(css = "#Login")
    public WebElement loginButton;

    @FindBy(xpath = "//button[. = 'App Launcher']")
    public WebElement appLauncherButton;

    @FindBy(xpath = "//button[. = 'View All']")
    public WebElement viewAllButton;

    @FindBy(xpath = "//p[. = 'Accounts']")
    public WebElement accountsParagraph;

    @FindBy(xpath = "//div/span[. = 'Accounts']")
    public WebElement accountsHeader;

    @FindBy(xpath = "//tr[1]//a[. = 'CyanGate']")
    public WebElement firstCyanGateAccount;








}
