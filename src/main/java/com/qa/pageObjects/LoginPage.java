package com.qa.pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
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

}