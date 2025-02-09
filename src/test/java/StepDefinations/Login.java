package StepDefinations;

import org.openqa.selenium.WebDriver;

import Base.Base;
import Pages.Dashboard;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Login {
	 WebDriver driver;
	LoginPage login;

	@Given("User navigates to the login page")
	public void user_navigates_to_the_login_page() {
		driver=Base.getDriver();
		driver.get(Base.propFileReading().getProperty("URL"));
		login = new LoginPage(driver);
	}

	@When("User enters username {string} in the username field")
	public void user_enters_username_in_the_username_field(String username) {
		
		login.EnterUserName(username, 15000);
	}

	@And("User enters password {string} in the password field")
	public void user_enters_password_in_the_password_field(String password) {
		login.EnterPassword(password, 20000);
	}

	@When("User clicks the Login button")
	public void user_clicks_the_login_button() {
		login.clickOnSubmit(15000);
	}

	@Then("User is successfully logged in and redirected to the home page")
	public void user_is_successfully_logged_in_and_redirected_to_the_home_page() {
		Dashboard dash = new Dashboard(driver);
		Assert.assertTrue(dash.visibleSearchOption(20000));
	}

	@When("User enters invalid {string} in the username field")
	public void user_enters_invalid_in_the_username_field(String Invalidusername) {
		login.EnterUserName(Invalidusername, 15000);
	}

	@And("User enters invalid {string} in the password field")
	public void user_enters_invalid_in_the_password_field(String InvalidPassword) {
		login.EnterPassword(InvalidPassword, 20000);
		Assert.assertTrue(false);
	}

	@Then("Error message {string} is displayed")
	public void error_message_is_displayed(String errorMsg) {
		Assert.assertEquals(errorMsg,login.getErrorMsg(20000));
	}
}
