package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseURL = "https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
         openBrowser(baseURL);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on the ‘Login’ link
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        //Verify the text ‘Welcome, Please Sign In!’
        String expectedMessage = "Welcome, Please Sign In!";
        WebElement actualTextElement= driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //click on the ‘Login’ link
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        //Enter valid username
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("Boradmaitrim@gmail.com");
        // Enter valid password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Maitri@123");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit' and text()='Log in']")).click();
        // Verify the ‘Log out’ text is display
        WebElement actualElement= driver.findElement(By.xpath("//a[text()='Log out']"));
        String actualText=actualElement.getText();
        String expectedText="Log out";
        Assert.assertEquals("User not Login Successfully",expectedText,actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        //click on the ‘Login’ link
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        //Enter invalid username
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("Boradmaitri@gmail.com");
        // Enter invalid password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Maitri123");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit' and text()='Log in']")).click();
        //Verify the error message ‘Login was unsuccessful.
        //Please correct the errors and try again. No customer account found’
        String actualMessage=driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        String expectedMessage="Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        Assert.assertEquals("Message not displayed correctly",expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
