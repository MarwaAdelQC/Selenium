package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (css = "strong.current-item")
	public WebElement Productnamebreadcrumb ;

	@FindBy (css = "button.button-2.email-a-friend-button")
	WebElement SendEmailBtn ;
	
	@FindBy (id = "price-value-4")
	public WebElement ProductPrice ;
	
	@FindBy (linkText = "Add your review")
	public WebElement AddProductReviewLink ;
	
	@FindBy (id = "add-to-wishlist-button-4")
	public WebElement AddToWishlistBtn ;
	
	@FindBy (css = "button.button-2.add-to-compare-list-button")
	public WebElement AddToComparelistBtn ;
	
	@FindBy (id="add-to-cart-button-4")
	WebElement addToCartBtn ;
	
	

	public void OpenEmailFriendscreen() 
	{
		clickbutton(SendEmailBtn);		
	}
	
	public void OpenAddProductReviewscreen ()
	{
	clickbutton(AddProductReviewLink);
	}
	
	public void AddProductToWishlist ()
	{
		clickbutton(AddToWishlistBtn);
	}
	
	public void AddToCompareList ()
	{
		clickbutton(AddToComparelistBtn);
	}
	
	public void AddToCart ()
	{
		clickbutton(addToCartBtn);
	}
	
}


