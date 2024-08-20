package AutomationRestAPI.RestAssured;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomateRTCET 
{
  
	WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() 
    {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rtctek.com/");
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));  // Increase wait time to 60 seconds
    }
    
    
    
  
  @Test
  public void testAllLinks() throws InterruptedException 
  {
	
	        // Locate the 'Services' tab in the navigation bar
	  WebElement readMoreButton = driver.findElement(By.xpath("//span[contains(text(),'Read More')]"));
	  readMoreButton.click();
	  
	  WebElement contactUsButton = driver.findElement(By.xpath("//span[contains(text(),'Contact Us')]"));
	  contactUsButton.click();
	  
	  WebElement fullNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='form-field-name']")));
      fullNameInput.sendKeys("Vishwas Iyenagr");
      
      WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='form-field-email']")));
      emailInput.sendKeys("vishwassv1995@gmail.com");
      
      WebElement messageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='form-field-message']")));
      messageInput.sendKeys("regarding job openings");
      
      WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
      submitButton.click();
         
      WebElement aboutUs = driver.findElement(By.xpath("//a[normalize-space()='About Us']"));
	  aboutUs.click();//a[normalize-space()='DevOps Automation Services']
	  
	  WebElement services = driver.findElement(By.xpath("//a[normalize-space()='Services']"));
	  services.click();
	  
	  WebElement industries = driver.findElement(By.xpath("//a[normalize-space()='Industries']"));
	  industries.click();
	  
	  WebElement knoledgeCenter = driver.findElement(By.xpath("//a[normalize-space()='Knowledge Center']"));
	  knoledgeCenter.click();
	  
	  WebElement getAQuote = driver.findElement(By.xpath("//li[@id='menu-item-10904']//a[normalize-space()='Get a Quote']"));
	  getAQuote.click();
	  
	  WebElement applyNow = driver.findElement(By.xpath("//span[@class='cus-nav']"));
	  applyNow.click();
	  
	  
	  
      Thread.sleep(5000);
  }

  @AfterClass
  public void tearDown()
  {
      if (driver != null) 
      {
          driver.quit();
      }
  }
}
