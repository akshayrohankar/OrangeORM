package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class AdminPage extends base {

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	By adminTab = By.xpath("//b[contains(text(),'Admin')]");
	By RecruitmentTab = By.xpath("//b[contains(text(),'Recruitment')]");
	By addBtn = By.xpath("//input[@id='btnAdd']");
	By empName = By.xpath("//input[@id='systemUser_employeeName_empName']");
	By userName = By.xpath("//input[@id='systemUser_userName']");
	By passWord = By.xpath("//input[@id='systemUser_password']");
	By cnfpassWord = By.xpath("//input[@id='systemUser_confirmPassword']");
	By saveBtn = By.xpath("//input[@id='btnSave']");

	public WebElement getAdminTab() {
		return driver.findElement(adminTab);
	}
	
	public WebElement getAddbtn() {
		return driver.findElement(addBtn);
	}
	
	public WebElement getEmpName() {
		return driver.findElement(empName);
	}

	public WebElement getUserName() {
		return driver.findElement(userName);
	}

	public WebElement getPassWord() {
		return driver.findElement(passWord);
	}

	public WebElement getCnfpassWord() {
		return driver.findElement(cnfpassWord);
	}

	public WebElement getSaveBtn() {
		return driver.findElement(saveBtn);
	}
	
	public WebElement getRecruitmentTab() {
		return driver.findElement(RecruitmentTab);
	}

	public void addUser() throws InterruptedException {
		Random ran=new Random();
		int ranvalue=ran.nextInt(1000);
		getAdminTab().click();
		getAddbtn().click();
		getEmpName().sendKeys("a");
		Thread.sleep(5000);
		getEmpName().sendKeys(Keys.ENTER);
		String usrname="Arnav"+ranvalue;
		getUserName().sendKeys(usrname);
		getPassWord().sendKeys("123456789");
		getCnfpassWord().sendKeys("123456789");
		Thread.sleep(5000);
		getSaveBtn().click();
	    List<WebElement> elementList=driver.findElements(By.xpath("//td[@class='left']//a"));
		int count=elementList.size();
		for(int i=0;i<count;i++)
		{
			if(elementList.get(i).equals(usrname))
			{
				System.out.println("User Added");
			}
		}
		
	}

}
