package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegistrationTestwithDDTandExcelFile extends TestBase 
{

	HomePage homepageObject ;
	UserRegistrationPage registerobject ;
	LoginPage loginobject ;


	@DataProvider (name = "Excel Data")
	public Object [][] userRegisterData () throws IOException 
	{
		// get data from Excel reader class
		ExcelReader ER = new ExcelReader();
		return ER.GetExcelData();
	}


	@Test (dataProvider = "Excel Data")
	public void UserCanRegisterSuccessfully (String fname , String lname , String email , String password)
	{

		homepageObject = new HomePage(driver);
		homepageObject.openRegistartionPage();

		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration(fname , lname, email , password);
		Assert.assertTrue(registerobject.successmsg.getText().contains("Your registration completed"));
		registerobject.UserLogout();
		homepageObject.openLoginPage();
		loginobject = new LoginPage (driver);
		loginobject.UserLigon(email , password);
		//Assert.assertTrue(registerobject.LogoutLink.isDisplayed());
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		registerobject.UserLogout();
	}








}

