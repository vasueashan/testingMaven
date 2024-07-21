package BaseFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseFactotyPage {

	public static WebDriver driver = null;
	public static WebDriver getDriver() {
		String driverPath = System.getProperty("user.dir") + "\\testingMaven\\Drivers\\chromedriver.exe";
		System.getProperty("webdriver.chrome.driver", driverPath);
		 driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void closeDriver()
	{
		driver.quit();
	}
}
