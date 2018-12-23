package com.clx.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clx.qa.base.TestBase;
import com.clx.qa.pages.Launcher;
import com.clx.qa.pages.LoginPage;

public class LauncherTest extends TestBase {

	LoginPage loginPage;
	Launcher launcher;

	public LauncherTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		launcher = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(20000);
	}

	@Test
	public void verifyLauncherTitleTest() {
		String launcherTitle = launcher.verifyLauncherTitlePage();
		Assert.assertEquals(launcherTitle, "Welcome to CloudLex | CloudLex", "Title Not Match");
	}
	
	@Test
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
