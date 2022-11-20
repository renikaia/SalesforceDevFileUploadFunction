Feature: Uploading different types of files

  Scenario: User can upload only one file
  Given user is on the homepage of the application
    When user uploads only one file
    And user clicks view all button
    Then user should be able to see the uploaded file there

    Scenario: User can upload multiple files
      Given user is on the homepage of the application
      When user uploads different files at the same time
      And user clicks view all button
      Then user should be able to see uploaded files there



