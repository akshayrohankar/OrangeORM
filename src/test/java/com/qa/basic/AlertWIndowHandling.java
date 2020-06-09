package com.qa.basic;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.resources.base;

public class AlertWIndowHandling extends base {

	@BeforeTest
	public void initMe() throws IOException {
		initializeDriver();
		driver.get("https://test1.absofttrainings.com/javascript-alert-confirm-prompt-boxes/");
	}

	@Test
	public void AlertWIndowHandlingTest() throws InterruptedException {
		Thread.sleep(3000);
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='alert']"))));
		WebElement btn = driver.findElement(By.xpath("//button[@id='confirm']"));
		btn.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String str = alert.getText();
		System.out.println(str);
		// alert.dismiss();
		alert.accept();
		Thread.sleep(3000);
	}

	@AfterTest
	public void closeMe() throws IOException {
		driver.quit();
	}
}
