package StepDefinitions;

import org.testng.Assert;

import Pages.HomePage;
import Pages.UserRegistrationPage;
import Tests.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class UserRegistration extends TestBase {
	
	HomePage homepageObject ;
	UserRegistrationPage registerobject ;
	
	
	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
		
		homepageObject = new HomePage(driver);
		
	}
	@When("I click on Register link")
	public void i_click_on_register_link() {
		homepageObject.openRegistartionPage();
	//	registerobject = new UserRegistrationPage(driver);

	}
	
	@When("I entered {string} , {string} , {string} , {string}")
	public void i_entered(String firstname, String lastname, String email, String password) {
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration(firstname, lastname, email, password);
	   
	}
	
	@Then("the Confirmation label is displayed successfully")
	public void the_confirmation_label_is_displayed_successfully() {
		Assert.assertTrue(registerobject.successmsg.getText().contains("Your registration completed"));
	}

}
