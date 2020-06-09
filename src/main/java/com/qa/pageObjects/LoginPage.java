package com.qa.pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.resources.base;

public class LoginPage extends base {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtUsername")
	public WebElement username;

	@FindBy(id = "txtPassword")
	public WebElement password;

	@FindBy(id = "btnLogin")
	public WebElement loginbtn;

	@FindBy(xpath = "//span[@id='spanMessage']")
	public WebElement invalidLoginMsg;
	
	@FindBy(xpath = "//b[contains(text(),'Directory')]")
	public WebElement directoryTab;
	
	@FindBy(xpath = "//b[contains(text(),'Maintenance')]")
	public WebElement maintenanceTab;
	
	@FindBy(xpath = "//b[contains(text(),'Leave')]")
	public WebElement leaveTab;
	
	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
	public WebElement pimTab;
	
	public void LoginProcess() throws InterruptedException {
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginbtn.click();
	}

	public String ValidateSuccessfullLogin() {
		String actualPageTitle = driver.getTitle();
		System.out.println(actualPageTitle);
		return actualPageTitle;
	}

	public void ValidateUnSuccessfullLogin() {
		try {
			if (!invalidLoginMsg.isDisplayed()) {
				System.out.println("Valid credentials");
			} else {
				System.out.println("Invalid Login");
			}
		} catch (NoSuchElementException el) {
			System.out.println("Caught Exception Valid Credentials");
		}
	}

	public void VerifyWindowsHandlerFunctionality() {
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform();
		directoryTab.click();
		maintenanceTab.click();
		leaveTab.click();
		pimTab.click();

		action.keyUp(Keys.CONTROL).build().perform();

		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> it = s1.iterator();

		String mainWindow = it.next();
		while (it.hasNext()) {

			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		driver.switchTo().window(mainWindow);
	}

}