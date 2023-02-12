package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
		
		
	}
	
	@FindBy (id = "FullName")
	WebElement FullnameTxt ;
	
	@FindBy (id = "Email")
	WebElement EmailTxt ;
	
	@FindBy (id = "Enquiry")
	WebElement EnquiryTxt ;
	
	@FindBy (css = "button.button-1.contact-us-button")
	WebElement SubmitBtn ;
	
	@FindBy (css = "div.result")
	public WebElement SuccessMsg ;
	

	
	
	public void ContactUs (String fullname , String email , String enquiry ) 
	{
		settextElementtext(FullnameTxt, fullname);
		settextElementtext(EmailTxt, email);
		settextElementtext(EnquiryTxt, enquiry);
		clickbutton(SubmitBtn);
	}
	
	
}
