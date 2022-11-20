package com.salesforceDev.stepDefinitions;

import com.salesforceDev.pages.BasePage;
import com.salesforceDev.pages.ViewAllPage;
import com.salesforceDev.utilities.BrowserUtilities;
import com.salesforceDev.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

public class FileUploadingFuncStepDefs {

    BasePage basePage = new BasePage();
    ViewAllPage viewAllPage = new ViewAllPage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    String pathForMP4 = "https://github.com/nhlmk/SalesforceDevFileUploadFunction/blob/3c4e734b7c475f8dc8407e667496a83992920b70/filesUsedForUploadTest/fileToUploadAsMP4.mp4";
    String pathForPDF = "https://github.com/nhlmk/SalesforceDevFileUploadFunction/blob/3c4e734b7c475f8dc8407e667496a83992920b70/filesUsedForUploadTest/fileToUploadAsPDF.pdf";
    String pathForPPT = "https://github.com/nhlmk/SalesforceDevFileUploadFunction/blob/3c4e734b7c475f8dc8407e667496a83992920b70/filesUsedForUploadTest/fileToUploadAsPPT.pptx";
    String pathForWebP = "/Users/kaya/IdeaProjects/SalesforceDevFileUploadFunction/filesUsedForUploadTest/fileToUploadAsWebP.webp";

    @Given("user is on the homepage of the application")
    public void userIsOnTheHomepageOfTheApplication() {
        Assert.assertTrue(basePage.accountsHeader.isDisplayed());
        basePage.firstCyanGateAccount.click();
    }


    @When("user uploads only one file")
    public void userUploadsOnlyOneFile() {
        jse.executeScript("window.scrollBy(0,1500)");
        viewAllPage.fileUploadButton.sendKeys(pathForWebP);
        BrowserUtilities.waitFor(5);
        if (viewAllPage.doneButtonAfterUploadingFile.isDisplayed()) {
            viewAllPage.closeButtonAfterUploadingFile.click();
        }

    }

    @And("user clicks view all button")
    public void userClicksViewAllButton() {
        BrowserUtilities.waitFor(5);
        BrowserUtilities.verifyElementDisplayed(viewAllPage.viewAllButton);
        jse.executeScript("arguments[0].click();", viewAllPage.viewAllButton);
        BrowserUtilities.waitFor(3);

    }

    @Then("user should be able to see the uploaded file there")
    public void userShouldBeAbleToSeeTheUploadedFileThere() {
        Assert.assertTrue(viewAllPage.webPFileInTheViewAllPage.isDisplayed());
        //User deletes the file.

        try {

            do {
                jse.executeScript("arguments[0].click();", viewAllPage.selectButton);
                jse.executeScript("arguments[0].click();", viewAllPage.deleteLinkAfterSelectButton);
                jse.executeScript("arguments[0].click();", viewAllPage.deleteButtonPopup);
                BrowserUtilities.waitFor(5);
                Driver.getDriver().navigate().refresh();
                BrowserUtilities.waitFor(5);
            }
            while (viewAllPage.selectButton.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }

    @When("user uploads different files at the same time")
    public void userUploadsDifferentFilesAtTheSameTime() {

    }

    @Then("user should be able to see uploaded files there")
    public void userShouldBeAbleToSeeUploadedFilesThere() {
    }
}
