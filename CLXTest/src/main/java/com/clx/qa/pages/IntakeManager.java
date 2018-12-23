package com.clx.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clx.qa.base.TestBase;

public class IntakeManager extends TestBase {
	
	//Page Factory or OR
	@FindBy(xpath="//div[@ng-click='pageheader.stateChange()' ]//span[contains(text(), 'Intake Manager')]")
	WebElement IntakeManagerLogo;
	
	/*
	 * INITILAZATING OF PAGE OBJECT FOR INTAKE MANAGER PAGE
	 */

	public IntakeManager() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateIntakeManagerLogo() {
		return IntakeManagerLogo.isDisplayed();

	}
}
