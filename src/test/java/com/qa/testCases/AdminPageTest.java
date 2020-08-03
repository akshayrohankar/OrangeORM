package com.qa.testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pageObjects.AdminPage;
import com.qa.pageObjects.LoginPage;
import com.qa.resources.base;

public class AdminPageTest extends base {
	@BeforeTest
	public void initMe() throws IOException, InterruptedException {
		initializeDriver();
		LoginPage objLoginPage = new LoginPage();
		objLoginPage.LoginProcess();
	}

	@Test
	public void testAddUserAdminPage() throws InterruptedException {
		AdminPage objAdminPage = new AdminPage();
		
		objAdminPage.addUser();
		Thread.sleep(5000);
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
