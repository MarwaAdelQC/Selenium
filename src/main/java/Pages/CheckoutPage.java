package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy (id = "BillingNewAddress_CountryId")
	WebElement CountryDDL ;
	
	@FindBy (id = "BillingNewAddress_City")
	WebElement CityTxt ;
	
	@FindBy (id = "BillingNewAddress_Address1")
	WebElement AdressTxt ;
	
	@FindBy (id = "BillingNewAddress_ZipPostalCode")
	WebElement ZipPostalTxt ;
	
	@FindBy (id = "BillingNewAddress_PhoneNumber")
	WebElement PhoneNumberTxt ;
	
	@FindBy (css = "button.button-1.new-address-next-step-button")
	WebElement ContinueBtn1 ;
	
	@FindBy (id = "shippingoption_0")
	WebElement shppingOption1Radio ;
	
	@FindBy (css = "button.button-1.shipping-method-next-step-button")
	WebElement ContinueBtn2 ;
	
	@FindBy (id = "paymentmethod_0")
	WebElement PaymentMethodRadio ;
	
	@FindBy (css = "button.button-1.payment-method-next-step-button")
	WebElement ContinueBtn3 ;
	
	@FindBy (css = "button.button-1.payment-info-next-step-button")
	WebElement ContinueBtn4 ;
	
	@FindBy (css = "div.billing-info-wrap")
	WebElement billingbox ;
	
	@FindBy (css = "div.shipping-info-wrap")
	WebElement shippingbox ;
	
	@FindBy (css = "button.button-1.confirm-order-next-step-button")
	WebElement ContinuefinalBtn ;
	
	@FindBy (id = "BillingNewAddress_StateProvinceId")
	WebElement StateDDL ;
	
	
	public void ConfirmOrderData (String city , String address , String ZipPostal , String phone)
	{
		
		select = new Select(CountryDDL) ;
		select.selectByVisibleText("United States");
		
		
		select = new Select(StateDDL) ;
		select.selectByVisibleText("Hawaii");
		
		settextElementtext(CityTxt, city);
		settextElementtext(AdressTxt, address);
		settextElementtext(ZipPostalTxt, ZipPostal);
		settextElementtext(PhoneNumberTxt, phone);
		clickbutton(ContinueBtn1);
		clickbutton(shppingOption1Radio);
		clickbutton(ContinueBtn2);
		clickbutton(PaymentMethodRadio);
		clickbutton(ContinueBtn3);
		clickbutton(ContinueBtn4);
		clickbutton(ContinuefinalBtn);
		
		
		
	}
	
}
