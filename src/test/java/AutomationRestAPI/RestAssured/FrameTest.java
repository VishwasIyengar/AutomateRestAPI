package AutomationRestAPI.RestAssured;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest 
{
    private WebDriver driver;

    @BeforeTest
    public void setUp() 
    {
        // Set the path to chromedriver executable
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");

        // Initialize ChromeDriver instance
        driver = new ChromeDriver();
    }

    @Test
    public void handleFrame() throws InterruptedException 
    {
        driver.get("https://demoqa.com/frames");

        // Locate the frame element by ID or name
        WebElement frameElement = driver.findElement(By.id("frame1"));

        // Switch focus to the frame
        driver.switchTo().frame(frameElement);

        // Find the element within the frame and interact with it
        WebElement frameText = driver.findElement(By.id("sampleHeading"));
        Assert.assertEquals(frameText.getText(),"This is a sample page");
//        System.out.println("This is a sample page: " + frameText.getText());

        // Switch back to the main window (opxtional)
        driver.switchTo().defaultContent();

        Thread.sleep(2000); // Add a short pause for demonstration (optional)
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}


