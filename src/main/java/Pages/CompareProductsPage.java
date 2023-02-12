package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductsPage extends PageBase {

	public CompareProductsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (css = "a.clear-list")
	WebElement ClearListBtn ;
	
	@FindBy (css = "div.no-data")
	public WebElement NoDataLbl ;
	
	@FindBy (css = "table.compare-products-table")
	WebElement Table ;
	
	@FindBy (tagName = "tr")
	List<WebElement> allRows ;
	
	@FindBy (tagName = "td")
	List<WebElement> allCols ;
	
	@FindBy (linkText = "Apple MacBook Pro 13-inch") 
	public WebElement FirstProductName ;
	
	@FindBy (linkText = "Asus N551JK-XO076H Laptop") 
	public WebElement SecondProductName ;
	
	
	
	public void ClearList ()
	{
		clickbutton(ClearListBtn);
	}
	
	public void CompareProducts ()
	{
		//get all rows
		System.out.println(allRows.size());
		
		//get data from each row
		for  (WebElement row : allRows)
	    {
			System.out.println(row.getText() + "\t");
			for (WebElement col : allCols)	
			{
				System.out.println(col.getText() + "\t");
			}
		}
		

	}

}
