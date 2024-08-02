package AutomationRestAPI.RestAssured;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Resizable 
{
  WebDriver driver;
	Actions actions;

	@Test
	@BeforeClass
	public void setUp() 
	{
    // Set up WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
    	actions = new Actions(driver);
	}
	@Test
    public void testResizable() 
	{
        // Open www.demoqa.com
        driver.get("https://demoqa.com/resizable");

        // Find resizable element
        WebElement resizableElement = driver.findElement(By.id("resizableBoxWithRestriction"));

        // Resize the element
        resizeElement(resizableElement, 200, 100); // Example: resizing by 200 pixels horizontally and 100 pixels vertically
    }

    // Method to resize the element
    private void resizeElement(WebElement element, int xOffset, int yOffset) 
    {
        actions.clickAndHold(element).moveByOffset(xOffset, yOffset).release().build().perform();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
