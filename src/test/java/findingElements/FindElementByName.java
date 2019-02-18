package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByName {

ChromeDriver driver;
	
	@BeforeTest
	public void openURL () {
		
		String chromePath = System.getProperty("user.dir")+"\\sources\\chromedriver.exe";	
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
			 
	}
	
	@Test
	public void findElemenyByName () {
		
		try {
			
			WebElement usernameTxt = driver.findElement(By.name("username1"));
			WebElement passwordTxt = driver.findElement(By.name("password"));
			System.out.println(usernameTxt.getTagName());
			System.out.println(passwordTxt.getTagName());
			
		} catch (NoSuchElementException e) {
			System.out.println("The Element is not found please use another attribute");
		}
		
	}
	
	@AfterTest
	public void closeDriver () {
		
		driver.quit();
	}
	
}
