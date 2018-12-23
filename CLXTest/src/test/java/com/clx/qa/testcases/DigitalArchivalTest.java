package com.clx.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clx.qa.base.TestBase;
import com.clx.qa.pages.DigitalArchival;
import com.clx.qa.pages.Launcher;
import com.clx.qa.pages.LoginPage;

public class DigitalArchivalTest extends TestBase {

	LoginPage loginPage;
	Launcher launcher;
	DigitalArchival DA;

	public DigitalArchivalTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		DA = new DigitalArchival();
		launcher = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(20000);
		DA = launcher.clickonDigitalArchival();
	}

	@Test
	public void verifyDigitalArchivalTest() {
		assertTrue(DA.validateDigitalArchivalLogo());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
