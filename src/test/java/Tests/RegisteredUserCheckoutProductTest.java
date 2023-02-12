package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OrderCompletedPage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import Pages.UserRegistrationPage;

public class RegisteredUserCheckoutProductTest extends TestBase {
	
	/*
	 * 1- Register User
	 * 2- Search for a Product
	 * 3- Add To Cart
	 * 4- checkout
	 * 5- Logout
	 * */
	
	HomePage homepageObject ;
	UserRegistrationPage registerobject ;
	LoginPage loginobject ;
	String ProductName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	ShoppingCartPage cartObject ;
	CheckoutPage checkoutObject ;
	//String Country ;
	String city = "cairo";
	String address = "address";
	String ZipPostal = "12345";
	String phone = "0100123123" ;
	//String state  ;
	 OrderCompletedPage ordercompletedObject ;
	
	@Test (priority = 1)
	public void UserCanRegisterSuccessfully ()
	{

		homepageObject = new HomePage(driver);
		homepageObject.openRegistartionPage();
		
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration("Marwa", "Adel", "marwa.e3@test.com", "12341234");
		Assert.assertTrue(registerobject.successmsg.getText().contains("Your registration completed"));
	}
	
	@Test (priority = 2)
	public void UserCanSaerchwithAutoSuggest ()
	{
		searchObject = new SearchPage(driver);
		searchObject.SearchProductsUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.Productnamebreadcrumb.getText().equalsIgnoreCase(ProductName));
	}
	
	@Test (priority = 3)
	public void UserCanAddProductToCart ()
	{
		detailsObject = new ProductDetailsPage (driver) ;
		detailsObject.AddToCart();
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		cartObject = new ShoppingCartPage(driver) ;
		Assert.assertTrue(cartObject.ProductNameCell.isDisplayed());
	}
	
	@Test (priority = 4)
	public void UsercanCheckoutCartProduct ()
	{
		cartObject = new ShoppingCartPage(driver) ;
		cartObject.OpenCheckoutProductscreen();
		driver.navigate().to("https://demo.nopcommerce.com/onepagecheckout#opc-billing");
		checkoutObject = new CheckoutPage(driver) ;
		checkoutObject.ConfirmOrderData(city , address , ZipPostal , phone);
		driver.navigate().to("https://demo.nopcommerce.com/checkout/completed") ;
		ordercompletedObject = new OrderCompletedPage(driver) ;
		Assert.assertTrue(ordercompletedObject.ThnqLabl.isDisplayed());
	}
	
	@Test (priority = 5)
	public void RegisteredUserCanLogout ()
	{
		registerobject.UserLogout();
	}
}
