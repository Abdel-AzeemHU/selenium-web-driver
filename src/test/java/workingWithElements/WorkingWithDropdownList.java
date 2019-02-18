package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithDropdownList {

	ChromeDriver driver;

	@BeforeTest
	public void openURL () {
		String chromePath = System.getProperty("user.dir")+"\\sources\\chromedriver.exe";	
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
	}
	
	@Test
	public void testDropdownList () throws InterruptedException {
		
		WebElement optionList = driver.findElement(By.id("dropdown"));
		Select selectOptions = new Select(optionList);
		// Verify dropdown doesn't support multiple selection
		Assert.assertFalse(selectOptions.isMultiple()); 
		Assert.assertEquals(3, selectOptions.getOptions().size());
		//selectOptions.selectByVisibleText("option 2");
		//selectOptions.selectByValue("1");
		selectOptions.selectByIndex(1);
		Assert.assertEquals("option 1", selectOptions.getFirstSelectedOption().getText());
		Thread.sleep(2000);
	}  
	
	@AfterTest
	public void closeDriver ( ) {
		driver.close();
	}
}
