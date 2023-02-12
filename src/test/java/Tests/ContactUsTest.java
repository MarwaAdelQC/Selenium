package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ContactUsPage;
import Pages.HomePage;

public class ContactUsTest extends TestBase{
	
	HomePage home ;
	ContactUsPage contactpage ;
	
	String FullName = "Marwa Adel" ;
	String Email = "marwa@testm.com" ;
	String Enquiry = "text message" ;
	
	@Test
	public void UserCanContactUs ()
	{
		home = new HomePage(driver) ;
		home.openContactUsPage();
		contactpage = new ContactUsPage(driver);
		contactpage.ContactUs(FullName, Email, Enquiry);
		Assert.assertTrue(contactpage.SuccessMsg.getText().contains("Your enquiry has been successfully sent to the store owner."));
	}
			

}
