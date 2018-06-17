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

public class TC_5_GET_SUM {
	/*
1. Go to website https://en.wikipedia.org/wiki/2016_Summer_Olympics.
2. Print the names of two countries whose sum of bronze medals is 18.
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
    	 
    	 // column Bronze 
    	
    	 List<WebElement> bronzeColWE = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//td[4]")); 
    	 
    	 List<Integer> bronzeMedal = new ArrayList<>();
    	 
    	 for (int i = 0; i < bronzeColWE.size(); i++) {
     		int numberOfBronze = Integer.parseInt(bronzeColWE.get(i).getText());
     		bronzeMedal.add(numberOfBronze);
    	 }
    	 bronzeMedal.remove(bronzeMedal.size() - 1);
    	 System.out.println(bronzeMedal);
    	 
    	 int index_1_country = -1;
    	 int index_2_country = -1;
    	 int bronzeMedal_1_country = -1;
    	 int bronzeMedal_2_country = -1;
    	 
    	 for (int i = 0; i < (bronzeMedal.size() - 1); i++) {
    		 for(int j = 0; j < (bronzeMedal.size()); j++) {
    			 if((bronzeMedal.get(i) + bronzeMedal.get(j)) == 18) {
    				 index_1_country = i;
    				 index_2_country = j;
    				 bronzeMedal_1_country = bronzeMedal.get(i);
    				 bronzeMedal_2_country = bronzeMedal.get(j);
    				 
    			 }
    		 }
			
		}
    	 
    	 //System.out.println(index_1_country+" "+ index_2_country);
    	 
    	//column Countries
    	 List<WebElement> countryWE = driver.findElements(
 				By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr/th"));
    	 
    	 System.out.println("************************");
    	 System.out.println("Countries with sum of bronze medals = 18: ");
    	 System.out.println("1. "+countryWE.get(index_1_country).getText()+" has "+bronzeMedal_1_country+ " bronze medals. " );
    	 System.out.println("2. "+countryWE.get(index_2_country).getText()+" has "+bronzeMedal_2_country+ " bronze medals. " );
     }
}
