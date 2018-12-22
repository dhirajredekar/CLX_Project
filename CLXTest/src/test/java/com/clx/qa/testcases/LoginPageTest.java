package com.clx.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clx.qa.base.TestBase;
import com.clx.qa.pages.Launcher;
import com.clx.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	Launcher launcher;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		
	}

	@Test(priority=1)
	public void loginPageTitleTest() throws Exception {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Welcome to CloudLex | CloudLex");
		Thread.sleep(10000);
	}
	
	@Test(priority=2)
	public void clxLogoTest() throws Exception {
		boolean flag = loginPage.validateCloudlexLogo();
		Assert.assertTrue(flag);
		Thread.sleep(10000);
	}
	
	@Test(priority=3)
	public void loginTest() throws Exception {
		launcher = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(10000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
