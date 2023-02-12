package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	@FindBy (id = "small-searchterms")
	WebElement SearchTxtbox ;

	@FindBy (css = "button.button-1.search-box-button")
	WebElement SearchBtn ;

	@FindBy (id = "ui-id-1")
	public List<WebElement> ProductList ;
	
	@FindBy (linkText = "Apple MacBook Pro 13-inch")
	WebElement ProductTitle ;

	public void ProductsSearch (String ProductName)
	{
		settextElementtext(SearchTxtbox, ProductName);
		clickbutton(SearchBtn);

	}
	
	public void OpenProductDetailsPage ()
	{
		clickbutton(ProductTitle);
	}
	
	public void SearchProductsUsingAutoSuggest (String SearchTxt)
	{
		settextElementtext(SearchTxtbox, SearchTxt);
		ProductList.get(0).click();
		
	}
	
}