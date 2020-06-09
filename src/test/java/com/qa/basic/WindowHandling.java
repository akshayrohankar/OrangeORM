package com.qa.basic;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.resources.base;

public class WindowHandling extends base {

	@BeforeTest
	public void initMe() throws IOException {
		initializeDriver();
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
	}

	@Test
	public void WindowHandlingTest() throws InterruptedException {
		WebElement window1 = driver.findElement(By.id("button1"));
		//WebElement window2 = driver.findElement(By.xpath("//button[contains(text(),'New Message Window')]"));
		WebElement window3 = driver.findElement(By.xpath("//button[contains(text(),'New Browser Tab')]"));
		String parentWindow = driver.getWindowHandle();
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform();
		window1.click();
		window3.click();
		Set<String> windowsId = driver.getWindowHandles();
		Iterator<String> it = windowsId.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		driver.switchTo().window(parentWindow);
		Thread.sleep(3000);
	}

	@AfterTest
	public void closeMe() throws IOException {
		driver.quit();
	}
}
