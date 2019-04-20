package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.base;

public class LoginPageTest extends base {

	@BeforeTest
	public void initMe() throws IOException {

		initializeDriver();
	}

	@Test(enabled=false)
	public void testLoginPage() throws InterruptedException {
		LoginPage objLoginPage = new LoginPage(driver);
		objLoginPage.LoginProcess();

	}
	
	@Test(enabled=false)
	public void testValidateSuccessfullLogin() throws InterruptedException {
		LoginPage objLoginPage = new LoginPage(driver);
		objLoginPage.LoginProcess();
		objLoginPage.ValidateSuccessfullLogin();
		String actual = objLoginPage.ValidateSuccessfullLogin();
		assertEquals(actual, prop.getProperty("titlePage"));
	}

	@Test
	public void testValidateUnSuccessfullLogin() throws InterruptedException {
		LoginPage objLoginPage = new LoginPage(driver);
		objLoginPage.LoginProcess();
		objLoginPage.ValidateUnSuccessfullLogin();
		
	}

}
