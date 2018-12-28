package com.clx.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clx.qa.base.TestBase;

public class ContactManager extends TestBase {

	// Page Factory
	@FindBy(xpath = "//div[@class='logo pull-left']")
	WebElement contactManagerLogo;

	@FindBy(xpath = "//span[@class='sprite default-plus' and @tooltip='Add']")
	WebElement AddNewIcon;

	@FindBy(xpath = "//div[@class='form-control-width-correct ui-select-container "
			+ "selectize-control single ng-invalid ng-invalid-required']"
			+ "//input[@class='ui-select-search ui-select-toggle ng-pristine ng-" + "untouched ng-valid']")
	WebElement contactType;

	@FindBy(xpath = "//small[@class='ng-binding ng-scope' and contains(text(), 'Person')]")
	WebElement person;

	@FindBy(xpath = "//small[@class='ng-binding ng-scope' and contains(text(), 'Client')]")
	WebElement client;

	@FindBy(xpath = "//small[@class='ng-binding ng-scope' and contains(text(), 'Estate Administrator')]")
	WebElement estateAdministrator;

	@FindBy(xpath = "//small[@class='ng-binding ng-scope' and contains(text(), 'Estate Executor')]")
	WebElement estateExecutor;

	@FindBy(xpath = "//small[@class='ng-binding ng-scope' and contains(text(), 'Business')]")
	WebElement business;

	@FindBy(xpath = "//small[@class='ng-binding ng-scope' and contains(text(), 'Educational Institution')]")
	WebElement educationalInstitution;

	@FindBy(xpath = "//small[@class='ng-binding ng-scope' and contains(text(), 'Government')]")
	WebElement government;

	@FindBy(xpath = "//small[@class='ng-binding ng-scope' and contains(text(), 'Insurance Company')]")
	WebElement insuranceCompany;

	@FindBy(xpath = "//small[@class='ng-binding ng-scope' and contains(text(), 'Court')]")
	WebElement court;

	@FindBy(xpath = "//small[@class='ng-binding ng-scope' and contains(text(), 'Medical Provider')]")
	WebElement medicalProvider;

	@FindBy(xpath = "//small[@class='ng-binding ng-scope' and contains(text(), 'Doctor')]")
	WebElement doctor;

	@FindBy(xpath = "//small[@class='ng-binding ng-scope' and contains(text(), 'Law Firm')]")
	WebElement lawFirm;

	@FindBy(xpath = "//small[@class='ng-binding ng-scope' and contains(text(), 'Other')]")
	WebElement other;

	@FindBy(xpath = "//input[@data-ng-model='addContact.contact.first_name' and @name='first_name' ]")
	WebElement contactFirstName;

	@FindBy(xpath = "//input[@data-ng-model='addContact.contact.middle_name']")
	WebElement contactMidName;

	@FindBy(xpath = "//input[@data-ng-model='addContact.contact.last_name']")
	WebElement contactLastName;

	@FindBy(xpath = "//input[@data-ng-model='addContact.contact.specialty']")
	WebElement specialty;

	@FindBy(xpath = "//input[@data-ng-model='addContact.contact.company']")
	WebElement company;

	@FindBy(xpath = "//input[@data-ng-model='emailid.name']")
	WebElement emailid;

	@FindBy(xpath = "//input[@data-ng-model='phone.name']")
	WebElement cellNumber;

	@FindBy(xpath = "//button[@class='btn btn-default' and contains(text(), 'Save')]")
	WebElement saveBtn;

	@FindBy(xpath = "//button[@class='btn btn-default btn-styleNone' and contains(text(), 'Yes')]")
	WebElement duplicateYes;

	/*
	 * INITILAZATING OF PAGE OBJECT FOR CONTACT MANAGER PAGE
	 */
	public ContactManager() {
		PageFactory.initElements(driver, this);
	}

	// ACTIONS
	public boolean verifyContactManagerLogo() {
		return contactManagerLogo.isDisplayed();
	}

	public void validateAddNewContact(String spec, String comp, String fname, String mname, String lname, String email,
			String cell) throws Exception {
		Actions act = new Actions(driver);
		act.moveToElement(AddNewIcon).click().build().perform();
		contactType.click();
		person.click();
		specialty.sendKeys(spec);
		company.sendKeys(comp);
		contactFirstName.sendKeys(fname);
		contactMidName.sendKeys(mname);
		contactLastName.sendKeys(lname);
		emailid.sendKeys(email);
		cellNumber.sendKeys(cell);
		saveBtn.click();
		Thread.sleep(10000);

	}

	public void handleDuplicateContact() {
		Actions act = new Actions(driver);
		act.moveToElement(duplicateYes).click().build().perform();
	}

}
