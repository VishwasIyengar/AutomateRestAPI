package AutomationRestAPI.RestAssured;

import org.testng.annotations.Test; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

	public class RegistrationForm
	{
	    WebDriver driver;
	    @BeforeMethod
	    public void setUp() 
	    {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("https://www.toolsqa.com/selenium-training/#enroll-form");
	        driver.manage().window().maximize();
	    }
	    @Test
	    public void testRegistrationForm() throws InterruptedException 
	    {
	        WebElement firstNameInput = driver.findElement(By.id("first-name"));
	        firstNameInput.sendKeys("Vishwas");

	        WebElement lastNameInput = driver.findElement(By.id("last-name"));
	        lastNameInput.sendKeys("Iyengar");

	        WebElement phoneNumberInput = driver.findElement(By.id("mobile"));
	        phoneNumberInput.sendKeys("9611075397");
	        
	        WebElement emailInput = driver.findElement(By.id("email"));
	        emailInput.sendKeys("vvishwas083@gmail.com");
	        
	        WebElement countryInput = driver.findElement(By.id("country"));
	        countryInput.sendKeys("India");
	        
	        WebElement cityInput = driver.findElement(By.id("city"));
	        cityInput.sendKeys("Bengaluru");
	        
	        WebElement capitchaInput = driver.findElement(By.id("code"));
	        capitchaInput.sendKeys("sQvX");
	        
	        WebElement sendButton = driver.findElement(By.xpath("//*[@id=\"enroll-form\"]/button"));
	        sendButton.click();
	        
	        Thread.sleep(3000);
	    }	    

	    @AfterMethod
	    public void tearDown() 
	    {
	        driver.quit();
	    }
	}
