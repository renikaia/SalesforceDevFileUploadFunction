package com.salesforceDev.stepDefinitions;

import com.salesforceDev.pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FileUploadingFuncStepDefs {

    BasePage basePage = new BasePage();
    @Given("user is on the homepage of the application")
    public void userIsOnTheHomepageOfTheApplication() {
        Assert.assertTrue(basePage.accountsHeader.isDisplayed());
        basePage.firstCyanGateAccount.click();
    }


    @When("user uploads only one file")
    public void userUploadsOnlyOneFile() {
    }

    @And("user clicks view all button")
    public void userClicksViewAllButton() {
    }

    @Then("user should be able to see the uploaded file there")
    public void userShouldBeAbleToSeeTheUploadedFileThere() {
    }

    @When("user uploads different files at the same time")
    public void userUploadsDifferentFilesAtTheSameTime() {
    }

    @Then("user should be able to see uploaded files there")
    public void userShouldBeAbleToSeeUploadedFilesThere() {
    }
}
