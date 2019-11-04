package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AdminPage;
import pageObjects.RecruitmentPage;
import pageObjects.RecruitmentPage_Vacancy;
import resources.base;

public class RecruitmentPage_VacancyTest extends base {

	@BeforeTest
	public void initMe() throws IOException, InterruptedException {

		initializeDriver();
		RecruitmentPage objREcruitmentPage = new RecruitmentPage(driver);
		objREcruitmentPage.LoginProcess();

		AdminPage objAdmin = new AdminPage(driver);
		objAdmin.getRecruitmentTab().click();
		
		objREcruitmentPage.getVacancyTab().click();
	}

	@Test(enabled = true)
	public void AddVacancyTest() throws InterruptedException {

		RecruitmentPage_Vacancy objVacancy = new RecruitmentPage_Vacancy();
		objVacancy.ClickAddVacancyBtn();
		
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement element = wait.until( ExpectedConditions.
				  visibilityOfElementLocated(By.xpath("//select[@id='addJobVacancy_jobTitle']")));
		
		objVacancy.SelectJobTitle();
		objVacancy.AddVacancyName();
		objVacancy.SelectHiringManager();
		objVacancy.ClickOnSaveVacancyBtn();

	}
}
