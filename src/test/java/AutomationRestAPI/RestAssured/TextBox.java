package AutomationRestAPI.RestAssured;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TextBox
{
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.get("https://demoqa.com/text-box");
      driver.manage().window().maximize();
  }
  
  @Test
  public void testTextBox() throws InterruptedException 
  {
	  WebElement FullNameField = driver.findElement(By.id("userName"));
      FullNameField.sendKeys("Vishwas Iyengar");
      WebElement EmailField = driver.findElement(By.id("userEmail"));
      EmailField.sendKeys("vishwassv1995@gmail.com");
      WebElement CurrentAddressField = driver.findElement(By.id("currentAddress"));
      CurrentAddressField.sendKeys("abc");
      WebElement PermanentAddressField = driver.findElement(By.id("permanentAddress"));
      PermanentAddressField.sendKeys("abc");
      WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
      submitButton.click(); 
      
      
      
	String enteredText = FullNameField.getAttribute("value");

      // Assert that the entered text matches the expected text
	String expectedText = "Vishwas Iyengar";
	Assert.assertEquals(enteredText, expectedText, "Text entered into full name field is not as expected");
	Thread.sleep(5000);
  }

  @AfterMethod
  public void tearDown() 
  {
      driver.quit();
  }
}
