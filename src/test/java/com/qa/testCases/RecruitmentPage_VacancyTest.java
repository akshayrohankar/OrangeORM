package com.qa.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pageObjects.AdminPage;
import com.qa.pageObjects.LoginPage;
import com.qa.pageObjects.RecruitmentPage;
import com.qa.pageObjects.RecruitmentPage_Vacancy;
import com.qa.resources.base;

public class RecruitmentPage_VacancyTest extends base {

	@BeforeTest
	public void initMe() throws IOException, InterruptedException {
		initializeDriver();
		RecruitmentPage objREcruitmentPage = new RecruitmentPage();
		LoginPage loginPage = new LoginPage();
		loginPage.LoginProcess();
		AdminPage objAdmin = new AdminPage();
		objAdmin.RecruitmentTab.click();
		objREcruitmentPage.vacancy.click();
	}

	@Test(enabled = true)
	public void AddVacancyTest() throws InterruptedException {

		RecruitmentPage_Vacancy objVacancy = new RecruitmentPage_Vacancy();
		objVacancy.ClickAddVacancyBtn();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='addJobVacancy_jobTitle']")));

		objVacancy.SelectJobTitle();
		objVacancy.AddVacancyName();
		objVacancy.SelectHiringManager();
		objVacancy.ClickOnSaveVacancyBtn();

	}
}
