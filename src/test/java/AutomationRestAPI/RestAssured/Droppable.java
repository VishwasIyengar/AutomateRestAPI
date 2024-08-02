package AutomationRestAPI.RestAssured;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Droppable 
{
	WebDriver driver;
	Actions actions;

	@Test
	@BeforeClass
	public void setUp() 
	{   
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
    	actions = new Actions(driver);
	}
	
	@Test
    public void testDroppable() 
	{
        // Open the webpage
        driver.get("https://demoqa.com/droppable");

        // Locate draggable and droppable elements
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        // Perform drag-and-drop action
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).build().perform();

        // Wait for a while to observe the result
        try {
            Thread.sleep(3000);
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
