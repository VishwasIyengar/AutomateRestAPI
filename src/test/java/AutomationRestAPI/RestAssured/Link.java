package AutomationRestAPI.RestAssured;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Link {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up the WebDriver (assuming ChromeDriver is in your PATH)
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLinks() {
        try {
            // Open the webpage
            driver.get("https://demoqa.com/links");

            // Test the Home link (first link)
            WebElement homeLink = driver.findElement(By.id("simpleLink"));
            homeLink.click();

            // Switch to new tab
            String originalWindow = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            // Verify the URL of the new tab
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://demoqa.com/", "The URL is not as expected!");

            // Close the new tab and switch back to the original tab
            driver.close();
            driver.switchTo().window(originalWindow);

            // Test the Created link (API call simulation)
            WebElement createdLink = driver.findElement(By.id("created"));
            createdLink.click();

            // Wait for the response message
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement linkResponse = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse")));
            String responseText = linkResponse.getText();
            Assert.assertTrue(responseText.contains("Link has responded with staus 201 and status text Created"),
                              "The response text is incorrect!");

            // Wait for a while to observe the result (optional)
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
