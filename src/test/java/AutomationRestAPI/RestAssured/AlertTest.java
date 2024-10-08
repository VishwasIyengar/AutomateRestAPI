package AutomationRestAPI.RestAssured;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

public class AlertTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set the path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
    }

    @Test
    public void automateAlert() throws InterruptedException {
        // Locate the button to trigger a simple alert
        WebElement clickMeButton = driver.findElement(By.id("alertButton"));

        // Use WebDriverWait for expected conditions (element to be clickable)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickMeButton));

        // Use JavascriptExecutor to click the button
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", clickMeButton);

        // Wait for the alert to be present
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Get the text from the alert
        String alertText = alert.getText();

        // Assert the expected alert text
        assertEquals(alertText, "You clicked a button", "Alert text does not match");

        // Accept the alert (similar for dismiss)
        alert.accept();

        Thread.sleep(3000); // Sleep to observe the result
    }

    @AfterTest
    public void tearDown() 
    {
        // Close the browser
        driver.quit();
    }
  }

