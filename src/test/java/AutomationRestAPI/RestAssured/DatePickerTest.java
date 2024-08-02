package AutomationRestAPI.RestAssured;

import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DatePickerTest 
{
	WebDriver driver;
  
    @BeforeClass
    public void setUp() 
    {
        // Set up WebDriver
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
    }

    @Test
    public void testDatePicker() throws InterruptedException 
    {
        driver.get("https://demoqa.com/date-picker");

        WebElement datePickerInput = driver.findElement(By.id("datePickerMonthYearInput"));datePickerInput.click(); 
         
        
        WebElement dateAndTimeInput = driver.findElement(By.xpath("//*[@id=\"dateAndTimePickerInput\"]"));
        try 
        {
        	dateAndTimeInput.click();
        } 
        catch (Exception e) 
        {           
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", dateAndTimeInput);
        }
		  
		 
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() 
    {
        driver.quit();
    }
}
