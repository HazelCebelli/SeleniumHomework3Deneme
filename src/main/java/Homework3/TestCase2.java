package Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

    @Test
    public void testCase21() throws InterruptedException {

          /*Navigate to the "http://uitestpractice.com/Students/Index"
    Click Create new button
    Enter any firstname, lastname and enrollment date
    Click create button
    Search firstname in search bar
    Validate the new information is created*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Index");
        driver.manage().window().maximize();
        WebElement createNew = driver.findElement(By.xpath("//button[@class='btn btn-info']/a"));
        createNew.click();
        driver.navigate().back();
        createNew.click();
        WebElement firstName= driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Miki");
        WebElement lastName= driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Mouse");
        WebElement enrollment= driver.findElement(By.xpath("//input[@id='EnrollmentDate']"));
        enrollment.sendKeys("1/9/2022 12:00:00 AM");
        WebElement create = driver.findElement(By.xpath("//input[@type='submit']"));
        create.click();
        WebElement searchName= driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchName.sendKeys("Miki");
        searchName.sendKeys(Keys.ENTER);
        WebElement validateName= driver.findElement(By.xpath("//td[@style='border:1px solid black']"));
        String actual=validateName.getText().trim();
        String expected="Miki";
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void testCase22() throws InterruptedException {

          /*Navigate to the "http://uitestpractice.com/Students/Index"
            Search any Lastname in search bar
            Click Edit button
            Change first name
            Click save button
            Search with new firstname
            Validate Firstname is changed */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Index");
        driver.manage().window().maximize();
        WebElement searchName= driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchName.sendKeys("Mouse");
        searchName.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement edit= driver.findElement(By.xpath("//button[@style='background-color:blueviolet']"));
        edit.click();
        WebElement firstName= driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.clear();
        firstName.sendKeys("Mikiiiiiiii");
        WebElement saveButton= driver.findElement(By.xpath("//input[@type='submit']"));
        Thread.sleep(2000);
        saveButton.click();
        searchName= driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchName.sendKeys("Mikiiiiiiii");
        searchName.sendKeys(Keys.ENTER);

        WebElement validateNameChange= driver.findElement(By.xpath("//td[@style='border:1px solid black']"));
        String actual=validateNameChange.getText().trim();
        String expected="Mikiiiiiiii";
        Assert.assertEquals(expected,actual);
 }

    @Test
    public void testCase3() throws InterruptedException {
        /*Navigate to the "http://uitestpractice.com/Students/Index"
        Search any Lastname in search bar
        Click delete button
        Confirm delete function
        Search with same lastname
        Validate "There are zero students with this search text Page 0 of 0" after deleting the user*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Index");
        driver.manage().window().maximize();

        WebElement searchName= driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchName.sendKeys("Mouse");
        searchName.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement delete= driver.findElement(By.xpath("//button[@style='background-color:red']"));
        delete.click();
        WebElement deleteConfirm= driver.findElement(By.xpath("//input[@value='Delete']"));
        Thread.sleep(1500);
        deleteConfirm.click();
        searchName= driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchName.sendKeys("Mouse");
        searchName.sendKeys(Keys.ENTER);
        //WebElement validate= driver.findElement(By.xpath("//*[contains(text(),\"There are zero students with this search text Page 0 of 0\")]")); /html/head/body/div[2]/div/form
        // Diger YONTEM: WebElement warning=driver.findElement(By.xpath("//*[text() [contains(. , 'There')]]"));
        WebElement validate= driver.findElement(By.xpath("/html/head/body/div[2]/div/form"));
        String actual=validate.getText().trim();
        System.out.println("actual");
        Assert.assertEquals("There are zero students with this search text Page 0 of 0",actual);


    }

}
