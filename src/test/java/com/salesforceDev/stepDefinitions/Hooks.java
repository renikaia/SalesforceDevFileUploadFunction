package com.salesforceDev.stepDefinitions;

import com.salesforceDev.pages.BasePage;
import com.salesforceDev.pages.ViewAllPage;
import com.salesforceDev.utilities.BrowserUtilities;
import com.salesforceDev.utilities.ConfigurationReader;
import com.salesforceDev.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Hooks {

    private static int id = 1;
    BasePage basePage = new BasePage();


    @Before
    public void setDriver() {
        String username = "nihalimek@gmail.com";
        String password = "dyvmy8-rEhsag-birgaf";

        Driver.getDriver().get(ConfigurationReader.getProperty("homePage"));
        basePage.usernameInput.sendKeys(username);
        basePage.passwordInput.sendKeys(password);
        basePage.loginButton.click();
        BrowserUtilities.waitFor(3);
        Assert.assertTrue(basePage.appLauncherButton.isDisplayed());
        basePage.appLauncherButton.click();
        basePage.viewAllButton.click();
        basePage.accountsParagraph.click();
        BrowserUtilities.waitFor(3);










    }

    @After
    public void teardownScenario(Scenario scenario) throws IOException {
        ViewAllPage viewAllPage = new ViewAllPage();

        while(viewAllPage.selectButton.isDisplayed()){
        viewAllPage.selectButton.click();
        viewAllPage.deleteLinkAfterSelectButton.click();
        viewAllPage.deleteButtonPopup.click();}

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", (id++) + scenario.getName());
        }
        Driver.closeDriver();
    }

}
