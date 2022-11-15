package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager implements DriverManagerInterface{

	private WebDriver driver;
	
	//couldn't override
	public void createDriver() {
		WebDriverManager.chromedriver().cachePath("Drivers").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	//couldn't override
	public void quitDriver() {
		//Quitting the driver
		driver.quit();
	}

}
