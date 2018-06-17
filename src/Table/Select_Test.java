package Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import crossBrowsers.TestConstants1;

public class Select_Test {
WebDriver driver;
	
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", TestConstants1.CHROME_PATH);
		driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test 
	public void test()  {
		Select sel = new Select(driver.findElement(By.cssSelector("#selenium_commands")));
		List<WebElement>  l = sel.getOptions();
		List<String> options = new ArrayList<>();
		for (WebElement we : l) {
			options.add(we.getText());
		}
		int random = (new Random().nextInt(options.size())) -1;
		System.out.println(random);
		sel.selectByIndex(random);
		System.out.println(options.get(random));
		
		
		System.out.println();
	}
}
