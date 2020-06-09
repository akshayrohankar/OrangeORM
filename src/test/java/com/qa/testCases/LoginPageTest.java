package com.qa.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageObjects.LoginPage;
import com.qa.resources.base;

public class LoginPageTest extends base {

	@BeforeMethod
	public void initMe() throws IOException {
		initializeDriver();
	}

	@Test(enabled=true)
	public void testLoginPage() throws InterruptedException {
		LoginPage objLoginPage = new LoginPage();
		objLoginPage.LoginProcess();
	}
	
	@Test(enabled=true)
	public void testValidateSuccessfullLogin() throws InterruptedException {
		LoginPage objLoginPage = new LoginPage();
		objLoginPage.LoginProcess();
		String actual = objLoginPage.ValidateSuccessfullLogin();
		assertEquals(actual, prop.getProperty("titlePage"));
	}

	@Test(enabled=true)
	public void testValidateUnSuccessfullLogin() throws InterruptedException {
		LoginPage objLoginPage = new LoginPage();
		objLoginPage.LoginProcess();
		objLoginPage.ValidateUnSuccessfullLogin();
	}
	
	@BeforeMethod
	public void tearDown() throws IOException {
		driver.quit();
	}

}
