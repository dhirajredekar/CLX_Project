package com.clx.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clx.qa.base.TestBase;

public class ContactManager extends TestBase{
	
	//Page Factory
	@FindBy(xpath="//div[@class='logo pull-left']")
	WebElement contactManagerLogo;
	
	@FindBy(xpath="//span[@class='sprite default-plus' and @tooltip='Add']")
	WebElement createNewContact;
	
	@FindBy(xpath="//div[@class='form-control-width-correct ui-select-container "
			+ "selectize-control single ng-invalid ng-invalid-required']"
			+ "//input[@class='ui-select-search ui-select-toggle ng-pristine ng-"
			+ "untouched ng-valid']")
	WebElement contactType;
	
	@FindBy(xpath="//div[@class='option ui-select-choices-row-inner' ]")
	WebElement contactSubType;
	
	@FindBy(xpath="//input[@data-ng-model='addContact.contact.first_name' and @name='first_name' ]")
	WebElement contactFirstName;
	
	@FindBy(xpath="//input[@data-ng-model='addContact.contact.middle_name']")
	WebElement contactMidName;
	
	@FindBy(xpath="//input[@data-ng-model='addContact.contact.last_name']")
	WebElement contactLastName;
	
	/*
	 * INITILAZATING OF PAGE OBJECT FOR CONTACT MANAGER PAGE
	*/
	public ContactManager() {
		PageFactory.initElements(driver, this);
	}
	
	//ACTIONS
	public boolean verifyContactManagerLogo() {
		return contactManagerLogo.isDisplayed();
	}
	
	public void validateAddNewContact(String type, String fname, String mname, String lname) throws Exception {
		Actions act = new Actions(driver);
		act.moveToElement(createNewContact).click().build().perform();
		Thread.sleep(20000);
		contactType.sendKeys(type);
		contactSubType.click();
		Thread.sleep(3000);
		contactFirstName.sendKeys(fname);
		contactMidName.sendKeys(mname);
		contactLastName.sendKeys(lname);
	}

}
