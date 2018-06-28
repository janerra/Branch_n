package Table;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import crossBrowsers.TestConstants1;

public class IFrame {
WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", TestConstants1.CHROME_PATH);
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	@Test
	public void test() {
	WebElement iframe = driver.findElement(By.tagName("iframe"));
	driver.switchTo().frame(iframe);
	driver.findElement(By.id("tinymce")).sendKeys("TTYTYTYTYTYTYT");
	driver.switchTo().parentFrame();
		
}
}
