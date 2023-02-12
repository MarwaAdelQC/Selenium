package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase {
	
	
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	WishlistPage wishlistObject ;
	String ProductName = "Apple MacBook Pro 13-inch" ;

	@Test (priority = 1)
	public void UserCanSaerchwithAutoSuggest ()
	{
		searchObject = new SearchPage(driver);
		searchObject.SearchProductsUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.Productnamebreadcrumb.getText().equalsIgnoreCase(ProductName));
	}
	
	@Test (priority = 2)
	public void UserCanAddProuctToWishList ()
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductToWishlist();	
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		wishlistObject = new WishlistPage (driver);
		Assert.assertTrue(wishlistObject.WishlistHeader.isDisplayed());
		Assert.assertTrue(wishlistObject.ProductNameCell.getText().contains(ProductName));
	}
	
	@Test (priority = 3)
	public void UserCanRemoveProductFromCart ()
	{
		wishlistObject = new WishlistPage(driver);
		wishlistObject.RemoveProductFromWishlist();
		Assert.assertTrue(wishlistObject.noDataLbl.getText().contains("The wishlist is empty!"));	
		
	}
	

}
