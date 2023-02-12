package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderCompletedPage extends PageBase {

	public OrderCompletedPage(WebDriver driver) {
		super(driver);
	}
  
	@FindBy (css = "h1")
	public WebElement ThnqLabl ;
	
	@FindBy (css = "div.details-link")
	WebElement detailsLink ;
	
	public void OpenOrderDetailsscreen ()
	{
		clickbutton(detailsLink);
	}
	
	
}


