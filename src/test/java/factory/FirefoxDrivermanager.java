package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDrivermanager implements DriverManagerInterface{

	private WebDriver driver;
	
	//couldn't override
	public void createDriver() {
		
		WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
//couldn't override
	public void quitDriver() {
		//Quitting the driver
		driver.quit();
	}

}
