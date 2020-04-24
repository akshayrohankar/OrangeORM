package SeleniumSessions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

    public class TakeScreenshotConcept extends Base_Test{

        @BeforeTest
        public void initMe() throws IOException {

            initializeDriver();
        }

        @Test
        public void TakeScreenshotTest() throws InterruptedException, IOException {


            driver.get("http://www.google.com");


            // Take screenshot and store as a file format
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // now copy the screenshot to desired location using copyFile //method
            FileUtils.copyFile(src, new File("E:\\Eclipse Workspace\\Screenshot\\google.png"));

        }
        @AfterTest
        public void closeMe() throws IOException {

            driver.quit();
        }
    }


