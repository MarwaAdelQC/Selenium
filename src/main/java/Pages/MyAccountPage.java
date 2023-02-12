package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);



	}

	@FindBy (linkText = "My account")
	WebElement MyAccLink ;

	@FindBy (linkText = "Change password")
	WebElement ChangePasswordLink ;

	@FindBy (id = "OldPassword")
	WebElement OldPasswordTxt ;

	@FindBy (id = "NewPassword")
	WebElement NewPasswordTxt ;

	@FindBy (id = "ConfirmNewPassword")
	WebElement ConfirmNewPasswordTxt ;

	@FindBy (css = "button.button-1.change-password-button")
	WebElement ChangePasswordBtn;

	@FindBy (className = "content")
	public WebElement ResultMsgLbl ;
	
	@FindBy (css = "span.close")
	WebElement CloseBarBtn ;





	public void OpenChangePasswordPage ()
	{
		clickbutton(ChangePasswordLink);
	}

	public void changePassword (String OldPassword , String NewPassword)
	{
		settextElementtext(OldPasswordTxt, OldPassword);
		settextElementtext(NewPasswordTxt, NewPassword);
		settextElementtext(ConfirmNewPasswordTxt, NewPassword);
		clickbutton(ChangePasswordBtn);
	}

	public void OpenMyAccPage() 
	{
		clickbutton(MyAccLink);
	}
	
	public void CloseBar ()
	{
		clickbutton(CloseBarBtn);
	}

}
