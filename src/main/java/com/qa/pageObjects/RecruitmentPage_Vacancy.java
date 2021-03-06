package com.qa.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.resources.base;

public class RecruitmentPage_Vacancy extends base {
	static int id = 001;

	public RecruitmentPage_Vacancy() throws InterruptedException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='vacancySearch_jobVacancy']")
	WebElement SearchVacancy;

	@FindBy(xpath = "//input[@id='btnSrch']")
	WebElement SearchButton;

	@FindBy(xpath = "//input[@id='btnAdd']")
	WebElement AddButton;

	@FindBy(xpath = "//select[@id='addJobVacancy_jobTitle']")
	WebElement JobVacancy_jobTitle;

	@FindBy(xpath = "//input[@id='addJobVacancy_name']")
	WebElement JobVacancy_name;

	@FindBy(xpath = "//input[@id='addJobVacancy_hiringManager']")
	WebElement Vacancy_hiringManager;

	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement btnSave;

	@FindBy(xpath = "//span[@class='validation-error']")
	WebElement validationError;

	@FindBy(xpath = "//a[@id='menu_recruitment_viewCandidates']")
	WebElement getBackToRecrTab;

	public void getRecrTab() {

		getBackToRecrTab.click();
	}

	public void ClickAddVacancyBtn() {

		AddButton.click();
	}

	public void ClickOnSaveVacancyBtn() {

		btnSave.click();
		if (validationError.isDisplayed()) {
			id++;
			JobVacancy_name.clear();
			JobVacancy_name.sendKeys("Level-" + id + "-Jr. HR Manager");
			btnSave.click();
		}
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
		Vacancy_hiringManager.sendKeys("Linda Anderson");
		Vacancy_hiringManager.sendKeys(Keys.ENTER);
	}

}
