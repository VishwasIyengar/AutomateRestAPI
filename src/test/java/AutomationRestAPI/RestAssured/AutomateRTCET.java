package AutomationRestAPI.RestAssured;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class AutomateRTCET {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
        
        // Navigate to the website
        driver.get("https://rtctek.com/");
    }

    @Test
    public void testClickAllServicesLinks() {
        // Locate the Services menu item
        WebElement servicesMenu = driver.findElement(By.linkText("Services"));

        // Hover over the Services menu to display the dropdown
        Actions actions = new Actions(driver);
        actions.moveToElement(servicesMenu).perform();

        // Wait for the dropdown to be visible
        try {
            Thread.sleep(2000);  // Better to use WebDriverWait in real cases
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get all the links under the dropdown
     // Get all the links under the dropdown
        List<WebElement> dropdownLinks = driver.findElements(By.cssSelector(".dropdown-menu a"));


        // Loop through each link and click it
        for (WebElement link : dropdownLinks) {
            actions.moveToElement(servicesMenu).perform(); // Ensure the dropdown is visible
            String linkText = link.getText();
            link.click();

            // Verify the page title or URL or any specific element on the new page
            System.out.println("Clicked on: " + linkText);

            // Optionally navigate back to the original page
            driver.navigate().back();
            actions.moveToElement(servicesMenu).perform(); // Hover again
        }
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

