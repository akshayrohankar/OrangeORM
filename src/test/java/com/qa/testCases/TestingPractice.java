package com.qa.testCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pageObjects.LoginPage;
import com.qa.resources.base;

public class TestingPractice extends base {

	@BeforeTest
	public void initMe() throws IOException {

		initializeDriver();
	}

	@Test
	public void HandlerLoginPage() throws InterruptedException {
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		Thread.sleep(3000);
		WebElement dropdownButton = driver.findElement(By.xpath("//select[@id='continents']"));

		Select sel = new Select(dropdownButton);
		
		//dropdownButton.click();
		int count = sel.getOptions().size();
	System.out.println(count);
		
	}

	@AfterTest
	public void closeMe() throws IOException {

		driver.quit();
	}

}
