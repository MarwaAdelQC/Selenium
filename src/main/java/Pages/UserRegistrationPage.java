package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase
{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy (id = "gender-male")
	WebElement gender1Rbtn ;
	
	@FindBy (id = "FirstName")
	WebElement fnTextbox ;
	
	@FindBy (id = "LastName")
	WebElement lnTextbox ;
	
	@FindBy (id = "Email")
	WebElement emailTextbox ;
	
	@FindBy (id = "Password")
	WebElement Passwordtxtbox ;
	
	@FindBy (id = "ConfirmPassword")
	WebElement ConfirmPasswordtxtbox ;
	
	@FindBy (id = "register-button")
	WebElement registerbtn ;
	
	@FindBy (css = "div.result")
	public WebElement successmsg ;
	
	@FindBy (css = "a.ico-logout")
	public WebElement LogoutLink ;
	
	@FindBy (linkText = "My account")
	WebElement MyAccLink ;
	
	public void UserRegistration (String firstName, String lastName, String email, String password) 
	{
	
		//gender1Rbtn.click();
		clickbutton(gender1Rbtn);
		//fnTextbox.sendKeys(firstName);
		settextElementtext(fnTextbox,firstName );
		//lnTextbox.sendKeys(lastName);
		settextElementtext(lnTextbox,lastName );
		//emailTextbox.sendKeys(email);
		settextElementtext(emailTextbox,email );
		//Passwordtxtbox.sendKeys(password);
		settextElementtext(Passwordtxtbox,password );
		//ConfirmPasswordtxtbox.sendKeys(password);
		settextElementtext(ConfirmPasswordtxtbox,password );
	//	registerbtn.click();
		clickbutton(registerbtn);
		
	}
	
	public void UserLogout()
	{
		clickbutton(LogoutLink);
	}
	
	public void OpenMyAccPage ()
	{
		clickbutton(MyAccLink);
	}
	
}

