package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindByLinkText {

	ChromeDriver driver;

	@BeforeTest
	public void openURL () {
		String chromePath = System.getProperty("user.dir")+"\\sources\\chromedriver.exe";	
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}
	
	@Test
	public void testLinkText ( ) {
		
		WebElement seleniumLink = driver.findElement(By.linkText("Elemental Selenium"));
		System.out.println(seleniumLink.getAttribute("href"));
	}
	
	@Test
	public void testLinkPArtialText ( ) {
		
		WebElement seleniumLink = driver.findElement(By.partialLinkText("Elemental"));
		System.out.println(seleniumLink.getAttribute("href"));
	}
	
	@AfterTest
	public void closeDriver () {
		driver.quit(); 
	}
}
