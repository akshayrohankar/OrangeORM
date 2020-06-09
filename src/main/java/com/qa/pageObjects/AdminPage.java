package com.qa.pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.resources.base;

public class AdminPage extends base {

	public AdminPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//b[contains(text(),'Admin')]")
	public WebElement adminTab;

	@FindBy(xpath = "//b[contains(text(),'Recruitment')]")
	public WebElement RecruitmentTab;

	@FindBy(xpath = "//input[@id='btnAdd']")
	public WebElement addBtn;

	@FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
	public WebElement empName;

	@FindBy(xpath = "//input[@id='systemUser_userName']")
	public WebElement userName;

	@FindBy(xpath = "//input[@id='systemUser_password']")
	public WebElement passWord;

	@FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
	public WebElement cnfpassWord;

	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement saveBtn;

	public void addUser() throws InterruptedException {
		Random ran = new Random();
		int ranvalue = ran.nextInt(1000);
		adminTab.click();
		addBtn.click();
		empName.sendKeys("a");
		Thread.sleep(5000);
		empName.sendKeys(Keys.ENTER);
		String usrname = "Arnav" + ranvalue;
		userName.sendKeys(usrname);
		passWord.sendKeys("123456789");
		cnfpassWord.sendKeys("123456789");
		Thread.sleep(5000);
		saveBtn.click();
		List<WebElement> elementList = driver.findElements(By.xpath("//td[@class='left']//a"));
		int count = elementList.size();
		for (int i = 0; i < count; i++) {
			if (elementList.get(i).equals(usrname)) {
				System.out.println("User Added");
			}
		}

	}

}
