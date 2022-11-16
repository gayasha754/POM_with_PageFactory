package TestCase;

import static org.testng.Assert.assertEquals;

import java.io.InputStream;
import java.time.Duration;

import org.json.JSONObject;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Base.BaseTest;
import Utils.Jsondata;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTestCase extends BaseTest {
	HomePage homePage;
	RegisterPage regPage;
	
	InputStream data;
	JSONObject testData;
	
	Jsondata js = new Jsondata();

	//Test Case for Registering an existing User.
	@Test(priority=1)
	public void testExistingInputFields() throws Exception{
		testData = js.json("testData/Register.json");
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.clickRegisterBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		regPage = PageFactory.initElements(driver, RegisterPage.class);
		regPage.enterUsername(testData.getJSONObject("ExistingUser").getString("username")).
				enterFirstname(testData.getJSONObject("ExistingUser").getString("firstname")).
				enterLastname(testData.getJSONObject("ExistingUser").getString("lastname")).
				enterPassword(testData.getJSONObject("ExistingUser").getString("password")).
				enterPasswordConfirm(testData.getJSONObject("ExistingUser").getString("passwordConfirm")).
				clickRegisterButton();
			
		String actual = regPage.getAlertMessage();
	    String expected ="UsernameExistsException: User already exists";
	    assertEquals(expected,actual);

	}	
	
	//Test Case for Registering a new User.
	@Test(priority=2)
	public void newUserRegisterTest() throws Exception {
		testData = js.json("testData/Register.json");
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickRegisterBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		regPage = PageFactory.initElements(driver, RegisterPage.class);
		String username = regPage.randomUsername();
		regPage.enterUsername(username).
				enterFirstname(testData.getJSONObject("NewUser").getString("firstname")).
				enterLastname(testData.getJSONObject("NewUser").getString("lastname")).
				enterPassword(testData.getJSONObject("NewUser").getString("password")).
				enterPasswordConfirm(testData.getJSONObject("NewUser").getString("passwordConfirm")).
				clickRegisterButton();
		
		String actual = regPage.getAlertMessage();
        String expected = "Registration is successful";
        assertEquals(expected,actual);
        
        //Checking whether the newlyRegistered user can Login.
        homePage.enterUsername(username).
				enterPassword(testData.getJSONObject("NewUser").getString("password")).
				clickLoginBtn();
        actual = homePage.getLogoutText();
        expected = "Logout";
        assertEquals(expected,actual);
        homePage.clickNavBarlogo();
        homePage.clickPopularMake();
        
		//homePage.clickLogoutButton();
	}
	
	
	
}
