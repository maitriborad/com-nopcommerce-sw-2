package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.UUID;

public class RegisterTest extends BaseTest {
    String baseURL = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        //click on the ‘Register’ link
        driver.findElement(By.xpath("//a[starts-with(text(),'Reg')]")).click();
        //Verify the text ‘Register’
        String actualText=driver.findElement(By.xpath("//h1[text()='Register']")).getText();
        String expectedText="Register";
        Assert.assertEquals("Register not displayed correctly",expectedText,actualText);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        driver.manage().deleteAllCookies();
        //click on the ‘Register’ link
        driver.findElement(By.xpath("//a[starts-with(text(),'Reg')]")).click();
        //Select gender radio button
        driver.findElement(By.xpath("//input[@name='Gender' and @value='F']")).click();
        //Enter First name
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Maitri");
        //Enter Last name
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Borad");
        //Select Day Month and Year
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")).sendKeys("06");
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).sendKeys("07");
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("1995");
        //Enter Email address
        String email= "random-" + UUID.randomUUID().toString() + "@example.com";
        driver.findElement(By.xpath("//input[contains(@id,'E')]")).sendKeys(email);
        //Enter Password
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("Maitri@123");
        //Enter Confirm password
        driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("Maitri@123");
        //Click on REGISTER button
        driver.findElement(By.xpath("//button[contains(text(),'Regi')]")).click();
        //Verify the text 'Your registration completed’
        String actualMessage=driver.findElement(By.xpath("//div[text()='Your registration completed']")).getText();
        String expectedMessage="Your registration completed";
        Assert.assertEquals("Login not successful",expectedMessage,actualMessage);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
