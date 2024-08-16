package AutomationRestAPI.RestAssured;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	  WebElement aboutUs = driver.findElement(By.xpath("//a[normalize-space()='About Us']"));
	  aboutUs.click();
	  
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
