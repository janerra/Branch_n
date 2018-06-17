package Table;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import crossBrowsers.TestConstants1;

public class PracticeClass {
WebDriver driver;
	
	@BeforeClass 
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", TestConstants1.CHROME_PATH);
		
		driver = new ChromeDriver();
		//driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://toolsqa.com/automation-practice-form/");
	}
	@Test
	public void TestPr() {
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Maria");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Arianne");
		
		driver.findElement(By.id("sex-1")).click();
		
		driver.findElement(By.id("exp-4")).click();
		
		driver.findElement(By.id("photo")).sendKeys("C:\\temp\\111.pdf");
		
		Select sel1 = new Select(driver.findElement(By.cssSelector("#selenium_commands")));
		
		sel1.selectByVisibleText("Wait Commands");
		sel1.selectByVisibleText("Navigation Commands");
		
		driver.findElement(By.linkText("Link Test")).click();
		
		List<WebElement> tcity = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//td[2]"));
		
		for(WebElement  we : tcity) {
			System.out.print(we.getText());
		}
		System.out.println("****************");
		
		//table[@class='tsc_table_s13']//tr[3]/td[3]
		System.out.println(driver.findElement(By.xpath("//table[@class='tsc_table_s13']//tr[3]/td[3]")).getText());
		
		List<WebElement> trows = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tr"));

        System.out.println(trows.size());
        
        for(WebElement we : trows) {
        	System.out.println(we.getText());
        }
	}
		
	
}
