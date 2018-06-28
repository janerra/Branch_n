package crossBrowsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


//import TestConstants1;
// some new staff


public class Parallel_Executing {

	WebDriver driver;
	
	@Test
	@Parameters("browser")
	public void verufyTitle(String browserName) {
	if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", TestConstants1.CHROME_PATH);
		driver = new ChromeDriver();
	} 
	else if (browserName.equalsIgnoreCase("IE")) {
		System.setProperty("webdriver.ie.driver", TestConstants1.IE_PATH);
		driver = new InternetExplorerDriver();
	} else if (browserName.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", TestConstants1.Firefox_PATH);
		driver = new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.get("http://learn-automation.com/");
	System.out.println(driver.getTitle());
	driver.quit();
	
	}
}
