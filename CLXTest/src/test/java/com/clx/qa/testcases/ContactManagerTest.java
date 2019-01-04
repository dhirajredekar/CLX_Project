package com.clx.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.clx.qa.base.TestBase;
import com.clx.qa.pages.ContactManager;
import com.clx.qa.pages.Launcher;
import com.clx.qa.pages.LoginPage;
import com.clx.qa.utils.TestUtils;

public class ContactManagerTest extends TestBase {

	LoginPage loginPage;
	Launcher launcher;
	ContactManager CM;
	TestUtils testUtil;

	String sheetName = "contacts";

	public ContactManagerTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		CM = new ContactManager();
		launcher = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(20000);
		CM = launcher.clickonContactManager();
		Thread.sleep(20000);
	}

	@Test(priority = 1)
	public void verifyContactManagerLogoTest() throws Exception {
		boolean ContactManagerLogo = CM.verifyContactManagerLogo();
		Assert.assertTrue(ContactManagerLogo);
		Thread.sleep(20000);
	}

	@DataProvider
	public Object[][] getContactTestData() {
		Object data[][] = TestUtils.getTestData(sheetName);
		return data;
	}

	@Test(priority = 2, dataProvider="getContactTestData")
	public void validateAddNewContactTest(String spec, String comp, String fname, String mname, String lname, String email,
			String cell) throws Exception {
		
		//CM.validateAddNewContact("Automation", "Company", "Robert", "Ned Eddard", "Stark", "test@yopmail.com","9876543456");
		
		
		CM.validateAddNewContact(spec, comp, fname, mname, lname, email, cell);
		Thread.sleep(5000);
		try {
			CM.handleDuplicateContact();
			System.out.println("Contact is Duplicate");
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("Contact is not Duplicate");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
