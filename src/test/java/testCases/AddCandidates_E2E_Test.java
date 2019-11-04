package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AdminPage;
import pageObjects.RecruitmentPage;
import pageObjects.RecruitmentPage_Vacancy;
import resources.Xls_Reader;
import resources.base;

public class AddCandidates_E2E_Test extends base {

	@BeforeTest
	public void initMe() throws IOException, InterruptedException {
		initializeDriver();
		RecruitmentPage objREcruitmentPage = new RecruitmentPage(driver);
		objREcruitmentPage.LoginProcess();
		AdminPage objAdmin = new AdminPage(driver);
		objAdmin.getRecruitmentTab().click();
	}

	@Test(priority = 1)
	public void AddVacancyTest() throws InterruptedException {

		RecruitmentPage objREcruitmentPage = new RecruitmentPage(driver);
		objREcruitmentPage.getVacancyTab().click();
		
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

		AdminPage objAdmin = new AdminPage(driver);
		objAdmin.getRecruitmentTab().click();

		RecruitmentPage objRecruit = new RecruitmentPage(driver);

		Xls_Reader reader = new Xls_Reader("E:\\Udemy_Selenium\\testData.xlsx");

		int countRow = reader.getRowCount("CandidateData");

		for (int i = 2; i < countRow; i++) {

			objRecruit.getAddBtn().click();
			objRecruit.getAddCandidate_firstName().clear();
			objRecruit.getAddCandidate_firstName().sendKeys(reader.getCellData("CandidateData", "First Name", i));
			objRecruit.getAddCandidate_middleName().clear();
			objRecruit.getAddCandidate_middleName().sendKeys(reader.getCellData("CandidateData", "Middle Name", i));
			objRecruit.getAddCandidate_lastName().clear();
			objRecruit.getAddCandidate_lastName().sendKeys(reader.getCellData("CandidateData", "Last Name", i));
			objRecruit.getAddCandidate_email().clear();
			objRecruit.getAddCandidate_email().sendKeys(reader.getCellData("CandidateData", "Email", i));
			objRecruit.getAddCandidate_vacancy().click();
			Select sel = new Select(objRecruit.getAddCandidate_vacancy());
			sel.selectByVisibleText(reader.getCellData("CandidateData", "Job Vacancy", i));
			objRecruit.getAddCandidate_keyWords().clear();
			objRecruit.getAddCandidate_keyWords().sendKeys(reader.getCellData("CandidateData", "Keywords", i));
			objRecruit.getAddCandidate_comment().clear();
			objRecruit.getAddCandidate_comment().sendKeys(reader.getCellData("CandidateData", "Comment", i));
			objRecruit.getAddCandidate_appliedDate().click();
			objRecruit.getselectDate().click();
			objRecruit.getAddCandidate_consentToKeepData().click();
			objRecruit.saveCandidateBtn().click();
			objRecruit.getbackToAddCandidate().click();
		}
	}
}
