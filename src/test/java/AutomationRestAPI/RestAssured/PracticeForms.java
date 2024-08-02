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

public class PracticeForms {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up the WebDriver (assuming ChromeDriver is in your PATH)
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void testPracticeFormAutomation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WebElement firstNameInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Doe");

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("john.doe@example.com");

        WebElement genderRadioButton = driver.findElement(By.xpath("//label[text()='Male']"));
        jsExecutor.executeScript("arguments[0].click();", genderRadioButton);

        WebElement mobileNumberInput = driver.findElement(By.id("userNumber"));
        mobileNumberInput.sendKeys("1234567890");

        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        jsExecutor.executeScript("arguments[0].click();", dateOfBirthInput);

        WebElement selectMonth = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        selectMonth.click();
        WebElement selectJanuary = driver.findElement(By.xpath("//option[text()='January']"));
        jsExecutor.executeScript("arguments[0].click();", selectJanuary);

        WebElement selectYear = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        selectYear.click();
        WebElement select1990 = driver.findElement(By.xpath("//option[text()='1990']"));
        jsExecutor.executeScript("arguments[0].click();", select1990);

        WebElement selectDay = driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--001']"));
        jsExecutor.executeScript("arguments[0].click();", selectDay);

        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        subjectsInput.sendKeys("Maths");
        subjectsInput.sendKeys("\n");

        WebElement hobbiesCheckbox = driver.findElement(By.xpath("//label[text()='Sports']"));
        jsExecutor.executeScript("arguments[0].click();", hobbiesCheckbox);

        WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
        currentAddressInput.sendKeys("123 Street, City, Country");

        WebElement stateDropdown = driver.findElement(By.id("state"));
        jsExecutor.executeScript("arguments[0].click();", stateDropdown);
        WebElement ncrOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='state']//div[contains(@class,'css-1hwfws3')]")));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ncrOption);
        jsExecutor.executeScript("arguments[0].click();", ncrOption);

        WebElement cityDropdown = driver.findElement(By.id("city"));
        jsExecutor.executeScript("arguments[0].click();", cityDropdown);
        WebElement delhiOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='city']//div[contains(@class,'css-1hwfws3')]")));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", delhiOption);
        jsExecutor.executeScript("arguments[0].click();", delhiOption);

        WebElement submitButton = driver.findElement(By.id("submit"));
        jsExecutor.executeScript("arguments[0].click();", submitButton);

        Thread.sleep(6000);  // Wait to observe the result
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}





