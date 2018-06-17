import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_2_MostMostMost {
	/*
	 * 1. Go to website https://en.wikipedia.org/wiki/2016_Summer_Olympics. 
	 * 2. Print the name of the country with the most number of gold medals. 
	 * 3. Print the name of the country with the most number of silver medals. 
	 * 4. Print the name of the country with the most number of bronze medals. 
	 * 5. Print the name of the country with the most number of medals.
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
    	 
    	 String[] medals = {"Gold", "Silver", "Bronze", "Total"};
    	 for (int i = 0; i < medals.length; i++) {
		
    	 driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//th[.='"+medals[i]+"']")).click();
    	 driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//th[.='"+medals[i]+"']")).click();
    	 
    	 System.out.println(driver.findElement(By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr/th)[1]")).getText());
    	 
    	 }
     }
	
	
	
}
