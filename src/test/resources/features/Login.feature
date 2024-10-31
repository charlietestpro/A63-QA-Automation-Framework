Feature: Login Feature

  Scenario: Login Positive scenario
    Given I open browser
    And I open Koel login page
    When I enter email "charlie.hall@testpro.io"
    And I enter password "8y4me5ba"
    And I submit
    Then I am logged in


