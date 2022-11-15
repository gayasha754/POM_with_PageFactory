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

public class LoginTestCase extends BaseTest{
	
	InputStream data;
	JSONObject testData;
	
	Jsondata js = new Jsondata();
	

	//TestCase for invalidUsername and Valid Password
	@Test(priority=1)
	public void invalidUsernameValidPasswordLoginTest() throws Exception {
		testData = js.json("testData/login.json");

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterUsername(testData.getJSONObject("invalidUsername_ValidPassword").getString("username")).
				enterPassword(testData.getJSONObject("invalidUsername_ValidPassword").getString("password")).
				clickLoginBtn();		//using builder pattern
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));		
		String actual = homePage.invalidLoginMsg();
        String expected = "Invalid username/password";
        assertEquals(expected,actual);
	}
	
	//Test Case for Valid Username and Invalid Password
	@Test(priority=2)
	public void validUsernameInvalidPasswordLoginTest() throws Exception {
		testData = js.json("testData/login.json");

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterUsername(testData.getJSONObject("validUsername_InvalidPassword").getString("username")).
				enterPassword(testData.getJSONObject("validUsername_InvalidPassword").getString("password")).
				clickLoginBtn();		//using builder pattern	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));		
		String actual = homePage.invalidLoginMsg();
        String expected = "Invalid username/password";
        assertEquals(expected,actual);
	}
	
	//Test Case for Invalid Username and Invalid Password
	@Test(priority=3)
	public void invalidUsernameInvalidPasswordLoginTest() throws Exception {
		testData = js.json("testData/login.json");

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterUsername(testData.getJSONObject("invalidUsername_InvalidPassword").getString("username")).
				enterPassword(testData.getJSONObject("invalidUsername_InvalidPassword").getString("password")).
				clickLoginBtn();		//using builder pattern	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));		
		String actual = homePage.invalidLoginMsg();
        String expected = "Invalid username/password";
        assertEquals(expected,actual);
	}
	
	//Test Case for Valid Username and Valid Password
	@Test(priority=4)
	public void ValidloginTest() throws Exception{
		testData = js.json("testData/login.json");

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterUsername(testData.getJSONObject("validUsername_ValidPassword").getString("username"))
				.enterPassword(testData.getJSONObject("validUsername_ValidPassword").getString("password"))
				.clickLoginBtn();		//using builder pattern
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		String actual = homePage.getLogoutText();
        String expected = "Logout";
        assertEquals(expected,actual);
		homePage.clickLogoutButton();
	}
}
