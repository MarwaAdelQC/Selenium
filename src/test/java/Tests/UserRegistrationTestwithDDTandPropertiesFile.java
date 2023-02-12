package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Data.loadProperties;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegistrationTestwithDDTandPropertiesFile extends TestBase 
{

	HomePage homepageObject ;
	UserRegistrationPage registerobject ;
	LoginPage loginobject ;
	String fn = loadProperties.userData.getProperty("fname");
	String ln = loadProperties.userData.getProperty("lname");
	String email = loadProperties.userData.getProperty("email");
	String password = loadProperties.userData.getProperty("password");
	
	@Test (priority = 1)
	public void UserCanRegisterSuccessfully ()
	{

		homepageObject = new HomePage(driver);
		homepageObject.openRegistartionPage();
		
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration(fn,ln,email,password);
		Assert.assertTrue(registerobject.successmsg.getText().contains("Your registration completed"));
		registerobject.UserLogout();
		homepageObject.openLoginPage();
		loginobject = new LoginPage (driver);
		loginobject.UserLigon(email, password);
		//Assert.assertTrue(registerobject.LogoutLink.isDisplayed());
	Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
	registerobject.UserLogout();
	}
	
}

