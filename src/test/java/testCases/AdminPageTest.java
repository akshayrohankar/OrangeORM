package testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AdminPage;
import pageObjects.LoginPage;
import resources.base;

public class AdminPageTest extends base {
	@BeforeTest
	public void initMe() throws IOException, InterruptedException {

		initializeDriver();
		LoginPage objLoginPage = new LoginPage(driver, prop);
		objLoginPage.LoginProcess();
		
	}

	@Test
	public void testAddUserAdminPage() throws InterruptedException {
		AdminPage objAdminPage = new AdminPage(driver, prop);
		objAdminPage.addUser();
		
	}
	
	
	@AfterTest
	public void closeMe() throws IOException, InterruptedException {

		Thread.sleep(10000);
		driver.close();
	}

}
