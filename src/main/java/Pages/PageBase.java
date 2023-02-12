package Pages;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
	public WebDriver driver ;
	public JavascriptExecutor jse ;
	public Select select ;
	public Actions action ;
	
	
	//create constructor
	public PageBase (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	protected static void clickbutton (WebElement button)
	{
		button.click();
	}

	protected static void settextElementtext (WebElement textelement , String value)
	{
		textelement.sendKeys(value);
	}
	
	public void scrollBottom ()
	{
		jse.executeScript("window.scrollBy(0,250)","");
	}
	
	
	public void ClearElement (WebElement element)
	{
		element.clear();
	}
}
