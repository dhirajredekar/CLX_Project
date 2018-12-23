package com.clx.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clx.qa.base.TestBase;

public class MatterManager extends TestBase {
	
	// Page Factory : OR
	
	@FindBy(xpath="//div[@ng-click='pageheader.stateChange()']")
	WebElement MMLogo;
	
	/*
	 * INITILAZATING OF PAGE OBJECT FOR MATTER MANAGER PAGE
	 */

	public MatterManager() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateMatterManagerLogo() {
		return MMLogo.isDisplayed();

	}
}
