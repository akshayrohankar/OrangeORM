package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class DragAndDropConcept extends base {

    @BeforeTest
    public void initMe() throws IOException {

        initializeDriver();
    }

    @Test
    public void DragDropTest() throws InterruptedException {

        driver.get("https://demoqa.com/droppable/");

        WebElement draggable  = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Thread.sleep(5000);

        Actions action = new Actions(driver);
        action.clickAndHold(draggable)
                .moveToElement(droppable)
                .release()
                .build()
                .perform();


    }

    @AfterTest
    public void closeMe() throws IOException {

        driver.quit();
    }
}
