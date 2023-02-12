package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegistrationPage;

public class MyAccountTest extends TestBase
{


	HomePage homepageObject ;
	UserRegistrationPage registerobject ;
	MyAccountPage myaccountObject ;
	LoginPage loginobject ;
	String oldPassword = "12341234" ;
	String newPassword = "123456789" ;
	String Fitstname ="Marwa";
	String Lastname = "Adel" ;
	String Email ="marwa.adely@test.com";
			
	
	@Test (priority = 1)
	public void UserCanRegisterSuccessfully ()
	{

		homepageObject = new HomePage(driver);
		homepageObject.openRegistartionPage();
		
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration(Fitstname , Lastname , Email , oldPassword);
		Assert.assertTrue(registerobject.successmsg.getText().contains("Your registration completed"));
	}
	
	@Test (priority = 2)
	public void RegisteredUserCanChangePassword () 
	{
		myaccountObject = new MyAccountPage(driver) ;
		myaccountObject.OpenMyAccPage();
		myaccountObject.OpenChangePasswordPage();
		myaccountObject.changePassword(oldPassword, newPassword);
		Assert.assertTrue(myaccountObject.ResultMsgLbl.getText().contains("Password was changed"));
		myaccountObject.CloseBar();
	}
	
	
	@Test (priority = 3)
	public void RegisteredUserCanLogout ()
	{
		registerobject.UserLogout();
	}
	
	@Test (priority = 4)
	public void RegisteredUserCanLLogin ()
	{
		homepageObject.openLoginPage();
		loginobject = new LoginPage (driver);
		loginobject.UserLigon(Email, newPassword);
		//Assert.assertTrue(registerobject.LogoutLink.isDisplayed());
	Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		
	}
	
}
