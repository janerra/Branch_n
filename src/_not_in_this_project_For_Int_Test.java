import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _not_in_this_project_For_Int_Test {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_PATH);
		driver = new ChromeDriver();
		

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {
		driver.get("https://www.globalpaymentsresource.com/accuity-webapp/login.html");
		driver.findElement(By.linkText("I forgot my username and/or password")).click();
		driver.findElement(By.id("usernameReset")).sendKeys("qatest" + Keys.ENTER);
		driver.findElement(By.id("send-btn")).click();
		
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

	
}
