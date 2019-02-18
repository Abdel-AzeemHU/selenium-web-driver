package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByXPath {


	ChromeDriver driver;

	@BeforeTest
	public void openURL () {
		String chromePath = System.getProperty("user.dir")+"\\sources\\chromedriver.exe";	
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}
	
	@Test
	public void testFindByAbsoulteXPath ( ) {
		
		WebElement usernameTxt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement passwordTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
		System.out.println(usernameTxt.getTagName());
		System.out.println(passwordTxt.getTagName());
		System.out.println(loginBtn.getText());

	}
	
	@Test
	public void testFindByRelativeXPath ( ) {
		
		WebElement usernameTxt = driver.findElement(By.xpath("input"));
		WebElement passwordTxt = driver.findElement(By.xpath("input[1]"));
		WebElement loginBtn = driver.findElement(By.xpath("//button"));
		System.out.println(usernameTxt.getTagName());
		System.out.println(passwordTxt.getTagName());
		System.out.println(loginBtn.getText());

	} 
	
	@AfterTest
	public void closeDriver () {
		driver.quit(); 
	}
}
