package com.qa.testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pageObjects.LoginPage;
import com.qa.resources.base;

public class LoginPageWindowHandlerTest extends base {

	@BeforeTest
	public void initMe() throws IOException {
		initializeDriver();
	}

	@Test
	public void HandlerLoginPage() throws InterruptedException {

		LoginPage objLoginPage = new LoginPage();
		objLoginPage.LoginProcess();
		LoginPage loginPage = new LoginPage();
		loginPage.VerifyWindowsHandlerFunctionality();
	}

	@AfterTest
	public void closeMe() throws IOException {
		driver.quit();
	}

}
