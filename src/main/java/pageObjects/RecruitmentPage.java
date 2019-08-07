package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class RecruitmentPage extends base {

	public RecruitmentPage(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;
	
	By jobTitle = By.id("candidateSearch_jobTitle");
	By vacancy = By.id("candidateSearch_jobVacancy");
	By hiringManager = By.id("candidateSearch_hiringManager");
	By status = By.id("candidateSearch_status");
	By candidateName = By.id("candidateSearch_candidateName");
	By keywords = By.id("candidateSearch_keywords");
	By fromDate = By.id("candidateSearch_fromDate");
	By toDate = By.id("candidateSearch_toDate");
	By methodAppl = By.id("candidateSearch_modeOfApplication");
	By searchBtn = By.id("btnSrch");
	By resetBtn = By.id("btnRst");
	By addBtn = By.id("btnAdd");
	By deleteBtn = By.id("btnDelete");
	
	By username = By.id("txtUsername");
	By password = By.id("txtPassword");
	By loginbtn = By.id("btnLogin");

	
	By addCandidate = By.id("btnAdd");
	By deleteCandidate = By.id("btnDelete");
	By addCandidate_firstName = By.id("addCandidate_firstName");
	By addCandidate_middleName = By.id("addCandidate_middleName");
	By addCandidate_lastName = By.id("addCandidate_lastName");
	By addCandidate_email = By.id("addCandidate_email");
	By addCandidate_contactNo = By.id("addCandidate_contactNo");
	By addCandidate_vacancy = By.id("addCandidate_vacancy");
	By addCandidate_keyWords = By.id("addCandidate_keyWords");
	By addCandidate_comment = By.id("addCandidate_comment");
	By addCandidate_appliedDate = By.id("addCandidate_appliedDate");
	By addCandidate_consentToKeepData = By.id("addCandidate_consentToKeepData");
	By saveCandidateBtn = By.id("btnSave");
	By backToAddCandidate = By.id("btnBack");
	
	By selectDate = By.xpath("//tr[2]//td[1]//a[1]");
	
	public WebElement getselectDate() {
		return driver.findElement(selectDate);
	}
	
	public WebElement getbackToAddCandidate() {
		return driver.findElement(backToAddCandidate);
	}

	public WebElement getUsername() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLoginbtn() {
		return driver.findElement(loginbtn);
	}
	
	
	

	public WebElement getJobTitle() {
		return driver.findElement(jobTitle);
	}

	public WebElement getVacancy() {
		return driver.findElement(vacancy);
	}

	public WebElement getHiringManager() {
		return driver.findElement(hiringManager);
	}

	public WebElement getStatus() {
		return driver.findElement(status);
	}

	public WebElement getCandidateName() {
		return driver.findElement(candidateName);
	}

	public WebElement getKeywords() {
		return driver.findElement(keywords);
	}

	public WebElement getFromDate() {
		return driver.findElement(fromDate);
	}

	public WebElement getToDate() {
		return driver.findElement(toDate);
	}

	public WebElement getMethodAppl() {
		return driver.findElement(methodAppl);
	}
	
	public WebElement getSearchBtn() {
		return driver.findElement(searchBtn);
	}

	public WebElement getResetBtn() {
		return driver.findElement(resetBtn);
	}

	public WebElement getAddBtn() {
		return driver.findElement(addBtn);
	}

	public WebElement getDeleteBtn() {
		return driver.findElement(deleteBtn);
	}


	public WebElement getAddCandidate() {
		return driver.findElement(addCandidate);
	}

	public WebElement getDeleteCandidate() {
		return driver.findElement(deleteCandidate);
	}

	public WebElement getAddCandidate_firstName() {
		return driver.findElement(addCandidate_firstName);
	}

	public WebElement getAddCandidate_middleName() {
		return driver.findElement(addCandidate_middleName);
	}

	public WebElement getAddCandidate_lastName() {
		return driver.findElement(addCandidate_lastName);
	}

	public WebElement getAddCandidate_email() {
		return driver.findElement(addCandidate_email);
	}

	public WebElement getAddCandidate_contactNo() {
		return driver.findElement(addCandidate_contactNo);
	}

	public WebElement getAddCandidate_vacancy() {
		return driver.findElement(addCandidate_vacancy);
	}

	public WebElement getAddCandidate_keyWords() {
		return driver.findElement(addCandidate_keyWords);
	}

	public WebElement getAddCandidate_comment() {
		return driver.findElement(addCandidate_comment);
	}

	public WebElement getAddCandidate_appliedDate() {
		return driver.findElement(addCandidate_appliedDate);
	}

	public WebElement getAddCandidate_consentToKeepData() {
		return driver.findElement(addCandidate_consentToKeepData);
	}

	public WebElement saveCandidateBtn() {
		return driver.findElement(saveCandidateBtn);
	}

	public void LoginProcess() throws InterruptedException {

		getUsername().sendKeys(prop.getProperty("username"));
		getPassword().sendKeys(prop.getProperty("password"));
		getLoginbtn().click();
		Thread.sleep(10000);

	}

	public String ValidateSuccessfullLogin() {
		String actualPageTitle = driver.getTitle();
		System.out.println(actualPageTitle);
		return actualPageTitle;

	}

	public void ValidateUnSuccessfullLogin() {
		try {
		if(!driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed())
		{
			System.out.println("Valid credentials");
		}
		else
		{
		System.out.println("Invalid Login");
		}
		}
		catch(NoSuchElementException el) {
			System.out.println("Caught Exception Valid Credentials");
		}
	}

}