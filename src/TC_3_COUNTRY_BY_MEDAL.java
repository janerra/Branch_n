import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_3_COUNTRY_BY_MEDAL {
/*
1. Go to website https://en.wikipedia.org/wiki/2016_Summer_Olympics.
2. Print names of country/countries whose silver medal count is equal to 18.
 */
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_PATH);
		driver = new ChromeDriver();
		driver.get(TestConstants.OLIMPICS_URL);

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
     @Test
     public void test() {
    	 //column 'Silver'
    	 List<WebElement> silverColWE = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//td[3]"));
    	 
    	 int numOfMedals = 18;
    	 System.out.println("*************");
    	 System.out.println("Number of silver medals = "+numOfMedals+" got the countries:");
    	 System.out.println("*************");
    	 
    	 for (int i = 0; i < silverColWE.size(); i++) {
    		int numberOfSilver = Integer.parseInt(silverColWE.get(i).getText());
			if(numberOfSilver == numOfMedals) {
			System.out.println(driver.findElement(By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//td[3])["+i+"]/../th")).getText());
			}
		}
    	 
     }
 }
	
	

