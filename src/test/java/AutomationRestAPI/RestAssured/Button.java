package AutomationRestAPI.RestAssured;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Button
{
	WebDriver driver;
    @BeforeClass
    public void setUp() 
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
    }
    
    @Test
    public void testButtonAutomation() 
    {
        // Open demoqa.com
        driver.get("https://demoqa.com/buttons");

        // Find buttons by their XPath
        WebElement doubleclickButton = driver.findElement(By.xpath("(//button[normalize-space()='Double Click Me'])[1]"));
		
		 WebElement rightClickButton = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
	
        WebElement clickmeButton = driver.findElement(By.xpath("(//button[normalize-space()='Click Me'])[1]"));

        // Perform button interactions
        doubleclickButton.click();
        rightClickButton.click(); // Note: Right-click emulation may not work on all browsers by default
        clickmeButton.click(); // Note: Double-click emulation may not work on all browsers by default

        // Wait for a moment to observe the actions (optional)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() 
    {        
        driver.quit();
    }
}
