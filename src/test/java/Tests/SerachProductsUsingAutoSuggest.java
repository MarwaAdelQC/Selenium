package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailsPage;
import Pages.SearchPage;

public class SerachProductsUsingAutoSuggest extends TestBase {
	
	String ProductName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;

	@Test
	public void UserCanSaerchwithAutoSuggest ()
	{
		searchObject = new SearchPage(driver);
		searchObject.SearchProductsUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.Productnamebreadcrumb.getText().equalsIgnoreCase(ProductName));
	}
	
}

