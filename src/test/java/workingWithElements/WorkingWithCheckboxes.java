package workingWithElements;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithCheckboxes {

	ChromeDriver driver;

	@BeforeTest
	public void openURL () {
		String chromePath = System.getProperty("user.dir")+"\\sources\\chromedriver.exe";	
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
	}

	@Test(enabled=false)
	public void testCheckbox () throws InterruptedException {

		WebElement check1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		check1.click();
		Thread.sleep(2000);

		WebElement check2 = driver.findElement(By.xpath("//*[@id=\\\"checkboxes\\\"]/input[2]"));
		if (check2.isSelected()) {	
			check2.click();
		}
	}

	@Test
	public void testIsElementPresent () {
		if (isElementPresent(By.xpath("//*[@id=\\\"checkboxes\\\"]/input[1]"))) {

			WebElement check1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
			if (!check1.isSelected()) {
				check1.click();
			}
		} else 
		{
			Assert.fail("checkbox 1 doesn't exist");
		}
	}

	private boolean isElementPresent (By by) {
		try {
			driver.findElement(by);
			return true;		
		} catch (NoSuchElementException e) {
			return false;
		}	
	}

	@AfterTest
	public void closeDriver ( ) {
		driver.close();
	}
}
