package testCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AdminPage;
import pageObjects.RecruitmentPage;
import resources.Xls_Reader;
import resources.base;

public class RecruitmentPageTest extends base {

	@BeforeTest
	public void initMe() throws IOException {

		initializeDriver();
	}

	@Test(enabled=false)
	public void searchCandidates() throws InterruptedException, IOException {
		RecruitmentPage objREcruitmentPage = new RecruitmentPage(driver);
		objREcruitmentPage.LoginProcess();

		AdminPage objAdmin = new AdminPage(driver);
		objAdmin.getRecruitmentTab().click();

		RecruitmentPage objRecruit = new RecruitmentPage(driver);

		Xls_Reader reader = new Xls_Reader("E:\\Udemy_Selenium\\testData.xlsx");

		int count = reader.getRowCount("testdata");

		objRecruit.getJobTitle().click();
		Select sel = new Select(objRecruit.getJobTitle());
		sel.selectByVisibleText(reader.getCellData("testdata", "Job Title", 2));
		
		objRecruit.getVacancy().click();
		Select sel1 = new Select(objRecruit.getVacancy());
		sel1.selectByVisibleText(reader.getCellData("testdata", "Vacancy", 2)); 
		
		objRecruit.getHiringManager().click();
		Select sel2 = new Select(objRecruit.getHiringManager());
		sel2.selectByVisibleText(reader.getCellData("testdata", "Hiring Manager", 2));
		
		objRecruit.getStatus().click();
		Select sel3 = new Select(objRecruit.getStatus());
		sel3.selectByVisibleText(reader.getCellData("testdata", "Status", 2));
			
			
		objRecruit.getCandidateName().clear();
		objRecruit.getCandidateName().sendKeys(reader.getCellData("testdata", "Candidate Name", 2));
			
		objRecruit.getKeywords().clear();
		objRecruit.getKeywords().sendKeys(reader.getCellData("testdata", "Keywords", 2));	
			
		
		objRecruit.getFromDate().clear();
		objRecruit.getFromDate().sendKeys(reader.getCellData("testdata", "Date of Application", 2));
		
		objRecruit.getToDate().clear();
		objRecruit.getToDate().sendKeys(reader.getCellData("testdata", "To", 2));
			
			
		objRecruit.getMethodAppl().click();
		Select sel4 = new Select(objRecruit.getMethodAppl());
		sel4.selectByVisibleText(reader.getCellData("testdata", "Method of Application", 2));
		

		objRecruit.getSearchBtn().click();	
	}
	
	
	@Test
	public void addCandidates() throws InterruptedException, IOException {
		RecruitmentPage objREcruitmentPage = new RecruitmentPage(driver);
		objREcruitmentPage.LoginProcess();

		AdminPage objAdmin = new AdminPage(driver);
		objAdmin.getRecruitmentTab().click();

		RecruitmentPage objRecruit = new RecruitmentPage(driver);

		Xls_Reader reader = new Xls_Reader("E:\\Udemy_Selenium\\testData.xlsx");

		int countRow = reader.getRowCount("CandidateData");
		objRecruit.getAddBtn().click();

		
		objRecruit.getAddCandidate_firstName().clear();
		objRecruit.getAddCandidate_firstName().sendKeys(reader.getCellData("CandidateData", "First Name", 2));
		objRecruit.getAddCandidate_middleName().clear();
		objRecruit.getAddCandidate_middleName().sendKeys(reader.getCellData("CandidateData", "Middle Name", 2));
		objRecruit.getAddCandidate_lastName().clear();
		objRecruit.getAddCandidate_lastName().sendKeys(reader.getCellData("CandidateData", "Last Name", 2));
		objRecruit.getAddCandidate_email().clear();
		objRecruit.getAddCandidate_email().sendKeys(reader.getCellData("CandidateData", "Email", 2));
		objRecruit.getAddCandidate_vacancy().click();
		Select sel = new Select(objRecruit.getAddCandidate_vacancy());
		sel.selectByVisibleText(reader.getCellData("CandidateData", "Job Vacancy", 2));
		objRecruit.getAddCandidate_keyWords().clear();
		objRecruit.getAddCandidate_keyWords().sendKeys(reader.getCellData("CandidateData", "Keywords", 2));
		objRecruit.getAddCandidate_comment().clear();
		objRecruit.getAddCandidate_comment().sendKeys(reader.getCellData("CandidateData", "Comment", 2));
		objRecruit.getAddCandidate_appliedDate().click();
		objRecruit.getAddCandidate_appliedDate().sendKeys(reader.getCellData("CandidateData", "Date of Application", 2));
		objRecruit.getAddCandidate_consentToKeepData().click();
		objRecruit.getBtnSave().click();
			
			

	}
}
