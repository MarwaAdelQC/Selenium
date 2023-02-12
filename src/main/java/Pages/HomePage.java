package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends PageBase 
{

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver ;
		action = new Actions(driver) ;

	}

	@FindBy (linkText = "Register")
	WebElement registerLink ;
	
	@FindBy (linkText = "Log in")
	WebElement LoginLink ;
	
	@FindBy (css = "a.ico-logout")
	public WebElement LogoutLink ;
	
	
	@FindBy (linkText = "Contact us")
	public WebElement ContactUsLink ;
	
	@FindBy (id = "customerCurrency")
	public WebElement CurrencyDDL ;
	
	@FindBy (linkText = "Computers")
	public WebElement ComuptersMenu ;
	
	@FindBy (linkText = "Notebooks")
	public WebElement NotebooksMenu ;
	

	public void openRegistartionPage ()
	{
		//registerLink.click();
		clickbutton(registerLink);
	}

	public void openLoginPage ()
	{
		clickbutton(LoginLink);
	}
	
	public void UserLogout()
	{
		clickbutton(LogoutLink);
	}

	public void openContactUsPage ()
	{
		scrollBottom();
		clickbutton(ContactUsLink);
		
	}
	public void ChangeCurrrency ()
	{
		select = new Select(CurrencyDDL) ;
		select.selectByVisibleText("Euro");
	}

	public void  SelectNotebooksMenu ()
	{
		action.moveToElement(ComuptersMenu).build().perform();
		action.moveToElement(NotebooksMenu).click().build().perform();
	}




}
