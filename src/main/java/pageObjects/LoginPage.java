package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class LoginPage extends base {

	public LoginPage(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	WebDriver driver;
	By username = By.id("txtUsername");
	By password = By.id("txtPassword");
	By loginbtn = By.id("btnLogin");

	// By.id: txtUsername

	public WebElement getUsername() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLoginbtn() {
		return driver.findElement(loginbtn);
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