package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	String smallquantity ;
	
	@FindBy (linkText = "Apple MacBook Pro 13-inch")
	public WebElement ProductNameCell ;
	
	@FindBy (id = "updatecart")
	public WebElement UpdateCartBtn ;
	
	@FindBy (css = "button.remove-btn")
	public WebElement RemoveBtn ;
	
	@FindBy (css = "input.qty-input")
	public WebElement QntyTxt ;
	
	@FindBy (css = "span.product-subtotal")
	WebElement TotalLbl ;
	
	@FindBy (css = "div.message-error")
	public WebElement QuantityError ;
	
	@FindBy (css = "div.no-data")
	public WebElement noDataLbl ;
	
	@FindBy (id = "checkout")
	public WebElement checkOutBtn ;
	
	@FindBy (id = "termsofservice")
	public WebElement Agreecheckbox ;
	
	public void RemoveProductFromCart ()
	{
		clickbutton(RemoveBtn);
	}
	
	public void ChangeQuantity (String quantity)
	{
	    ClearElement(QntyTxt);
		settextElementtext(QntyTxt, quantity);
		clickbutton(UpdateCartBtn);
	}
	
	public void ChangeQuantityto1 (String smallquantity)
	{
	    ClearElement(QntyTxt);
		settextElementtext(QntyTxt, smallquantity);
		clickbutton(UpdateCartBtn);
	}

	public void OpenCheckoutProductscreen ()
	{
		clickbutton(Agreecheckbox);
		clickbutton(checkOutBtn);
	}
	
}
