package SeleniumSessions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class Base_Test {

	public static WebDriver driver;
	public static Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
FileInputStream fis=new FileInputStream("E:\\Eclipse Workspace\\OrangeORM\\src\\main\\java\\resources\\data.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", "E:\\Eclipse Workspace\\chromedriver.exe");
	ChromeOptions options  = new ChromeOptions();
	//options.addArguments("incognito");
	options.addArguments("--disable-popup-blocking");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	driver = new ChromeDriver(options);
	//driver = new ChromeDriver();

	//driver= new ChromeDriver();
		//execute in chrome driver


}
else if (browserName.equals("firefox"))
{
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
//	IE code
}

driver.get(prop.getProperty("url"));
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
return driver;


}

public void getScreenshot(String result) throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("E:\\Eclipse Workspace\\OrangeORM\\Screenshots"+result+"screenshot.png"));
	
}


}
