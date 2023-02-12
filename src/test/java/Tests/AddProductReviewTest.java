package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AddProductReviewPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ReviewsScreen;
import Pages.SearchPage;
import Pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase {
	/*
	 * 1- UserRegistration
	 * 2- Search Product
	 * 3- AddProductReview
	 * 4- Logout 
	 * */
	
	HomePage homepageObject;
	UserRegistrationPage registerobject;
	LoginPage LoginObject ;
	String ProductName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	AddProductReviewPage ReviewObject ;
	ReviewsScreen ReviewscreenObject ;


	
	//1- User Registration
	@Test (priority = 1)
	public void UserCanRegisterSuccessfully ()
	{

		HomePage homepageObject = new HomePage(driver);
		homepageObject.openRegistartionPage();
		
		UserRegistrationPage registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration("Marwa", "Adel", "marwa.a3@test.com", "12341234");
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
	
	//3- AddProductReview
	@Test (priority = 3)
	public void UserAddProductReview ()
	{
		ProductDetailsPage detailsObject = new ProductDetailsPage(driver);
		detailsObject.OpenAddProductReviewscreen();;
		ReviewObject = new AddProductReviewPage(driver);
		ReviewObject.AddProductReview("test", "test");
		ReviewscreenObject = new ReviewsScreen(driver);
		Assert.assertTrue(ReviewscreenObject.SuccessReviewLbl.getText().equalsIgnoreCase("Product review is successfully added."));
		
		
	}
	
	
	
	// 4- User Logout
	@Test (priority = 4)
	public void RegisteredUserCanLogout ()
	{
		UserRegistrationPage registerobject = new UserRegistrationPage(driver);
		registerobject.UserLogout();
	}

	
	

}
