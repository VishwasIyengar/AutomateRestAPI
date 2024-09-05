package AutomationRestAPI.RestAssured;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class AmazonIPhonePurchaseTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));  // Increase wait time to 60 seconds
    }

    @Test
    public void testIPhonePurchase() throws Exception {
        try {
            // Search for iPhone
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']")));
            searchBox.sendKeys("iPhone");

            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='nav-search-submit-button']")));
            searchButton.click();
            

            WebElement secondExpensiveIPhone = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Apple iPhone 15 Plus (128 GB) - Black")));
            secondExpensiveIPhone.click();

            Set<String> s = driver.getWindowHandles();
            ArrayList<String> ar = new ArrayList<>(s);
            driver.switchTo().window(ar.get(1));

            WebElement addCard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='add-to-cart-button'])[2]")));
            addCard.click();

            WebElement proceedToCheckOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@aria-labelledby='attach-sidesheet-checkout-button-announce'])[1]")));
            proceedToCheckOut.click();

            retryingFindElement(By.xpath("//input[@name='email']")).sendKeys("vishwassv1995@gmail.com");
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
            continueButton.click();

            WebElement enterPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ap_password']")));
            enterPassword.sendKeys("Vishu@2024");

            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='signInSubmit']")));
            signInButton.click();

            WebElement fullNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address-ui-widgets-enterAddressFullName'])[1]")));
            fullNameInput.sendKeys("Vishwas Iyenagr");

            WebElement mobileNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address-ui-widgets-enterAddressPhoneNumber'])[1]")));
            mobileNumberInput.sendKeys("6361797204");

            WebElement postalCodeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address-ui-widgets-enterAddressPostalCode'])[1]")));
            postalCodeInput.sendKeys("560072");

            WebElement flatHousenoBuildingCompanyApartmentInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address-ui-widgets-enterAddressLine1'])[1]")));
            flatHousenoBuildingCompanyApartmentInput.sendKeys("#20/21 Sri KrishnaVenu");

            WebElement areaStreetSectorVillageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address-ui-widgets-enterAddressLine2'])[1]")));
            areaStreetSectorVillageInput.sendKeys("Maruthi Nagar 5th cross Chandra Layout");

            WebElement landMark = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address-ui-widgets-landmark'])[1]")));
            landMark.sendKeys("Beside Deffodil Kid Center");

        //    WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address-ui-widgets-enterAddressCity'])[1]")));
         //   city.sendKeys("BENGALURU");

            WebElement stateDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='address-ui-widgets-enterAddressStateOrRegion']//span[@class='a-button-text a-declarative']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stateDropdown);  // Scroll into view
            stateDropdown.click();

            WebElement karnatakaOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='KARNATAKA'])[1]")));
            try {
                karnatakaOption.click();
            } catch (Exception e) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", karnatakaOption);
                jsExecutor.executeScript("arguments[0].click();", karnatakaOption);
            }

        } catch (TimeoutException e) {
            handleTimeoutException(e);  // Handle TimeoutException separately
        } catch (Exception e) {
            captureScreenshotAndThrow(e);  // Capture screenshot and re-throw exception for other errors
        }

        Thread.sleep(5000);
    }

    // Method to handle TimeoutException separately
    private void handleTimeoutException(TimeoutException e) throws IOException {
        System.out.println("Timeout occurred: " + e.getMessage());
        captureScreenshot("timeout_error_screenshot.png");
        throw e;  // Re-throw the TimeoutException to ensure test fails
    }

    // Method to capture a screenshot and re-throw exception
    private void captureScreenshotAndThrow(Exception e) throws Exception {
        System.out.println("An error occurred: " + e.getMessage());
        captureScreenshot("error_screenshot.png");
        throw e;  // Re-throw the exception to ensure test fails
    }

    // Utility method to capture screenshots
    private void captureScreenshot(String fileName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(fileName));  // Save screenshot
    }

    // Retrying to find an element with multiple attempts
    public WebElement retryingFindElement(By by) {
        WebElement element = null;
        int attempts = 0;
        while (attempts < 3) {
            try {
                element = driver.findElement(by);
                break;
            } catch (NoSuchElementException e) {
                System.out.println("Attempt " + (attempts + 1) + " failed: " + e.getMessage());
            }
            attempts++;
        }
        if (element == null) {
            throw new NoSuchElementException("Element not found after multiple attempts");
        }
        return element;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        
    }
}
