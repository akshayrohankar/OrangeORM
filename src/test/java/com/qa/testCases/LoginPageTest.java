package com.qa.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pageObjects.LoginPage;
import com.qa.resources.base;

public class LoginPageTest extends base {
	static LoginPage objLoginPage;

	@BeforeTest
	public void initMe() throws IOException, InterruptedException {
		initializeDriver();
		objLoginPage = new LoginPage();
		objLoginPage.LoginProcess();
	}

	
	@Test(enabled=true)
	public void testValidateSuccessfullLogin() throws InterruptedException {
		String actual = objLoginPage.ValidateSuccessfullLogin();
		assertEquals(actual, prop.getProperty("titlePage"));
	}

	@Test(enabled=true)
	public void testValidateUnSuccessfullLogin() throws InterruptedException {
		objLoginPage.ValidateUnSuccessfullLogin();
	}
	

	public void NewAdded() throws InterruptedException {
		//Demo
	}
	
	@AfterTest
	public void tearDown() throws IOException {
		driver.quit();
	}

}
