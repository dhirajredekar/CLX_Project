package com.clx.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clx.qa.base.TestBase;

public class Launcher extends TestBase {

	// Page Factory : OR

	@FindBy(xpath = "//span[contains(text(), 'LaunchPad')]")
	WebElement LaunchPadLogo;

	@FindBy(xpath = "//div[@class='details-block']//span[@style='cursor: pointer;' and contains(text(), 'MATTER MANAGER')]")
	WebElement MatterManager;

	@FindBy(xpath = "//div[@class='details-block']//span[@style='cursor: pointer;' and contains(text(), 'INTAKE MANAGER')]")
	WebElement IntakeManager;

	@FindBy(xpath = "//div[@class='details-block']//span[@style='cursor: pointer;' and contains(text(), 'REFERRAL ENGINE')]")
	WebElement ReferralEngine;

	@FindBy(xpath = "//div[@class='details-block']//span[@style='cursor: pointer;' and contains(text(), 'DIGITAL ARCHIVER')]")
	WebElement DigitalArchival;
	
	@FindBy(xpath="//div[@class='details-block']//span[@class='title cursor-pointer' and contains(text(), 'CONTACT MANAGER')]")
	WebElement ContactManager;
	
	@FindBy(xpath="//div[@class='details-block']//span[@style='cursor: pointer;' and contains(text(), 'MARKETPLACE')]")
	WebElement Marketplace;

	@FindBy(xpath = "//div[@class='padding-left-0 margin-top10px col-md-6 ng-binding']")
	WebElement userNameLabel;

	/*
	 * INITILAZATING OF PAGE OBJECT FOR LAUCHER PAGE
	 */

	public Launcher() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * LIST OF THE ACTION FOR LAUNCHER TEST CLASS
	 */
	public String verifyLauncherTitlePage() {
		return driver.getTitle();
	}

	public MatterManager clickOnMatterManager() {
		Actions act = new Actions(driver);
		act.moveToElement(MatterManager).click().build().perform();
		return new MatterManager();
	}

	public IntakeManager clickOnIntakeManager() {
		Actions act = new Actions(driver);
		act.moveToElement(IntakeManager).click().build().perform();
		return new IntakeManager();
	}

	public DigitalArchival clickonDigitalArchival() {
		Actions act = new Actions(driver);
		act.moveToElement(DigitalArchival).click().build().perform();
		return new DigitalArchival();

	}

	public ReferralEngine clickonReferralEngine() {
		Actions act = new Actions(driver);
		act.moveToElement(ReferralEngine).click().build().perform();
		return new ReferralEngine();

	}
	
	public ContactManager clickonContactManager() {
		Actions act = new Actions(driver);
		act.moveToElement(ContactManager).click().build().perform();
		return new ContactManager();

	}
	
	public Marketplace clickonMarketplace() {
		Actions act = new Actions(driver);
		act.moveToElement(Marketplace).click().build().perform();
		return new Marketplace();

	}

	public boolean validateLauncherLogo() {
		return LaunchPadLogo.isDisplayed();

	}

	public boolean correctUserName() {
		return userNameLabel.isDisplayed();
	}

}
