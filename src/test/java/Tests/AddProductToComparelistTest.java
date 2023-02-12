package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CompareProductsPage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;

public class AddProductToComparelistTest extends TestBase {
	
	String FirstProductName = "Apple MacBook Pro 13-inch" ;
	String SecondProductName = "Asus N551JK-XO076H Laptop" ;
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	CompareProductsPage compareObject ;
	
	
	// 1- Search for first product
	// 2- add first product to compare
	//3- search for second product
	// 4- add second product to compare
	// 5- clear the table
	
	@Test (priority = 1)
	public void UserCanSearchwithAutoSuggest ()
	{
		searchObject = new SearchPage(driver);
		searchObject.SearchProductsUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.Productnamebreadcrumb.getText().equalsIgnoreCase(FirstProductName));
	}
	
	@Test (priority = 2)
	public void UserCanAddProductToCompareList ()
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddToCompareList();
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		compareObject = new CompareProductsPage(driver);
		Assert.assertTrue(compareObject.FirstProductName.isDisplayed());
		//compareObject.CompareProducts();
	}
	
	@Test (priority = 3)
	public void UserCanSearchwithAutoSuggest2 ()
	{
		searchObject = new SearchPage(driver);
		searchObject.SearchProductsUsingAutoSuggest("Asus");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.Productnamebreadcrumb.getText().equalsIgnoreCase(SecondProductName));
	}
	@Test (priority = 4)
	public void UserCanAddProductToCompareList2 ()
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddToCompareList();
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		compareObject = new CompareProductsPage(driver);
		Assert.assertTrue(compareObject.SecondProductName.isDisplayed());
		//compareObject.CompareProducts();
	}
	
	
	/*@Test (priority = 5)
	public void UserCanClearTheCompareList ()
	{
		compareObject = new CompareProductsPage(driver);
		compareObject.ClearList();
		Assert.assertTrue(compareObject.NoDataLbl.getText().equalsIgnoreCase("You have no items to compare."));
	}*/
	

}
