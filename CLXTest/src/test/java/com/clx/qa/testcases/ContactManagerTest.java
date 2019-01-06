package com.clx.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

	@Test(priority = 1, enabled = false)
	public void verifyContactManagerLogoTest() throws Exception {
		boolean ContactManagerLogo = CM.verifyContactManagerLogo();
		Assert.assertTrue(ContactManagerLogo);
		Thread.sleep(20000);
	}

	@Test(priority = 2, enabled = false)
	public void selectSingleContactbyNameTest() throws Exception {
		CM.verifyselectContactByName("Abby");
		Thread.sleep(4000);
		Boolean AddEditIcon = CM.verifyAdd_Edit_Icon();
		Assert.assertTrue(AddEditIcon);
	}
	
	@Test(priority = 3, enabled = false)
	public void selectMultipleContactbyNameTest() throws Exception {
		CM.verifyselectContactByName("Abby");
		CM.verifyselectContactByName("Aberdeen Township Municipal Court");
		CM.verifyselectContactByName("Abrazo Campus B/R Requests");
		Thread.sleep(4000);
		Boolean AddEditIcon = CM.verifyAdd_Edit_Icon();
		Assert.assertTrue(AddEditIcon);
	}
	
	@DataProvider
	public Object[][] getContactTestData() {
		Object data[][] = TestUtils.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 4, dataProvider = "getContactTestData", enabled = false)
	public void validateAddNewContactTest(String c_type, String spec, String comp, String fname, String mname, String lname,
			String email, String cell, String C_Street, String C_City, String C_State, String C_Zip, String C_Fax) throws Exception {
		CM.verifyAddNewContact(c_type, spec, comp, fname, mname, lname, email, cell, C_Street, C_City, C_State, C_Zip, C_Fax);
		Thread.sleep(5000);
		try {
			CM.verifyhandleDuplicateContact();
			System.out.println("Contact is Duplicate");
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("Contact is not Duplicate");
		}
	}
	
	@Test(priority = 5, enabled = false)
	public void deleteLocalContactTest() throws Exception {
		try {
			CM.verifyDeleteLocalContact("A. Paul Heeringa");
			CM.handleDeletePopup();
			Thread.sleep(3500);
			String Expected_Delete_Msg = driver.findElement(By.xpath("//div[@class='ng-binding' and contains(text(),"
					+ " 'Contact(s) deleted successfully')]")).getText();
			Assert.assertEquals(Expected_Delete_Msg, "Contact(s) deleted successfully");
			Thread.sleep(10000);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Contact Not available for delete");
		}
	}
	
	@Test(priority = 6, enabled = false)
	public void deleteGlobalContactTest() throws Exception {
		try {
			CM.verifyDeleteGlobalContact("Aberdeen Township Municipal Court");
			Thread.sleep(5000);
			String Expected_GLobalContactDeleteMsg = driver.findElement(By.xpath("//p[@class='ng-binding' and "
					+ "contains(text(), 'You are not allowed to delete global Contact(s).')]")).getText();
			Assert.assertEquals(Expected_GLobalContactDeleteMsg, "You are not allowed to delete global Contact(s).");
			Thread.sleep(10000);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Contact Not available for delete");
		}
	}
	
	@Test(priority = 7, enabled = false)
	public void SelectAllContactTypeFilterTest() throws Exception {
		CM.verifycontactFilter();
		CM.verifyselectAllContactFilter();
		Thread.sleep(10000);
		assertTrue(driver.findElement(By.xpath("//ul[@class='tags']")).isDisplayed());
	}
	
	@Test(priority = 8, enabled = false)
	public void randomContactTypeFilterTest() throws Exception {
		CM.verifycontactFilter();
		CM.verifyselectRandomContactFilter();
		Thread.sleep(10000);
		assertTrue(driver.findElement(By.xpath("//ul[@class='tags']")).isDisplayed());
	}
	
	@Test(priority = 9, enabled = true)
	public void contactPrintTest() {
		CM.verifyContactPrint();
		driver.switchTo().window("Contacts");
		String Actual_Print = driver.findElement(By.xpath("//h1[contains(text(), 'Contact')]")).getText();
		Assert.assertEquals(Actual_Print, "Contact");
	}
	
	@Test(priority = 10, enabled = true)
	public void contactExportTest() {
		CM.verifyContactExport();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
