package Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.nashorn.internal.ir.LexicalContextNode;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase4 {

    @Test
    public void testCase4() throws InterruptedException {
        /*
        Navigate to the "http://uitestpractice.com/"
        Move small box into the Drop Here box
        Validate text "Dropped" displayed
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/");
        driver.manage().window().maximize();

        WebElement droppable= driver.findElement(By.id("droppable"));
        WebElement draggable= driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,droppable).perform();
        String afterDropActual=droppable.getText().trim();
        String afterDropExpected="Dropped!";
        Assert.assertEquals(afterDropExpected,afterDropActual);

    }

   @Test
    public void testCase5() throws InterruptedException {
        /*
        Navigate to the "http://uitestpractice.com/"
        Click two times Double click button
        Validate Alert has "Double Clicked !!" text
        Click Okay button to close the alert
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/");
        driver.manage().window().maximize();

        WebElement doubleClick= driver.findElement(By.xpath("//button[@class='btn btn-default']"));
       Actions actions=new Actions(driver);
       actions.doubleClick(doubleClick).perform();

        Alert alert1=driver.switchTo().alert();

        String alertActualMessege= driver.switchTo().alert().getText();

        String expectedMessage="Double Clicked !!";

        System.out.println(alert1.getText());
        Assert.assertEquals(expectedMessage, alertActualMessege);
        Thread.sleep(4000);
        alert1.accept();

    }
}
