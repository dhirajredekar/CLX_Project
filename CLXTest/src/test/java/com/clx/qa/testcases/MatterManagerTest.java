package com.clx.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clx.qa.base.TestBase;
import com.clx.qa.pages.Launcher;
import com.clx.qa.pages.LoginPage;
import com.clx.qa.pages.MatterManager;

public class MatterManagerTest extends TestBase{
	
	LoginPage loginPage;
	Launcher launcher;
	MatterManager MM;
	
	public MatterManagerTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		MM = new MatterManager();
		launcher = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(20000);
		MM = launcher.clickOnMatterManager();
	}
	
	@Test
	public void verifyMatterManagerTest() {
		assertTrue(MM.validateMatterManagerLogo());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
