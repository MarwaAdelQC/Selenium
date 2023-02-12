package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase 
{

	HomePage homepageObject ;
	UserRegistrationPage registerobject ;
	LoginPage loginobject ;
	
	@Test (priority = 1)
	public void UserCanRegisterSuccessfully ()
	{

		homepageObject = new HomePage(driver);
		homepageObject.openRegistartionPage();
		
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration("Marwa", "Adel", "marwa.adelf@test.com", "12341234");
		Assert.assertTrue(registerobject.successmsg.getText().contains("Your registration completed"));
	}
	
	@Test (priority = 2)
	public void RegisteredUserCanLogout ()
	{
		registerobject.UserLogout();
	}
	
	@Test (priority = 3)
	public void RegisteredUserCanLLogin ()
	{
		homepageObject.openLoginPage();
		loginobject = new LoginPage (driver);
		loginobject.UserLigon("marwa.adelf@test.com", "12341234");
		//Assert.assertTrue(registerobject.LogoutLink.isDisplayed());
	Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		
	}
	@Test (priority = 4)
	public void RegisteredUserCanLogoutAgain ()
	{
		registerobject.UserLogout();
	}
	

}

