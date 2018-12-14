package com.ascap.managers;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	private WebDriver driver;
	//first create a constructor of this class 
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
		//create class variable of all pageclasses here, in this class create object of all pages and create getPageName() methods
	//for every class then call this page from WebStepdef to initialize the 
	//page class in webstepdef
}
