package com.ascap.auto.test.StepDef;

import java.io.IOException;

import com.ascap.common.SupportUtils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/*We can perform:
Starting a webdriver
Setting up DB connections
Setting up test data
Setting up browser cookies
Navigating to certain page
or anything before the test
*/
public class Hooks {

	SupportUtils supportUtils;

	public Hooks(SupportUtils supportUtils) {
		this.supportUtils = supportUtils;
	}

	@Before
	public void setUpLandingPage() {
		supportUtils.openBrowser();
		supportUtils.navigateToUrl();
	}

	@After
	public void tearDown(Scenario scenario) {
		supportUtils.takeFailedScreenshot(scenario);
	}

}
