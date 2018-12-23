package com.clx.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clx.qa.base.TestBase;
import com.clx.qa.pages.Launcher;
import com.clx.qa.pages.LoginPage;
import com.clx.qa.pages.ReferralEngine;

public class ReferralEngineTest extends TestBase{
	
	LoginPage loginPage;
	Launcher launcher;
	ReferralEngine RE;
	
	public ReferralEngineTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		RE = new ReferralEngine();
		launcher = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(20000);
		RE = launcher.clickonReferralEngine();
	}
	
	@Test
	public void verifyReferralEngineTest() {
		assertTrue(RE.validateReferralEngineLogo());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
