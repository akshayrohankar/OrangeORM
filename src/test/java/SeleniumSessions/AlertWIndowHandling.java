package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class AlertWIndowHandling extends base{

    @BeforeTest
    public void initMe() throws IOException {

        initializeDriver();
    }

    @Test
    public void AlertWIndowHandlingTest() throws InterruptedException {


        driver.get("https://test1.absofttrainings.com/javascript-alert-confirm-prompt-boxes/");

        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver,15);
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='alert']"))));



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
