package Table;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import crossBrowsers.TestConstants1;

public class AmazonSearch {

WebDriver driver;
	
	@BeforeClass 
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", TestConstants1.CHROME_PATH);
		
		driver = new ChromeDriver();
		//driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com");
	}
	
	@Test
	public void searchTest() {
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Wooden Spoon" + Keys.ENTER);
		
		List<WebElement> lw = driver.findElements(By.xpath("//h2[@class='a-size-base s-inline  s-access-title  a-text-normal']"));
		
		System.out.println("***"+lw.size());
		
		lw.get(3).click();
		
		driver.findElement(By.cssSelector("input#add-to-cart-button")).click();
		
		driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']")).click();
	}
}
