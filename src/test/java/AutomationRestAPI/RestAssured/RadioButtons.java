package AutomationRestAPI.RestAssured;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtons
{
	WebDriver driver;
	
    @BeforeMethod
    public void setUp() 
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
    }
    
    @Test
    public void automateRadioButton() throws InterruptedException 
    {
        // Locate the radio button elements (assuming IDs for easier identification)
        WebElement yesRadioButton = driver.findElement(By.className("custom-control-label"));
        yesRadioButton.click();
        yesRadioButton.isDisplayed();
        
        Thread.sleep(5000);

    }
        
    
    @AfterMethod
    public void tearDown() 
    {
        driver.quit();
    }
}
