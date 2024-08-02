package AutomationRestAPI.RestAssured;

import java.time.Duration; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProgressBar {
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
    public void testProgressBar() 
    {
    	try
    	{
        // Open www.demoqa.com
        driver.get("https://demoqa.com/progress-bar");

        // Find the Progress Bar element
     // Find and click the "Start" button to initiate progress
        WebElement startButton = driver.findElement(By.id("startStopButton"));
        startButton.click();

        // Wait for progress bar to disappear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("progressBar")));

        // Verify completion message
        WebElement completionMessage = driver.findElement(By.id("progressBarResult"));
        String actualMessage = completionMessage.getText();
        String expectedMessage = "Progress Bar";

        // Assert completion message
        assert actualMessage.equals(expectedMessage) : "Completion message doesn't match";

        // Close the browser
        driver.quit();
    } catch (org.openqa.selenium.WebDriverException e) {
        System.err.println("WebDriverException occurred: " + e.getMessage());
        // Handle the exception here, e.g., restart the browser or terminate the test
    }
    }

    @AfterClass
    public void tearDown() 
    {
        // Close the browser
        driver.quit();
    }
}