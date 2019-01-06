package com.clx.qa.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clx.qa.base.TestBase;

public class ContactManager extends TestBase {

	// Page Factory
	@FindBy(xpath = "//div[@class='logo pull-left']")
	WebElement contactManagerLogo;
	
	@FindBy(xpath="//div[@class='col-md-4 pull-left paddingRLR dropdown create top-icon-set']//a//span")
	WebElement EditDeleteIcon;

	@FindBy(xpath = "//span[@class='sprite default-plus' and @tooltip='Add']")
	WebElement AddNewIcon;

	@FindBy(xpath = "//div[@class='form-control-width-correct ui-select-container "
			+ "selectize-control single ng-invalid ng-invalid-required']"
			+ "//input[@class='ui-select-search ui-select-toggle ng-pristine ng-" + "untouched ng-valid']")
	WebElement contactType;

	@FindBy(xpath = "//input[@type='search' and @placeholder='Enter type']")
	WebElement enterContactType;

	@FindBy(xpath = "//small[@class='ng-binding ng-scope']")
	WebElement contactTypeSelect;

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

	@FindBy(xpath = "//span[@class='sprite default-filter' and @tooltip='Filter']")
	WebElement contactFilterIcon;

	@FindBy(xpath = "//button[@class='btn btn-default pull-right' and contains(text(), 'Apply')]")
	WebElement contactFilterApply;

	@FindBy(xpath = "//li[@class='paddingRLR ng-scope']")
	WebElement filterApplied;

	@FindBy(xpath = "//div[@class='col-md-12 gray-border']//input[@placeholder='Select type']")
	WebElement mainAddress;

	@FindBy(xpath = "//div[@class='option ui-select-choices-row-inner']//small")
	WebElement addressType;

	@FindBy(xpath = "//input[@name='street']")
	WebElement street;

	@FindBy(xpath = "//input[@name='city_name']")
	WebElement city;

	@FindBy(xpath = "//div[@class='col-md-6 ng-scope']//div[@class='col-md-6']"
			+ "//div[@class='form-control-width-correct ui-select-container selectize-control single ng-valid']"
			+ "//div[@class='selectize-input']//input")
	WebElement State;
	
	@FindBy(xpath="//input[@type='search' and @placeholder='Select State']")
	WebElement enterState;

	@FindBy(xpath = "//div[@ng-repeat='list in addContact.contact.address']//small[@class='ng-binding ng-scope']")
	WebElement StateFromDropDown;

	@FindBy(xpath = "//input[@name='zipcode_name']")
	WebElement Zip_Code;

	@FindBy(xpath = "//input[@name='fax']")
	WebElement fax;

	@FindBy(xpath = "//span[@class='sprite default-delete' and @tooltip='Delete']")
	WebElement deleteContact;

	@FindBy(xpath = "//button[@type='button' and contains(text(), Calcel)]")
	WebElement cancelDeleteContact;

	@FindBy(xpath = "//button[@type='button' and contains(text(), Cancel)]//following-sibling::button")
	WebElement DeleteLocalContact;
	
	@FindBy(xpath="//span[@class='sprite default-file sortby-icons' and @tooltip='Print']")
	WebElement contactPrint;
	
	@FindBy(xpath="//span[@class='sprite default-sharedown sortby-icons' and @tooltip='Export']")
	WebElement contactExport;

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

	public boolean verifyAdd_Edit_Icon() {
		return EditDeleteIcon.isDisplayed();
	}

	public void verifyAddNewContact(String c_type, String spec, String comp, String fname, String mname, String lname,
			String email, String cell, String C_Street, String C_City, String C_State, String C_Zip, String C_Fax)
			throws Exception {

		Actions act = new Actions(driver);
		act.moveToElement(AddNewIcon).click().build().perform();

		contactType.click();
		enterContactType.sendKeys(c_type);
		contactTypeSelect.click();
		specialty.sendKeys(spec);
		company.sendKeys(comp);
		contactFirstName.sendKeys(fname);
		contactMidName.sendKeys(mname);
		contactLastName.sendKeys(lname);
		emailid.sendKeys(email);
		cellNumber.sendKeys(cell);
		street.sendKeys(C_Street);
		city.sendKeys(C_City);
		State.click();
		enterState.sendKeys(C_State);
		StateFromDropDown.click();
		Zip_Code.sendKeys(C_Zip);
		fax.sendKeys(C_Fax);
		//saveBtn.click();
		//Thread.sleep(10000);
	}

	public void verifyhandleDuplicateContact() {
		Actions act = new Actions(driver);
		act.moveToElement(duplicateYes).click().build().perform();
	}

	public void verifyselectContactByName(String name) {

		/**
		 * Method ONE for select the check of Contact Manager Contacts using loops
		 */

		/*
		 * scrollable-table/div/div[2]/table/tbody/tr[1]/td[2]/span
		 * scrollable-table/div/div[2]/table/tbody/tr[2]/td[2]/span
		 * scrollable-table/div/div[2]/table/tbody/tr[3]/td[2]/span
		 * scrollable-table/div/div[2]/table/tbody/tr[4]/td[2]/span
		 */

		/*
		 * String before_xpath = "//scrollable-table/div/div[2]/table/tbody/tr["; String
		 * after_xpath = "]/td[2]/span";
		 * 
		 * for (int i = 1; i <= 250; i++) { String name =
		 * driver.findElement(By.xpath(before_xpath +i+ after_xpath)).getText();
		 * System.out.println(name); if(name.contains("Bill Campbell")) {
		 * 
		 * driver.findElement(By.xpath("//scrollable-table/div/div[2]/table/tbody/tr["
		 * +i+ "]/td[1]/div/input")).click(); } } Thread.sleep(5000);
		 */

		/**
		 * Method TWO for select the check of Contact Manager Contacts using XPATH
		 */
		driver.findElement(By.xpath("//span[contains(text(), '" + name + "')]"
				+ "/parent::td//preceding-sibling::td//input[@type='checkbox']")).click();
	}

	public void verifyselectAllContactFilter() throws Exception {
		/*
		 * Thread.sleep(5000);
		 * driver.findElement(By.xpath("//label[contains(text(), '"+fiterName+"')]" +
		 * "//parent::div//input[@type='checkbox']")).click();
		 */

		List<WebElement> els = driver.findElements(By.xpath("//div[@class='row']//input[@type='checkbox']"));
		for (WebElement el : els) {
			if (!el.isSelected()) {
				el.click();
			}
		}
		contactFilterApply.click();
	}

	public void verifycontactFilter() {
		Actions act = new Actions(driver);
		act.moveToElement(contactFilterIcon).click().build().perform();
	}

	public void verifyselectRandomContactFilter() {
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='row']//input[@type='checkbox']"));
		Random random = new Random();
		int index = random.nextInt(options.size());
		options.get(index).click();
		contactFilterApply.click();
	}

	public void verifyDeleteLocalContact(String name) {
		driver.findElement(By.xpath("//span[contains(text(), '" + name + "')]"
				+ "/parent::td//preceding-sibling::td//input[@type='checkbox']")).click();
		deleteContact.click();
	}

	public void verifyDeleteGlobalContact(String name) {
		driver.findElement(By.xpath("//span[contains(text(), '" + name + "')]"
				+ "/parent::td//preceding-sibling::td//input[@type='checkbox']")).click();
		deleteContact.click();
	}

	public void handleDeletePopup() {
		DeleteLocalContact.click();
	}
	
	public void verifyContactPrint() {
		contactPrint.click();
	}
	
	public void verifyContactExport() {
		contactExport.click();
	}

}
