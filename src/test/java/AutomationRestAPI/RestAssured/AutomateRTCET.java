package AutomationRestAPI.RestAssured;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutomateRTCET {

     WebDriver driver;
    WebDriverWait wait;
   

    @BeforeClass
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        // Navigate to the website
        driver.get("https://rtctek.com/");
        
    }

    @Test
    public void testClickAllServicesLinks() throws InterruptedException {   

        WebElement aboutUs = driver.findElement(By.xpath("//a[normalize-space()='About Us']"));
        aboutUs.click();
        // Assert the URL or page title after clicking "About Us"
        Assert.assertEquals(driver.getCurrentUrl(), "https://rtctek.com/about-us/");
        
        WebElement services = driver.findElement(By.xpath("//a[normalize-space()='Services']"));
        services.click();
        // Assert the URL or page title after clicking "Services"
        Assert.assertEquals(driver.getCurrentUrl(), "https://rtctek.com/services/");

        WebElement industries = driver.findElement(By.xpath("//a[normalize-space()='Industries']"));
        industries.click();
        // Assert the URL or page title after clicking "Industries"
        Assert.assertEquals(driver.getCurrentUrl(), "https://rtctek.com/services/#");

        WebElement knowledgeCenter = driver.findElement(By.xpath("//a[normalize-space()='Knowledge Center']"));
        knowledgeCenter.click();
        // Assert the URL or page title after clicking "Knowledge Center"
        Assert.assertEquals(driver.getCurrentUrl(), "https://rtctek.com/blogs/");

        WebElement getAQuote = driver.findElement(By.xpath("//li[@id='menu-item-10904']//a[normalize-space()='Get a Quote']"));
        getAQuote.click();
        // Assert the URL or page title after clicking "Get a Quote"
        Assert.assertEquals(driver.getCurrentUrl(), "https://rtctek.com/get-a-quote/");

        WebElement applyNow = driver.findElement(By.xpath("//span[@class='cus-nav']"));
        applyNow.click();
        // Assert the URL or page title after clicking "Apply Now"
        Assert.assertEquals(driver.getCurrentUrl(), "https://rtctek.com/apply-now");
        
        // Optional sleep to observe the final page
        Thread.sleep(6000);
    }
    



    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

