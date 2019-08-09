package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import resources.base;

public class RecruitmentPage_Vacancy extends base {
	
	public RecruitmentPage_Vacancy() throws InterruptedException
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//select[@id='vacancySearch_jobVacancy']")
	WebElement SearchVacancy;
	
	@FindBy(xpath="//input[@id='btnSrch']")
	WebElement SearchButton;
	
	@FindBy(xpath="//input[@id='btnAdd']")
	WebElement AddButton;
	
	@FindBy(xpath="//select[@id='addJobVacancy_jobTitle']")
	WebElement JobVacancy_jobTitle;
	
	@FindBy(xpath="//input[@id='addJobVacancy_name']")
	WebElement JobVacancy_name;
	
	@FindBy(xpath="//input[@id='addJobVacancy_hiringManager']")
	WebElement Vacancy_hiringManager;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement btnSave;
	
	
public void ClickAddVacancyBtn() {
	
	AddButton.click();
}

public void ClickOnSaveVacancyBtn() {
	
	btnSave.click();
}

public void SelectJobTitle() {
	
	JobVacancy_jobTitle.click();
	Select sel = new Select(JobVacancy_jobTitle);
	sel.selectByVisibleText("Finance Manager");
}

public void AddVacancyName() {
	
	JobVacancy_name.click();
	JobVacancy_name.sendKeys("Jr. HR Manager");
}
	
public void SelectHiringManager() {
	
	Vacancy_hiringManager.click();
	Vacancy_hiringManager.sendKeys("a");
	Vacancy_hiringManager.sendKeys(Keys.ENTER);
}
	
}


