import java.util.concurrent.TimeUnit;


import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_1_SORT_TEST {
	/*
	 * 1. Go to website https://en.wikipedia.org/wiki/2016_Summer_Olympics. 
	 * 2. Verify that by default the Medal table is sorted by rank. To do that you need
	 * to capture all the cells in the Rank column and check if they are in
	 * ascending order (highlighted in the picture). 
	 * 3. Click link NOC. 
	 * 4. Now verify that the table is now sorted by the country names. To do that you need
	 * to capture all the names in the NOC column and check if they are in
	 * ascending/alphabetical order (highlighted in the picture). 
	 * 5. Verify that Rank column is not in ascending order anymore.
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
	public void test() throws InterruptedException {
		List<WebElement> unsortedElements = driver.findElements(
				By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tr/td[1]"));
		unsortedElements.remove(unsortedElements.size() - 1);
		List<Integer> unsortedList = new ArrayList<>();
		List<Integer> sortedList = new ArrayList<>();
		for (WebElement we : unsortedElements) {
			unsortedList.add(Integer.parseInt(we.getText()));
			sortedList.add(Integer.parseInt(we.getText()));
			// System.out.println(we.getText());
		}
		Collections.sort(sortedList);

		// 2. Verify that by default the Medal table is sorted by rank.
		Assert.assertEquals(unsortedList, sortedList);
		// Collections.sort(sortedList,(a,b) -> a.compareTo(b));

		// click NOC
		driver.findElement(
				By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//th[.='NOC']"))
				.click();
		// 4. Now verify that the table is now sorted by the country names.
		// find elements in Country column
		List<WebElement> countryWE = driver.findElements(
				By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr/th"));

		List<String> countries_unsorted = new ArrayList<>();
		List<String> countries_sorted = new ArrayList<>();
		for (WebElement we : countryWE) {
			countries_unsorted.add(we.getText());
			countries_sorted.add(we.getText());
		}
		Collections.sort(countries_sorted);

		Assert.assertEquals(countries_sorted, countries_unsorted);

		// 5. Verify that Rank column is not in ascending order anymore.
	
	List<WebElement> unsortedRanksWE = driver.findElements(
			By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tr/td[1]"));
	
	unsortedRanksWE.remove(unsortedRanksWE.size() - 1);
	List<Integer> unsortedRanks = new ArrayList<>();
	List<Integer> sortedRanks = new ArrayList<>();
	for (WebElement we : unsortedRanksWE) {
		unsortedRanks.add(Integer.parseInt(we.getText()));
		sortedRanks.add(Integer.parseInt(we.getText()));
		// System.out.println(we.getText());
	}
	Collections.sort(sortedRanks);
	Assert.assertNotEquals(sortedRanks, unsortedRanks);
	
	//---------------------
	}	
	
}
	
	

		




