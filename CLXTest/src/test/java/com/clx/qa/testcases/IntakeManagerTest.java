package com.clx.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clx.qa.base.TestBase;
import com.clx.qa.pages.IntakeManager;
import com.clx.qa.pages.Launcher;
import com.clx.qa.pages.LoginPage;

public class IntakeManagerTest extends TestBase{
	
	LoginPage loginPage;
	Launcher launcher;
	IntakeManager IM;
	
	public IntakeManagerTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		IM = new IntakeManager();
		launcher = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(20000);
		IM = launcher.clickOnIntakeManager();
	}
	
	@Test
	public void verifyIntakeManagerTest() {
		assertTrue(IM.validateIntakeManagerLogo());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
