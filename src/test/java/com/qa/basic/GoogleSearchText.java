package com.qa.basic;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.resources.base;

public class GoogleSearchText extends base {

	@BeforeTest
	public void initMe() throws IOException {
		initializeDriver();
	}

	@Test
	public void GoogleSearchTextTest() throws InterruptedException {
		driver.get("http://www.google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Java");
		Thread.sleep(5000);
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='sbtc']"));
		System.out.println("total number of suggestions in search box:::===>" + list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("javatpoint")) {
				list.get(i).click();
				break;
			}
		}
	}

	@AfterTest
	public void closeMe() throws IOException {
		driver.quit();
	}
}
