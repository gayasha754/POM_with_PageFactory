package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Base.BasePage;

public class PopularMakePage extends BasePage{

	//Assigning the elements of Popular Make Page into variables
	
	
	@FindBy(how = How.XPATH, using="/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/fieldset/textarea")
	WebElement txt_comment;
	@FindBy(how = How.XPATH, using="//button[contains(@class,'btn btn-success')]")
	WebElement btn_Vote;
	@FindBy(how = How.XPATH, using="/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/p")
	WebElement alertMsg;
	@FindBy(how = How.XPATH, using="//a[normalize-space()='Guilia Quadrifoglio']")
	WebElement btnModel;
	
//	private final By txt_comment = By.xpath("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/fieldset/textarea");
//	private final By btn_Vote = By.xpath("//button[contains(@class,'btn btn-success')]"); //here relative xpath is used for vote button   
//	private final By alertMsg = By.xpath("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/p");
//	private final By btnModel = By.xpath("//a[normalize-space()='Guilia Quadrifoglio']");
	
	public PopularMakePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// returning the action of clicking on a model
	public PopularMakePage clickModel() {
		btnModel.sendKeys(Keys.RETURN);
		return this;
	}

	// returning the action of entering a comment
	public PopularMakePage enterComment(String comment) {
		txt_comment.clear();
		txt_comment.sendKeys(comment);
		return this;
	}
	
	// returning the action of clicking on vote btn
	public PopularMakePage clickVoteButton() {
		btn_Vote.sendKeys(Keys.RETURN);
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
}
