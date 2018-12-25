package com.clx.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clx.qa.base.TestBase;
import com.clx.qa.pages.ContactManager;
import com.clx.qa.pages.DigitalArchival;
import com.clx.qa.pages.IntakeManager;
import com.clx.qa.pages.LauchPadSearch;
import com.clx.qa.pages.LaunchPadNotes;
import com.clx.qa.pages.Launcher;
import com.clx.qa.pages.LoginPage;
import com.clx.qa.pages.Marketplace;
import com.clx.qa.pages.MatterManager;
import com.clx.qa.pages.ReferralEngine;
import com.clx.qa.pages.UniversalCalendar;

public class LauncherTest extends TestBase {

	LoginPage loginPage;
	Launcher launcher;
	MatterManager MM;
	IntakeManager IM;
	DigitalArchival DA;
	ReferralEngine RE;
	ContactManager CM;
	Marketplace MP;
	LauchPadSearch LPS;
	UniversalCalendar UC;
	LaunchPadNotes LPN;

	public LauncherTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		MM = new MatterManager();
		launcher = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(20000);
	}

	/*
	 * @Test(priority=1) public void verifyLauncherTitleTest() { String
	 * launcherTitle = launcher.verifyLauncherTitlePage();
	 * Assert.assertEquals(launcherTitle, "Welcome to CloudLex | CloudLex",
	 * "Title Not Match"); }
	 * 
	 * @Test(priority=2) public void verifyUserNameTest() {
	 * Assert.assertTrue(launcher.correctUserName()); }
	 * 
	 * @Test(priority=3) public void verifyMatterManagerLinkTest() throws Exception
	 * { launcher.clickOnMatterManager(); MM = launcher.clickOnMatterManager();
	 * Thread.sleep(20000); }
	 * 
	 * @Test(priority=4) public void verifyIntakeManagerLinkTest() throws Exception
	 * { launcher.clickOnIntakeManager(); IM = launcher.clickOnIntakeManager();
	 * Thread.sleep(20000); }
	 * 
	 * @Test(priority=5) public void verifyDigitalArchivalLinkTest() throws
	 * Exception { launcher.clickonDigitalArchival(); DA =
	 * launcher.clickonDigitalArchival(); Thread.sleep(20000); }
	 * 
	 * @Test(priority=6) public void verifyReferralEngineLinkTest() throws Exception
	 * { launcher.clickonReferralEngine(); RE = launcher.clickonReferralEngine();
	 * Thread.sleep(20000); }
	 * 
	 * @Test(priority=7) public void verifyContactManagerLinkTest() throws Exception
	 * { launcher.clickonContactManager(); CM = launcher.clickonContactManager();
	 * Thread.sleep(20000); }
	 * 
	 * @Test(priority=8) public void verifyMarketplaceLinkTest() throws Exception {
	 * launcher.clickonMarketplace(); MP = launcher.clickonMarketplace();
	 * Thread.sleep(20000); }
	 */
	
	@Test(priority=9)
	public void verifyLauchPadSearchTest() throws Exception {
		launcher.clickonLauchPadSearch();
		launcher.clickonLauchPadSearch();
		LPS = launcher.clickonLauchPadSearch();
		Thread.sleep(20000);
	}
	
	@Test(priority=10)
	public void verifyUniversalCalendarTest() throws Exception {
		launcher.clickonUniversalCalendar();
		launcher.clickonUniversalCalendar();
		UC = launcher.clickonUniversalCalendar();
		Thread.sleep(20000);
	}
	
	@Test(priority=11)
	public void verifyLauchPadNotesTest() throws Exception {
		launcher.clickonLauchPadNotes();
		launcher.clickonLauchPadNotes();
		LPN = launcher.clickonLauchPadNotes();
		Thread.sleep(20000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
