package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClickWithActions {

	ChromeDriver driver;

	@BeforeTest
	public void openURL () {
		String chromePath = System.getProperty("user.dir")+"\\sources\\chromedriver.exe";	
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://cookbook.seleniumacademy.com/DoubleClickDemo.html");
	}
	
	@Test
	public void DoubleClickTest () throws InterruptedException {
		
		WebElement message = driver.findElement(By.id("message"));
		System.out.println(message.getCssValue("background-color"));
		Assert.assertEquals("rgba(0, 0, 255, 1)", message.getCssValue("background-color"));
		
		Actions builder = new Actions(driver);
		builder.doubleClick(message).perform();
		
		System.out.println(message.getCssValue("background-color"));
		Assert.assertEquals("rgba(255, 255, 0, 1)", message.getCssValue("background-color"));

		Thread.sleep(3000);
 
	}
	
	   
	@AfterTest
	public void closeDriver ( ) {
		driver.close();
	}
}