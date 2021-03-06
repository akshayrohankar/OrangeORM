package com.qa.basic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.resources.base;

    public class TakeScreenshotConcept extends base{

        @BeforeTest
        public void initMe() throws IOException {
            initializeDriver();
            driver.get("http://www.google.com");
        }

        @Test
        public void TakeScreenshotTest() throws InterruptedException, IOException {
            // Take screenshot and store as a file format
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // now copy the screenshot to desired location using copyFile //method
            FileUtils.copyFile(src, new File(".\\Screenshot\\google.png"));
        }
        
        @AfterTest
        public void closeMe() throws IOException {
            driver.quit();
        }
    }


