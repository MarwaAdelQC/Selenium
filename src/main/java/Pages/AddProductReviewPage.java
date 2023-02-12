package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductReviewPage extends PageBase {

	public AddProductReviewPage(WebDriver driver) {
		super(driver);
		
		
		
	}
	
	@FindBy (id = "AddProductReview_Title")
	WebElement ReviewTitleTxt ;
	
	@FindBy (id = "AddProductReview_ReviewText")
	WebElement ReviewTextTxt ;
	
	@FindBy (id = "addproductrating_4")
	WebElement Rating4Radio ;
	
	@FindBy (css = "button.button-1.write-product-review-button")
	public WebElement SubmitReviewBtn ;
	

	public void AddProductReview (String reviewTitle , String reviewText) 
	{
		settextElementtext(ReviewTitleTxt, reviewTitle );
		settextElementtext(ReviewTextTxt, reviewText );
		clickbutton(Rating4Radio);
		clickbutton(SubmitReviewBtn);
		
	}
	
	

}


