package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithSubmitMethod {

	ChromeDriver driver;
	WebElement txtSearch;

	@BeforeTest
	public void openURL () {
		String chromePath = System.getProperty("user.dir")+"\\sources\\chromedriver.exe";	
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");
	}
	
	@Test
	public void testSubmit () {
		
		txtSearch = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
		txtSearch.clear();
		txtSearch.sendKeys("Selenium WebDriver");
		txtSearch.submit();
		
		txtSearch = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
		txtSearch.clear();
		txtSearch.sendKeys("Selenium WebDriver Book");
		txtSearch.submit();
	}
	
	@AfterTest
	public void closeDriver ( ) {
		driver.close();
	}
}
