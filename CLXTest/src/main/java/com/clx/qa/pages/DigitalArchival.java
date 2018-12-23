package com.clx.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clx.qa.base.TestBase;

public class DigitalArchival extends TestBase {
	
	/**
	 * PAGE FACTORY OR OBJECT REPO
	 */
	@FindBy(xpath="//div[@ng-click='pageheader.stateChange()' ]//span[contains(text(), 'Digital Archiver')]")
	WebElement DigitalArchivalLogo;
	
	/*
	 * INITILAZATING OF PAGE OBJECT FOR DIGITAL ARCHIVAL PAGE
	 */
	public DigitalArchival() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateDigitalArchivalLogo() {
		return DigitalArchivalLogo.isDisplayed();

	}
}
