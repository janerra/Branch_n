package Table;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import crossBrowsers.TestConstants1;

public class AllTextOnPage {
WebDriver driver;
	
	@BeforeClass 
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", TestConstants1.CHROME_PATH);
		
		driver = new ChromeDriver();
		//driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.quora.com/How-can-I-get-all-the-label-text-using-selenium-from-the-source-file");
	}
	
	@Test
	public void searchTest() {
		WebElement bodyText = driver.findElement(By.tagName("body"));
		
		System.out.println(bodyText.getText());
	}
	
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
}
