package com.ascap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ascap.common.BasePage;

public class MembershipApplicationPage extends BasePage {

	By enrollmentPageHeader = By.xpath("//*[@id='title']");
	By writerMembershipType = By.xpath("//h5[text()='Writer']");
	By buttonContinue = By.xpath("//*[@id='omeAll']/div/form/section[1]/div/div[2]/div/button");
	By generalHeader = By.xpath("//h5[contains(text(), 'performing rights organization')]");
	By royaltySectionLoc = By.xpath("//h5[contains(text(), 'Royalty Address')]");
	By selectOptions = By.xpath("//div[@class='card select gershwin p-2 my-2']");
	By firstNameTextBox = By.xpath("//input[@name='writer_firstName']");
	By lastNameTextBox = By.xpath("//input[@name='writer_lastName']");
	By monthDropdownValues = By.xpath("//*[@id='dob']/div/div[1]/div/div/div/ul/li");
	By monthDropdown = By.xpath("//*[@id='dob']/div/div[1]/div/div/button");
	By dateDropdown = By.xpath("//*[@id='dob']/div/div[1]/div/div/button");
	By yearTextBox = By.xpath("//input[@name='writer_DOBYear']");
	By residentUSRadioBtn = By.xpath("//input[@id='radio-button-writer_USResident0']");
	

	public String getEnrollmentPageHeader() {
		return waitForElement(enrollmentPageHeader).getText().trim();
	}

	public void selectWriter() {
		clickWithJavaScript(waitForElement(writerMembershipType));
	}

	public void clickOnContinue() {
		clickWithJavaScript(waitForElement(buttonContinue));
	}

	public boolean validateGeneralSection() {
		return waitForElement(generalHeader).isDisplayed();
	}

	public void selectMemberType(String pageName, String dataType) {
		testData = getDataFromJson(pageName, dataType);
		selectMembershipType(testData);
	}

	private void selectMembershipType(String memberType) {
		switch (memberType.toUpperCase()) {
		case "WRITER":
			clickWithJavaScript(waitForElement(writerMembershipType));
			break;
		case"Publiser":
			//
		default:
			break;
		}

	}

}
