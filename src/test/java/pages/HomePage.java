package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Base.BasePage;

public class HomePage extends BasePage{
	
	
	//overridden method of initializing the webDriver
		public HomePage(WebDriver driver) {
			super(driver);
		}

	//Assigning the elements of Home Page into variables
	
	@FindBy(how = How.XPATH, using="//input[@placeholder='Login']")
	WebElement txtUsername;
	
	@FindBy(how = How.XPATH, using="//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using="//button[normalize-space()='Login']")
	WebElement btnLogin;
	
	@FindBy(how = How.XPATH, using="//span[@class='label label-warning']")
	WebElement errorMsg;
	
	@FindBy(how = How.XPATH, using="//a[normalize-space()='Logout']")
	WebElement btnLogout;
	
	@FindBy(how = How.XPATH, using="//a[normalize-space()='Register']")
	WebElement btnRegister;
	
	@FindBy(how = How.XPATH, using="//div[@class='row']//div[1]//div[1]//a[1]")
	WebElement btnPopularMakeLink;
	
	@FindBy(how = How.XPATH, using="//a[normalize-space()='Buggy Rating']")
	WebElement logo;
	
	
	//returning the action of entering the username
	public HomePage enterUsername(String username) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
		return this;
	}
	
	//returning the action of entering the password
	public HomePage enterPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
		return this;
	}
	
	//returning the action of clicking Login Btn
	public HomePage clickLoginBtn() {
		btnLogin.sendKeys(Keys.RETURN);
		return this;
	}
	
	//getting the text of the Logout button in order to do the assertion of invalidLogin
	public String getLogoutText() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		Boolean result = btnLogout.isDisplayed();
        String alertMessage = null;
       
        if(result){
            alertMessage =btnLogout.getText();
        }
        return alertMessage;	
	}
	
	//getting the error message text 
	public String invalidLoginMsg() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		Boolean result = errorMsg.isDisplayed();
        String alertMessage = null;
       
        if(result){
            alertMessage = errorMsg.getText();
        }
        return alertMessage;	
	}
	
	//returning the action of clicking Logout btn
	public HomePage clickLogoutButton(){
		btnLogout.sendKeys(Keys.RETURN);
		return this;
	}
	
	//returning the action of clicking Ragister btn
	public RegisterPage clickRegisterBtn() {
		btnRegister.sendKeys(Keys.RETURN);
		return new RegisterPage(driver);
	}
	
	//returning the action of clicking on popular make image
	public HomePage clickPopularMake() {
		btnPopularMakeLink.sendKeys(Keys.RETURN);
		return this;
	}
	
	//returning the action of clicking Logo 
	public HomePage clickNavBarlogo() {
		logo.sendKeys(Keys.RETURN);
		return this;
	}
	
}
