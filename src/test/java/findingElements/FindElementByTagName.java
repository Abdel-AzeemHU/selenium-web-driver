package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByTagName {

	ChromeDriver driver;

	@BeforeTest
	public void openURL () {
		String chromePath = System.getProperty("user.dir")+"\\sources\\chromedriver.exe";	
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}

	@Test
	public void findElemenyByTagName () {
	
		WebElement loginBtn = driver.findElement(By.tagName("button"));
		loginBtn.click();
	}
		

	@AfterTest
	public void closeDriver () {
		driver.quit();
	}
}
