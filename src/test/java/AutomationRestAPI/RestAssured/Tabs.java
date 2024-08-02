package AutomationRestAPI.RestAssured;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tabs 
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
    public void testTabs() throws InterruptedException 
    {
        // Open www.demoqa.com
        driver.get("https://demoqa.com/tabs");

        // Find tab elements and click on them
        WebElement tab1 = driver.findElement(By.id("demo-tab-what"));
        WebElement tab2 = driver.findElement(By.id("demo-tab-origin"));
        WebElement tab3 = driver.findElement(By.id("demo-tab-use"));

        tab1.click();
        assert tab1.getAttribute("aria-selected").equals("true") : "Tab 1 is not selected";

        tab2.click();
        assert tab2.getAttribute("aria-selected").equals("true") : "Tab 2 is not selected";

        tab3.click();
        assert tab3.getAttribute("aria-selected").equals("true") : "Tab 3 is not selected";
        
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() 
    {
        // Close the browser
        driver.quit();
    }
}