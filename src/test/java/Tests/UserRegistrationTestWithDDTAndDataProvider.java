package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndDataProvider extends TestBase 
{

	HomePage homepageObject ;
	UserRegistrationPage registerobject ;
	LoginPage loginobject ;
	
	
	
	@DataProvider (name = "testData")
	public static Object [][] userData ()
	{
		return new Object [][] {
				{
					"Hamza","Ahmed","hamza2@ahmed.com","12345678"
				},
				{
					"Rima","Ahmed","rima2@ahmed.com","12345678"
				}
		};
	}
	
	
	@Test (priority = 1, dataProvider = "testData")
	public void UserCanRegisterSuccessfully (String fname , String lname , String email , String password)
	{

		homepageObject = new HomePage(driver);
		homepageObject.openRegistartionPage();
		
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration(fname ,lname , email , password);
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

