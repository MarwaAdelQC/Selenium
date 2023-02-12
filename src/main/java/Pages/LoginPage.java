package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy (id = "Email")
	WebElement Emailtxtbox ;
	
	@FindBy (id = "Password")
	WebElement Passwordtxtbox ;
	
	@FindBy (css = "button.button-1.login-button")
	WebElement LoginBtn ;
	
	
	public void UserLigon (String Email , String Password)
	{
		settextElementtext(Emailtxtbox, Email);
		settextElementtext(Passwordtxtbox, Password);	
		clickbutton(LoginBtn);
	}
	
	
	
	
}
