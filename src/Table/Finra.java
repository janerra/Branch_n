package Table;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import crossBrowsers.TestConstants1;

public class Finra {
WebDriver driver;
	
	@BeforeClass 
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", TestConstants1.CHROME_PATH);
		
		driver = new ChromeDriver();
		//driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.finra.org/");
	}
	
	@Test
	public void Finra() {
		
		List<WebElement> pic = driver.findElements(By.tagName("i"));
		System.out.println(pic.size());
		
		List<WebElement> icons = driver.findElements(By.xpath("//i[contains(@class, 'icon')]"));
		System.out.println(icons.size());
		
		for(WebElement we : icons) {
			System.out.println("**"+we.getAttribute("class"));
		}
		
		List<WebElement> imgs = driver.findElements(By.tagName("img"));
		System.out.println(imgs.size());
		
		
		
		
	}
}
