package com.clx.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clx.qa.base.TestBase;

public class ReferralEngine extends TestBase {

	// Page Factory or OR
	@FindBy(xpath = "//div[@ng-click='pageheader.stateChange()' ]//span[contains(text(), 'Referral Engine')]")
	WebElement ReferralEngineLogo;

	/*
	 * INITILAZATING OF PAGE OBJECT FOR INTAKE MANAGER PAGE
	 */
	public ReferralEngine() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateReferralEngineLogo() {
		return ReferralEngineLogo.isDisplayed();

	}

}
