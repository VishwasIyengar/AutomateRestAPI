package AutomationRestAPI.RestAssured;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DatePicker 
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
    public void testDatePicker() 
    {
    	driver.get("https://demoqa.com/date-picker");
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Open the date picker
        WebElement datePickerInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("datePickerMonthYearInput")));
        jsExecutor.executeScript("arguments[0].click();", datePickerInput);

        // Select Month
        WebElement selectMonth = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='react-datepicker__month-select']")));
        selectMonth.click();
        WebElement selectJanuary = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='January']")));
        selectJanuary.click();

        // Select Year
        WebElement selectYear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='react-datepicker__year-select']")));
        selectYear.click();
        WebElement select1990 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='1990']")));
        select1990.click();

        // Select Day
        WebElement selectDay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'react-datepicker__day--001') and not(contains(@class, 'react-datepicker__day--outside-month'))]")));
        selectDay.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

