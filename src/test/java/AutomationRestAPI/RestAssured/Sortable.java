package AutomationRestAPI.RestAssured;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sortable 
{
	WebDriver driver;
	Actions actions;

  @Test
  @BeforeClass
  public void setUp() 
  {
      // Set up WebDriver
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      actions = new Actions(driver);
  }

  @Test
  public void testSortable() 
  {
      // Open www.demoqa.com
      driver.get("https://demoqa.com/sortable");

      // Find Sortable elements
      WebElement item1 = driver.findElement(By.xpath("//*[@id=\"demo-tab-list\"]"));
      WebElement item2 = driver.findElement(By.xpath("//*[@id=\"demo-tab-list\"]"));
      WebElement item3 = driver.findElement(By.xpath("//*[@id=\"demo-tab-list\"]"));

      // Drag and drop items to reorder them
      actions.dragAndDrop(item1, item3).build().perform();
      actions.dragAndDrop(item2, item1).build().perform();
      actions.dragAndDrop(item3, item2).build().perform();
  }

  @AfterClass
  public void tearDown()
  {
      // Close the browser
      driver.quit();
  }
}
