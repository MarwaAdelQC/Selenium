package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy (id = "FriendEmail")
	WebElement FriendEmailTxt ;
	
	@FindBy (id = "PersonalMessage")
	WebElement PersonalMessageTxt ;
	
	@FindBy (css = "button.button-1.send-email-a-friend-button")
	WebElement SendEmailBtn ;
	
	@FindBy (css = "div.result")
	public WebElement SuccessMsg ;
	
	public void SendEmailToFriend (String friendemail , String message)
	{
		settextElementtext(FriendEmailTxt, friendemail);
		settextElementtext(PersonalMessageTxt, message);
		clickbutton(SendEmailBtn);
		
	}

}
