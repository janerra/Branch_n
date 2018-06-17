package Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import crossBrowsers.TestConstants1;

public class Links {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", TestConstants1.CHROME_PATH);
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String underConsTitle = "Under Construction: Mercury Tours";
		
	}
	@Test
	public void test() {
		List<WebElement> links =  driver.findElements(By.tagName("a"));
		String[] linkNames = new String[links.size()];
		System.out.println("links.size() : "+links.size());
		int i = 0;
		for(WebElement we : links) {
			String temp = we.getText();
			linkNames[i] = temp;
			i++;
		}
		System.out.println(Arrays.toString(linkNames));
		
		for (int j=0; j<=linkNames.length; j++) {
			driver.findElement(By.linkText(linkNames[i])).click();
			
			if (driver.getTitle().equals("Under Construction: Mercury Tours")){
				System.out.println(linkNames[i]+" under Construction");
			}  else {
				System.out.println(linkNames[i]+" is working");
			}
		}
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
