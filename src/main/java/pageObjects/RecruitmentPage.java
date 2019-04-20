package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class RecruitmentPage extends base {

	public RecruitmentPage(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
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
	By searchBtn = By.id("btnSrch");
	By resetBtn = By.id("btnRst");
	By addBtn = By.id("btnAdd");
	By deleteBtn = By.id("btnDelete");
	
	By username = By.id("txtUsername");
	By password = By.id("txtPassword");
	By loginbtn = By.id("btnLogin");


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