package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AdminPage;
import pageObjects.RecruitmentPage;
import resources.base;

public class RecruitmentPageTest extends base {

	@BeforeTest
	public void initMe() throws IOException {

		initializeDriver();
	}
	
	@Test
	public void addCandidates() throws InterruptedException {
		RecruitmentPage objREcruitmentPage = new RecruitmentPage(driver);
		objREcruitmentPage.LoginProcess();
		
		AdminPage objAdmin = new AdminPage(driver);
		objAdmin.getRecruitmentTab().click();
		
		RecruitmentPage objRecruit = new RecruitmentPage(driver);
		
		
	}
	

}
