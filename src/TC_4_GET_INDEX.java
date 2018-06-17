import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_4_GET_INDEX {
/*
1. Go to website https://en.wikipedia.org/wiki/2016_Summer_Olympics.
2. Print the row number and the column number of Japan.
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
    	 
    	 //column Countries
    	 List<WebElement> countryWE = driver.findElements(
 				By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr/th"));
    	 
    	 String country = "Japan";
    	 for (int i = 0; i < countryWE.size(); i++) {
			if(countryWE.get(i).getText().contains(country)) {
				System.out.println("****************");
				System.out.println("For the country: "+country);
				System.out.println("The row number is: "+(i+1));
				System.out.println("The column number is: 2");
				System.out.println("****************");
				break;
		}
	}

   System.out.println(driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[6]/th/a")).getText());
    	 
     }
	
}
