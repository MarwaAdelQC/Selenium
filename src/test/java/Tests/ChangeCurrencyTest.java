package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;


public class ChangeCurrencyTest extends TestBase 
{

	HomePage homeObject ;
	ProductDetailsPage detailsObject ;
	String ProductName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject ;

	
	@Test (priority = 1)
	public void UserCanChangeCurrency ()
	{
		homeObject = new HomePage(driver) ;
		homeObject.ChangeCurrrency();
		detailsObject = new ProductDetailsPage(driver);
		
	}
	
	@Test (priority = 2)
	public void UserCanSaerchwithAutoSuggest ()
	{
		searchObject = new SearchPage(driver);
		searchObject.SearchProductsUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.Productnamebreadcrumb.getText().equalsIgnoreCase(ProductName));
		Assert.assertTrue(detailsObject.ProductPrice.getText().contains("€"));
	}
	
}
