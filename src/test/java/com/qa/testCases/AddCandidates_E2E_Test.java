package com.qa.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pageObjects.AdminPage;
import com.qa.pageObjects.LoginPage;
import com.qa.pageObjects.RecruitmentPage;
import com.qa.pageObjects.RecruitmentPage_Vacancy;
import com.qa.resources.base;

public class AddCandidates_E2E_Test extends base {

	@BeforeTest
	public void initMe() throws IOException, InterruptedException {
		initializeDriver();
		LoginPage loginPage = new LoginPage();
		loginPage.LoginProcess();
		AdminPage objAdmin = new AdminPage();
		objAdmin.RecruitmentTab.click();
	}

	@Test(priority = 1)
	public void AddVacancyTest() throws InterruptedException {

		RecruitmentPage objREcruitmentPage = new RecruitmentPage();
		objREcruitmentPage.vacancy.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		RecruitmentPage_Vacancy objVacancy = new RecruitmentPage_Vacancy();
		objVacancy.ClickAddVacancyBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='addJobVacancy_jobTitle']")));
		objVacancy.SelectJobTitle();
		objVacancy.AddVacancyName();
		objVacancy.SelectHiringManager();
		objVacancy.ClickOnSaveVacancyBtn();
		Thread.sleep(2000);
		objVacancy.getRecrTab();

	}

	@Test(priority = 2)
	public void addCandidates() throws InterruptedException, IOException {
		AdminPage objAdmin = new AdminPage();
		objAdmin.RecruitmentTab.click();
		RecruitmentPage objRecruit = new RecruitmentPage();
		objRecruit.addCandidates();
	}
	
	@AfterTest
	public void tearDown() throws IOException, InterruptedException {
		driver.quit();
	}
}
