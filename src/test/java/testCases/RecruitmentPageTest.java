package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.base;

public class RecruitmentPageTest extends base {

	@BeforeTest
	public void initMe() throws IOException {

		initializeDriver();
	}

	@Test
	public void testLoginPage() throws InterruptedException {
		LoginPage objLoginPage = new LoginPage(driver, prop);
		objLoginPage.LoginProcess();

	}
	
	
	
	

}
