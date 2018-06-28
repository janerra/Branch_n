package Table;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import crossBrowsers.TestConstants1;

public class Field_test {
WebDriver driver;
	
	@BeforeClass 
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", TestConstants1.CHROME_PATH);
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://toolsqa.com/automation-practice-form/");
	}
	
	@Test
	public void Field() {
		WebElement fiels = driver.findElement(By.name("firstname"));
		System.out.println(fiels.getAttribute("value"));
	}
	
}
