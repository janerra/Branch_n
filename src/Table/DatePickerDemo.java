package Table;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import crossBrowsers.TestConstants1;

public class DatePickerDemo {

	public static void main(String[] args) throws ParseException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", TestConstants1.CHROME_PATH);
		driver = new ChromeDriver();
		
		//driver.manage().window().maximize();
		driver.get("https://money.rediff.com/gainers/bse/daily");
		driver.findElements(By.className("dataTable"));
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='dataTable']//th"));
		System.out.println(cols.size());
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']//tr"));
		System.out.println(rows.size());
		
		List<WebElement> col3 = driver.findElements(By.xpath("//table[@class='dataTable']//td[3]"));
		
		String maxt = "";
		double max = 0;
		for(int i = 1; i < col3.size()-1; i++) {
			//System.out.println(col3.get(i).getText());
			
			maxt = col3.get(i).getText();
			NumberFormat f = NumberFormat.getNumberInstance();
			Number num = f.parse(maxt);
			//System.out.println(max);
			double temp =Double.parseDouble(num.toString());
			if (temp > max) {
				max = temp;
			}
		}
		
		System.out.println("max" + max);
	}

}
