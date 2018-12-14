package com.ascap.pages;

import org.openqa.selenium.By;

import com.ascap.common.BasePage;

public class Dashboard extends BasePage {

	By dashboardSearchBox = By.xpath("//*[@id='search-input']");
	By musicCreatorTab = By.xpath("//p[contains(text(), 'Music Creators')]");
	By joinLink = By.xpath("//a[contains(text(), 'Join')]");

	public boolean validateDashboard() {
		return waitForElement(dashboardSearchBox).isDisplayed();
	}

	public void clickOnTabOrTab(String item) {
		switch (item.toUpperCase()) {
		case "MUSIC CREATORS":
			clickWithJavaScript(waitForElement(musicCreatorTab));
			sleep(3);
			break;
		case "JOIN":
			clickWithJavaScript(waitForElement(joinLink));
			sleep(3);
			break;
		default:
			break;
		}

	}

	public void clickOnJoinLink() {
		clickWithJavaScript(waitForElement(musicCreatorTab));
	}

}
