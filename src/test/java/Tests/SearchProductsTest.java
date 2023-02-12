package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailsPage;
import Pages.SearchPage;

public class SearchProductsTest extends TestBase {
	
	String ProductName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	
	
	@Test
	public void UserCanSearchProducts ()
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductsSearch(ProductName);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.OpenProductDetailsPage();
		Assert.assertTrue(detailsObject.Productnamebreadcrumb.getText().equalsIgnoreCase(ProductName));
		//Assert.assertEquals(detailsObject.Productnamebreadcrumb.getText(), ProductName);
	}

}
