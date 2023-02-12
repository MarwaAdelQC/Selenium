package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegistrationTestwithJavaFaker extends TestBase 
{

	HomePage homepageObject ;
	UserRegistrationPage registerobject ;
	LoginPage loginobject ;
	Faker fakeData = new Faker() ;
	String firstname = fakeData.name().firstName() ;
	String lastname = fakeData.name().lastName() ;
	String email = fakeData.internet().emailAddress() ;
	String password = fakeData.number().digits(8).toString() ;
	
	@Test
	public void UserCanRegisterSuccessfully ()
	{

		homepageObject = new HomePage(driver);
		homepageObject.openRegistartionPage();
		
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration(firstname,lastname,email,password);
		Assert.assertTrue(registerobject.successmsg.getText().contains("Your registration completed"));
		homepageObject.openLoginPage();
		loginobject = new LoginPage (driver);
		loginobject.UserLigon(email,password);
		//Assert.assertTrue(registerobject.LogoutLink.isDisplayed());
	Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
	registerobject.UserLogout();
	}
	
	
	

}

