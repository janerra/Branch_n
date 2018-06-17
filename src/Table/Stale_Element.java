package Table;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import crossBrowsers.TestConstants1;
/*
1)	Go to the URL - https://www.globalpaymentsresource.com/accuity-webapp/login.html
2)	Click on the link I forgot my username and/or password
3)	Enter user name as “qatest”
4)	Click on the SEND button
5)	Verify the confirmation message “We have received your request for a password reset. It may take a few minutes for the password reset instructions to arrive in your email. If you don't receive the email within a few minutes, please check your Junk/Spam email folder. The password reset link will expire after 48 hours.”

 */
public class Stale_Element {

	WebDriver driver;
	
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", TestConstants1.CHROME_PATH);
		driver = new ChromeDriver();
		driver.get("https://www.globalpaymentsresource.com/accuity-webapp/login.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test 
	public void test() throws InterruptedException {
		Thread.sleep(10);
		WebElement li = driver.findElement(By.xpath("//a[@href='#password-reset-modal']"));
		//li.click();
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", li);
//
		 Actions builder = new Actions(driver);
		 builder.moveToElement(li).click(li).perform();
		 
//		 for (int i=1; i<4; i++) 
//		   try{
//		 driver.findElement(By.xpath("//a[@href='#password-reset-modal']")).click();
//     	 break;
//		   } catch(StaleElementReferenceException e) {
//			   System.out.println("1111");
//			   e.toString();
//		   }
	}
	@AfterTest
	public void tear_down(){
		//driver.quit();
	}
	
}
