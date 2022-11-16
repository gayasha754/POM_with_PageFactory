package pages;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Base.BasePage;

public class RegisterPage extends BasePage{

	//Assigning the elements of Register Page into variables
	
	@FindBy(how = How.XPATH, using="//input[@id='username']")
	WebElement txtUsername;
	
	@FindBy(how = How.ID, using="firstName")
	WebElement TextInFirstname;
	
	@FindBy(how = How.ID, using="lastName")
	WebElement TextInLastname;
	
	@FindBy(how = How.ID, using="password")
	WebElement TextInPassword;
	
	@FindBy(how = How.ID, using="confirmPassword")
	WebElement TextInPasswordConfirm;
	
	@FindBy(how = How.XPATH, using="//button[contains(@class,'btn btn-default')]")
	WebElement RegisterButton;
	
	@FindBy(how = How.XPATH, using="/html/body/my-app/div/main/my-register/div/div/form/div[6]")
	WebElement alertMsg;

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	//returning the action of entering username
	public RegisterPage enterUsername(String username) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
		return this;
	}
	
	//returning the action of entering first name
	public RegisterPage enterFirstname(String firstname) {
		TextInFirstname.clear();
		TextInFirstname.sendKeys(firstname);
		return this;
	}
	
	//returning the action of entering last name
	public RegisterPage enterLastname(String lastname) {
		TextInLastname.clear();
		TextInLastname.sendKeys(lastname);
		return this;
	}
	
	//returning the action of entering password
	public RegisterPage enterPassword(String password) {
		TextInPassword.clear();
		TextInPassword.sendKeys(password);
		return this;
	}
	
	//returning the action of entering confirm password
	public RegisterPage enterPasswordConfirm(String passwordConfirm) {
		TextInPasswordConfirm.clear();
		TextInPasswordConfirm.sendKeys(passwordConfirm);
		return this;
	}
	
	//returning the action of clicking register btn
	public RegisterPage clickRegisterButton() {
		RegisterButton.sendKeys(Keys.RETURN);
		return this;
	}

	//getting the alert message displayed
	public String getAlertMessage(){
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        Boolean result = alertMsg.isDisplayed();

        String alertMessage = null;
        if(result){
            alertMessage = alertMsg.getText();
        }
         return alertMessage;
     } 

	//Method of creating a random username
	public String randomUsername(){
        
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        String username = generatedString + "@gmail.com";
        return username;
    }
}
