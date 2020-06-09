package com.qa.testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pageObjects.AdminPage;
import com.qa.pageObjects.LoginPage;
import com.qa.pageObjects.RecruitmentPage;
import com.qa.resources.base;

public class RecruitmentPageTest extends base {

	@BeforeTest
	public void initMe() throws IOException {
		initializeDriver();
	}

	@Test(enabled = true)
	public void searchCandidates() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage();
		loginPage.LoginProcess();
		AdminPage objAdmin = new AdminPage();
		objAdmin.RecruitmentTab.click();
		RecruitmentPage objRecruit = new RecruitmentPage();
		objRecruit.searchCandidates();
	}

	@Test(enabled = false)
	public void addCandidates() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage();
		loginPage.LoginProcess();
		AdminPage objAdmin = new AdminPage();
		objAdmin.RecruitmentTab.click();
		RecruitmentPage objRecruit = new RecruitmentPage();
		objRecruit.addCandidates();
	}

	@AfterTest
	public void tearDown() throws IOException {
		driver.quit();
	}
}
