package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class WishlistPage extends PageBase {

	public WishlistPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy (css = "h1")
	public WebElement WishlistHeader ;
	
	@FindBy (css = "td.product")
	public WebElement ProductNameCell ;
	
	@FindBy (id = "updatecart")
	public WebElement UpdateWishlistBtn ;
	
	@FindBy (css = "td.remove-from-cart")
	public WebElement RemoveFromWishlistBtn ;
	
	@FindBy (css = "div.no-data")
	public WebElement noDataLbl ;
	
	public void RemoveProductFromWishlist ()
	{
		clickbutton(RemoveFromWishlistBtn);
	}
	
	
	
	
}
