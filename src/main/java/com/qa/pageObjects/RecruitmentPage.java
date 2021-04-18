package com.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.resources.Xls_Reader;
import com.qa.resources.base;

public class RecruitmentPage extends base {

	public RecruitmentPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "candidateSearch_jobTitle")
	public WebElement jobTitle;
	@FindBy(id = "candidateSearch_jobVacancy")
	public WebElement vacancy;
	@FindBy(id = "candidateSearch_hiringManager")
	public WebElement hiringManager;
	@FindBy(id = "candidateSearch_status")
	public WebElement status;
	@FindBy(id = "candidateSearch_candidateName")
	public WebElement candidateName;
	@FindBy(id = "candidate1Search_keywords")
	public WebElement keywords;
	@FindBy(id = "candidateSearch_fromDate")
	public WebElement fromDate;
	@FindBy(id = "candidateSearch_toDate")
	public WebElement toDate;
	@FindBy(id = "candidateSearch_modeOfApplication")
	public WebElement methodAppl;
	@FindBy(id = "btnSrch")
	public WebElement searchBtn;
	@FindBy(id = "btnRst")
	public WebElement resetBtn;
	@FindBy(id = "btnAdd")
	public WebElement addBtn;
	@FindBy(id = "btnDelete")
	public WebElement deleteBtn;

	@FindBy(id = "txtUsername")
	public WebElement username;
	@FindBy(id = "txtPassword")
	public WebElement password;
	@FindBy(id = "btnLogin")
	public WebElement loginbtn;

	@FindBy(id = "btnAdd")
	public WebElement addCandidate;
	@FindBy(id = "btnDelete")
	public WebElement deleteCandidate;
	@FindBy(id = "addCandidate_firstName")
	public WebElement addCandidate_firstName;
	@FindBy(id = "addCandidate_middleName")
	public WebElement addCandidate_middleName;
	@FindBy(id = "addCandidate_lastName")
	public WebElement addCandidate_lastName;
	@FindBy(id = "addCandidate_email")
	public WebElement addCandidate_email;
	@FindBy(id = "addCandidate_contactNo")
	public WebElement addCandidate_contactNo;
	@FindBy(id = "addCandidate_vacancy")
	public WebElement addCandidate_vacancy;
	@FindBy(id = "addCandidate_keyWords")
	public WebElement addCandidate_keyWords;
	@FindBy(id = "addCandidate_comment")
	public WebElement addCandidate_comment;
	@FindBy(id = "addCandidate_appliedDate")
	public WebElement addCandidate_appliedDate;
	@FindBy(id = "addCandidate_consentToKeepData")
	public WebElement addCandidate_consentToKeepData;
	@FindBy(id = "btnSave")
	public WebElement saveCandidateBtn;
	@FindBy(id = "btnBack")
	public WebElement backToAddCandidate;
	@FindBy(xpath = "//a[@id='menu_recruitment_viewJobVacancy']")
	public WebElement getVacancyTab;
	@FindBy(xpath = "//tr[2]//td[1]//a[1]")
	public WebElement selectDate;
	@FindBy(xpath = "//span[@id='spanMessage']")
	public WebElement invalidLoginMsg;

	public void addCandidates() throws InterruptedException {
		Xls_Reader reader = new Xls_Reader(".\\src\\main\\java\\com\\qa\\resources\\testData.xlsx");
		int countRow = reader.getRowCount("CandidateData");
		for (int i = 2; i <= countRow; i++) {
			addBtn.click();
			addCandidate_firstName.clear();
			addCandidate_firstName.sendKeys(reader.getCellData("CandidateData", "First Name", i));
			addCandidate_middleName.clear();
			addCandidate_middleName.sendKeys(reader.getCellData("CandidateData", "Middle Name", i));
			addCandidate_lastName.clear();
			addCandidate_lastName.sendKeys(reader.getCellData("CandidateData", "Last Name", i));
			addCandidate_email.clear();
			addCandidate_email.sendKeys(reader.getCellData("CandidateData", "Email", i));
			addCandidate_vacancy.click();
			Select sel = new Select(addCandidate_vacancy);
			sel.selectByVisibleText(reader.getCellData("CandidateData", "Job Vacancy", i));
			addCandidate_keyWords.clear();
			addCandidate_keyWords.sendKeys(reader.getCellData("CandidateData", "Keywords", i));
			addCandidate_comment.clear();
			addCandidate_comment.sendKeys(reader.getCellData("CandidateData", "Comment", i));
			addCandidate_appliedDate.click();
			selectDate.click();
			addCandidate_consentToKeepData.click();
			Thread.sleep(2000);
			saveCandidateBtn.click();
			Thread.sleep(2000);
			backToAddCandidate.click();
			Thread.sleep(4000);
		}
	}

	public void searchCandidates() {

		Xls_Reader reader = new Xls_Reader(".\\src\\main\\java\\com\\qa\\resources\\testData-Search.xlsx");
		// int count = reader.getRowCount("testdata");
		jobTitle.click();
		Select sel = new Select(jobTitle);
		sel.selectByVisibleText(reader.getCellData("CandidateData", "Job Title", 2));
		vacancy.click();
		Select sel1 = new Select(vacancy);
		sel1.selectByVisibleText(reader.getCellData("CandidateData", "Vacancy", 2));
		hiringManager.click();
		Select sel2 = new Select(hiringManager);
		sel2.selectByVisibleText(reader.getCellData("CandidateData", "Hiring Manager", 2));
		status.click();
		Select sel3 = new Select(status);
		sel3.selectByVisibleText(reader.getCellData("CandidateData", "Status", 2));
		candidateName.clear();
		candidateName.sendKeys(reader.getCellData("CandidateData", "Candidate Name", 2));
		candidateName.sendKeys(Keys.ENTER);
		keywords= driver.findElement(By.xpath("//input[@id='candidateSearch_keywords']"));
		keywords.clear();
		keywords.sendKeys(reader.getCellData("CandidateData", "Keywords", 2));
		fromDate.clear();
		fromDate.sendKeys(reader.getCellData("CandidateData", "Date of Application", 2));
		toDate.clear();
		toDate.sendKeys(reader.getCellData("CandidateData", "To", 2));
		methodAppl.click();
		Select sel4 = new Select(methodAppl);
		sel4.selectByVisibleText(reader.getCellData("CandidateData", "Method of Application", 2));
		searchBtn.click();
	}
}