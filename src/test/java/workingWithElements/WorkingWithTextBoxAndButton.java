package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithTextBoxAndButton {

	ChromeDriver driver;

	@BeforeTest
	public void openURL () {
		String chromePath = System.getProperty("user.dir")+"\\sources\\chromedriver.exe";	
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}
	
	@Test
	public void loginScreen () {
		
		WebElement usernameTxt = driver.findElement(By.id("username"));
		WebElement passwordTxt = driver.findElement(By.id("password"));
		WebElement btnTxt = driver.findElement(By.className("radius"));
		
		usernameTxt.clear();
		usernameTxt.sendKeys("tomsmith");
		
		passwordTxt.clear();
		passwordTxt.sendKeys("SuperSecretPassword!");
		
		btnTxt.click();
		
		WebElement successNotification = driver.findElement(By.id("flash"));
		System.out.println(successNotification.getText());
		Assert.assertTrue(successNotification.getText().
				contains("You logged into a secure area!"));
	}
	
	@AfterTest
	public void closeDriver ( ) {
		driver.close();
	}
}
