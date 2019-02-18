package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByClass {

	ChromeDriver driver;

	@BeforeTest
	public void openURL () {

		String chromePath = System.getProperty("user.dir")+"\\sources\\chromedriver.exe";	
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");

	}

	@Test
	public void findElemenyByClass () {
		try {

			WebElement usernameTxt = driver.findElement(By.name("username"));
			WebElement passwordTxt = driver.findElement(By.name("password"));
			WebElement loginBtn = driver.findElement(By.className("radius"));
			System.out.println(usernameTxt.getTagName());
			System.out.println(passwordTxt.getTagName());
			System.out.println(loginBtn.getTagName());

		} catch (NoSuchElementException e) {
			System.out.println("The Element is not found please use another attribute");
		}
	}

	@AfterTest
	public void closeDriver () {
		driver.quit();
	}
}
