package Table;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import crossBrowsers.TestConstants1;
/*
1)	Go to the URL - https://www.globalpaymentsresource.com/accuity-webapp/login.html
2)	Click on the link I forgot my username and/or password
3)	Enter user name as “qatest”
4)	Click on the SEND button
5)	Verify the confirmation message “We have received your request for a password reset. It may take a few minutes for the password reset instructions to arrive in your email. If you don't receive the email within a few minutes, please check your Junk/Spam email folder. The password reset link will expire after 48 hours.”

 */
public class Test_class {

	WebDriver driver;
	
	@BeforeClass 
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", TestConstants1.CHROME_PATH);
		
		driver = new ChromeDriver();
		//driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://toolsqa.com/automation-practice-form/");
	}
	
	

	@Test
	public void testIt2() {
	
	Select select = new Select(driver.findElement(By.id("selenium_commands")));
	select.selectByIndex(2);
	
	Assert.assertEquals(select.getFirstSelectedOption().getText(), "Switch Commands");
	
	WebElement we = driver.findElement(By.id("tool-0"));
	we.click();
	
	String path = "C:\\temp222\\ER.png";
	driver.findElement(By.id("photo")).sendKeys(path);
	
	List<WebElement> testFields = driver.findElements(By.xpath("//input[@type='text']"));
	System.out.println("***"+testFields.size());
	
//	WebElement text = driver.findElement(By.tagName("body"));
//	System.out.println("+++"+text.getText());
	
	List<WebElement> radioB = driver.findElements(By.xpath("//input[@type='radio']"));
	System.out.println("+++"+radioB.size());
	
	WebElement link = driver.findElement(By.partialLinkText("Partial"));
	System.out.println("my text"+link.getText());
	
}
}
