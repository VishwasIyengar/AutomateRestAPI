package AutomationRestAPI.RestAssured;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBox 
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
    public void testCheckBoxInteractions() throws InterruptedException 
    {
        // Open the webpage
        driver.get("https://demoqa.com/checkbox");

        
        WebElement expandButton = driver.findElement(By.cssSelector(".rct-option-expand-all"));
        expandButton.click();

        // Select the "Desktop" checkbox
        WebElement desktopCheckbox = driver.findElement(By.xpath("//label[@for='tree-node-desktop']/span[@class='rct-checkbox']"));
        desktopCheckbox.click();

        

        // Select the "Documents" checkbox
        WebElement documentsCheckbox = driver.findElement(By.xpath("//label[@for='tree-node-documents']/span[@class='rct-checkbox']"));
        documentsCheckbox.click();
        Assert.assertTrue(documentsCheckbox.isDisplayed(), "Documents checkbox is not selected");

        
        Thread.sleep(4000);
    }

    @AfterClass
    public void tearDown() 
    {
        // Close the browser
        driver.quit();
    }
}