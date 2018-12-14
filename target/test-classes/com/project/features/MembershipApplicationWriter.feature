@MembershipApplicationWriters
Feature: Membership Application flow

  Background: 
    Given User is in "ASCAP Dashboard" using "Chrome" browser
   # Given User is in "ASCAP Dashboard"

  @writer_US_resident_no_DD
  Scenario: Validate the Writer enrollment for US resident without direct deposit
    When User selects "Music Creators" tab
    And User clicks on "Join" link
    Then User navigates to the "Membership Application" page
    When User selects membership type as "Writer"
    And User clicks on "Continue" button in "Membership Application" page
    Then System should display the General Section
    When User clicks on "No" for a writer member of a different PRO
    And User fills the general information section 
    And User clicks on "Continue" button in "Membership Application" page
    Then System should display the Royalty Section
    

  #And User selects "No" for a member of different PRO
  #When User completes General section with required information
  #And User clicks on "Continue" button in "Membership Application" page
  #Then System should display the Royalties Section
  
  @writer_US_resident_with_DD  @regression
  Scenario Outline: Validate the Writer enrollment for US resident without direct deposit
    When User selects "Music Creators" tab
    And User clicks on "Join" link
    Then User navigates to the "Membership Application" page
    When User selects membership type as "<membershipType>" in page "<pageName>"
    And User clicks on "Continue" button in "Membership Application" page
    Then System should display the General Section

    Examples: 
      | pageName              | membershipType |
      | MembershipApplication | writer         |
      #| MembershipApplication | publisher      |
