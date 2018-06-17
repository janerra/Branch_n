package Table;

import java.text.ParseException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import crossBrowsers.TestConstants1;

public class Select_element {
	

public static void main(String[] args) throws ParseException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", TestConstants1.CHROME_PATH);
		driver = new ChromeDriver();
		
		//driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		WebElement we = driver.findElement(By.xpath("//select[@name='country']"));
		Select selecte = new Select(we);
		List<WebElement> options = selecte.getOptions();
		System.out.println(options.size());
		System.out.println("****"+options.get(263).getText());
		int ran = new Random().nextInt(263);
		System.out.println(ran);
		try {
		
		selecte.selectByIndex(ran);
		} catch (Exception e) {
			
		}
}
}