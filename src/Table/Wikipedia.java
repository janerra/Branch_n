package Table;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import crossBrowsers.TestConstants1;

public class Wikipedia {
 WebDriver driver;
 
 @BeforeClass
 public void setup() {
	 System.setProperty("webdriver.chrome.driver",  TestConstants1.CHROME_PATH) ;
	 driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 }	 
 @Test
 public void Test() {
		 driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
		 //create new builder action - for new branch
		 Actions builder = new Actions(driver);
		 WebElement from = driver.findElement(By.xpath("//*[@id=\"treebox1\"]/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
		 WebElement to = driver.findElement(By.xpath("//*[@id=\"treebox2\"]/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
		 
		 try {
	 Thread.sleep(20);
		 builder.moveToElement(from).clickAndHold(from).moveToElement(to).release(to).build().perform();
		 //actions.dragAndDrop(en,input).perform();
		 } catch(Exception e) {
			 System.out.println(e);
		 }
	 }
	 
	  
 }


