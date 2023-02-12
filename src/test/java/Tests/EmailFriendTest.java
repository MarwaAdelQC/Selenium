package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.EmailPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {
	

	
	
	HomePage homepageObject;
	UserRegistrationPage registerobject;
	LoginPage LoginObject ;
	String ProductName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	EmailPage EmailObject ;


	
	//1- User Registration
	@Test (priority = 1)
	public void UserCanRegisterSuccessfully ()
	{

		HomePage homepageObject = new HomePage(driver);
		homepageObject.openRegistartionPage();
		
		UserRegistrationPage registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration("Marwa", "Adel", "marwa.d3@test.com", "12341234");
		Assert.assertTrue(registerobject.successmsg.getText().contains("Your registration completed"));
	}
	
	//2- Search for a Product
	@Test (priority = 2)
	public void UserCanSaerchwithAutoSuggest ()
	{
		SearchPage searchObject = new SearchPage(driver);
		searchObject.SearchProductsUsingAutoSuggest("MacB");
		ProductDetailsPage detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.Productnamebreadcrumb.getText().equalsIgnoreCase(ProductName));
	}
	
	//3- Send Email
	@Test (priority = 3)
	public void UserCanSendEmailToFriend ()
	{
		ProductDetailsPage detailsObject = new ProductDetailsPage(driver);
		detailsObject.OpenEmailFriendscreen();
		EmailObject = new EmailPage(driver);
		EmailObject.SendEmailToFriend("aa@mm.com", "test message");
		Assert.assertTrue(EmailObject.SuccessMsg.getText().equalsIgnoreCase("Your message has been sent."));
		
	}
	
	
	
	// 4- User Logout
	@Test (priority = 4)
	public void RegisteredUserCanLogout ()
	{
		UserRegistrationPage registerobject = new UserRegistrationPage(driver);
		registerobject.UserLogout();
	}

}
