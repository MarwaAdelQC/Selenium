package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import Pages.UserRegistrationPage;

public class AddProductToShoppingCartTest extends TestBase 
{
	HomePage homepageObject ;
	UserRegistrationPage registerobject ;
	LoginPage loginobject ;
	ProductDetailsPage detailsObject ;
	String ProductName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject ;
	ShoppingCartPage cartObject ;
	String smallquantity = "1";
	
	@Test (priority = 1)
	public void UserCanRegisterSuccessfully ()
	{

		homepageObject = new HomePage(driver);
		homepageObject.openRegistartionPage();
		
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration("Marwa", "Adel", "marwa.b@test.com", "12341234");
		Assert.assertTrue(registerobject.successmsg.getText().contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void UserCanSaerchwithAutoSuggest ()
	{
		searchObject = new SearchPage(driver);
		searchObject.SearchProductsUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.Productnamebreadcrumb.getText().equalsIgnoreCase(ProductName));
	}
	
	
	@Test (priority = 3)
	public void UserCanAddProductToCart () throws InterruptedException
	{
		detailsObject = new ProductDetailsPage (driver) ;
		detailsObject.AddToCart();
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		cartObject = new ShoppingCartPage(driver) ;
		Assert.assertTrue(cartObject.ProductNameCell.isDisplayed());
		Thread.sleep(1000);
	}
	
	@Test (priority = 4)
	public void CheckMinQuatityIsTwo ()
	{
		cartObject = new ShoppingCartPage(driver) ;
		cartObject.ChangeQuantityto1(smallquantity);
		Assert.assertTrue(cartObject.QuantityError.isDisplayed());
		
	}
	
	@Test (priority = 5)
	public void RemoveProductFromCart ()
	{
		cartObject = new ShoppingCartPage(driver) ;
		cartObject.RemoveProductFromCart();
		Assert.assertTrue(cartObject.noDataLbl.isDisplayed());
	}
	
	

}
