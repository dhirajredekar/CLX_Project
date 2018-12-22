package com.clx.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clx.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory : OR

	@FindBy(id = "exampleInputEmail1")
	WebElement username;

	@FindBy(id = "exampleInputPassword1")
	WebElement password;

	@FindBy(xpath = "//input[@value='LOGIN']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[contains(@class, 'forget-pass')]")
	WebElement forgetpassword;

	@FindBy(xpath = "//img[@title='Logo']")
	WebElement CLXLogo;

	// Initialization of Page Object
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCloudlexLogo() {
		return CLXLogo.isDisplayed();

	}

	public Launcher Login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new Launcher();
	}

}
