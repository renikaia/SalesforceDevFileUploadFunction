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

    String pathForMP4 = "/Users/kaya/IdeaProjects/SalesforceDevFileUploadFunction/filesUsedForUploadTest/fileToUploadAsMP4.mp4";
    String pathForPDF = "/Users/kaya/IdeaProjects/SalesforceDevFileUploadFunction/filesUsedForUploadTest/fileToUploadAsPDF.pdf";
    String pathForPPT = "/Users/kaya/IdeaProjects/SalesforceDevFileUploadFunction/filesUsedForUploadTest/fileToUploadAsPPT.pptx";
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
        jse.executeScript("window.scrollBy(0,1500)");
        BrowserUtilities.verifyElementDisplayed(viewAllPage.viewAllButton);
        jse.executeScript("arguments[0].click();", viewAllPage.viewAllButton);
        BrowserUtilities.waitFor(3);

    }

    @Then("user should be able to see the uploaded file there")
    public void userShouldBeAbleToSeeTheUploadedFileThere() {
        Driver.getDriver().navigate().refresh();
        BrowserUtilities.waitFor(5);
        Assert.assertTrue(viewAllPage.webPFileInTheViewAllPage.isDisplayed());

    }

    @When("user uploads different files at the same time")
    public void userUploadsDifferentFilesAtTheSameTime() {

        jse.executeScript("window.scrollBy(0,1500)");
        viewAllPage.fileUploadButton.sendKeys(pathForPPT + "\n" + pathForPDF + "\n" + pathForMP4);
        BrowserUtilities.waitFor(30);
        if (viewAllPage.doneButtonAfterUploadingFile.isDisplayed()) {
            try {
                do {
                    viewAllPage.closeButtonAfterUploadingFile.click();
                    BrowserUtilities.waitFor(3);
                }
                while (viewAllPage.closeButtonAfterUploadingFile.isDisplayed());
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
        Driver.getDriver().navigate().refresh();

    }

}
