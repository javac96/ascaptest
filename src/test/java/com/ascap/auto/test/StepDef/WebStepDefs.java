package com.ascap.auto.test.StepDef;

import java.io.IOException;

import org.junit.Assert;

import com.ascap.common.BasePage;
import com.ascap.common.ScreenshotUtil;
import com.ascap.common.SupportUtils;
import com.ascap.common.WebConnector;
import com.ascap.maps.DataMaps;
import com.ascap.pages.Dashboard;
import com.ascap.pages.MembershipApplicationPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebStepDefs {
	Dashboard db = new Dashboard();
	MembershipApplicationPage membershipApplication = new MembershipApplicationPage();

	@Given("^User is in \"([^\"]*)\" using \"([^\"]*)\" browser$")
	public void navigationToDashboard(String pageName, String browserName) {
		Assert.assertTrue(pageName + " is not displayed.", db.validateDashboard());
	}
	
	@Given("^User is in \"([^\"]*)\"$")
	public void navigationToDashboard(String pageName) {
		Assert.assertTrue(pageName + " is not displayed.", db.validateDashboard());
	}
	
	//@Given("^User is in \"([^\"]*)\"$", (String pageName) ->{
		//Assert.assertTrue(pageName + " is not displayed.", db.validateDashboard());
	//})

	@When("^User selects \"([^\"]*)\" tab$")
	public void selectTab(String tab) {
		db.clickOnTabOrTab(tab);
	}

	@And("^User clicks on \"([^\"]*)\" link$")
	public void clickOnLink(String link) {
		db.clickOnTabOrTab(link);
	}
	
	@When("^User selects membership type as \"([^\"]*)\" in page \"([^\"]*)\"$")
	public void selectMembershipType(String dataType, String pageName) {
		membershipApplication.selectMemberType(pageName, dataType);
	}
	

	@Then("^User navigates to the \"([^\"]*)\" page$")
	public void navigateToPage(String pageName) {
		Assert.assertTrue(pageName + " page not displayed",
				pageName.equalsIgnoreCase(membershipApplication.getEnrollmentPageHeader()));

	}
	
	@When("^User selects membership type as \"([^\"]*)\"$")
	public void selectMembershipType(String type) {
		membershipApplication.selectWriter();
	}
	
    @And("^User clicks on \"([^\"]*)\" button in \"([^\"]*)\" page$")
    public void clickOnButton(String buttonType, String pageName) {
    	switch(pageName.toUpperCase()) {
    	case "MEMBERSHIP APPLICATION":
    		membershipApplication.clickOnContinue();
    		break;
    	default:
    		break;	
    	}
    }

    @Then("^System should display the General Section$")
    public void validateGeneralSection() throws IOException {
    	//ScreenshotUtil.embedScreenShot(com.ascap.maps.DataMaps.outputmap.get("currentScenario"));
    	Assert.assertTrue("General Section is not displayed.",membershipApplication.validateGeneralSection());
    	//membershipApplication.writeExtentFail("Scenario Failed.",membershipApplication.w );
    }
    
    @When("^User clicks on \"([^\"]*)\" for a writer member of a different PRO$")
    public void clickOnYesNoNotSureTab(String tabName) {
    	
    }
    
    @And("^User fills the general information section$")
    public void fillMemberGeneralInfo() {
    	
    }
    
    @Then("^System should display the Royalty Section$")
    public void displayRoyaltySection() {
    	
    }

}
