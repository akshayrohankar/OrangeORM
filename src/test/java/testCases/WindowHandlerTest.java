package testCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.base;

public class WindowHandlerTest extends base {

	@BeforeTest
	public void initMe() throws IOException {

		initializeDriver();
	}

	@Test(priority = 0)
	public void testLoginPage() throws InterruptedException {
		LoginPage objLoginPage = new LoginPage(driver);
		objLoginPage.LoginProcess();

	}

	@Test(priority = 1)
	public void HandlerLoginPage() throws InterruptedException {
		WebElement directoryTab = driver.findElement(By.xpath("//b[contains(text(),'Directory')]"));
		WebElement maintenanceTab = driver.findElement(By.xpath("//b[contains(text(),'Maintenance')]"));
		WebElement leaveTab = driver.findElement(By.xpath("//b[contains(text(),'Leave')]"));
		WebElement pimTab = driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));

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
