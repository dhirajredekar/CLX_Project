package com.clx.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clx.qa.base.TestBase;

public class Launcher extends TestBase {

	// Page Factory : OR

	@FindBy(xpath = "//span[contains(text(), 'LaunchPad')]")
	WebElement LaunchPadLogo;

	@FindBy(xpath = "//*[@id=\"myElement\"]/div[2]/div/div[3]/div/div/div[2]/div[1]/div/div/span")
	WebElement MatterManager;

	@FindBy(xpath = "//*[@id=\"myElement\"]/div[2]/div/div[3]/div/div/div[2]/div[2]/div/div/span")
	WebElement IntakeManager;

	//Initialization of Page Object:
	public Launcher() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String verifyLauncherTitlePage() {
		return driver.getTitle();
	}
	
	public MatterManager clickOnMatterManager() {
		MatterManager.click();
		return new MatterManager();
	}
	
	public IntakeManager clickOnIntakeManager() {
		IntakeManager.click();
		return new IntakeManager();
	}
	
	public boolean validateLauncherLogo() {
		return LaunchPadLogo.isDisplayed();

	}
	
	

}
