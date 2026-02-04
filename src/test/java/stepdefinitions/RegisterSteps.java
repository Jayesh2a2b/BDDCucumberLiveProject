package stepdefinitions;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterPage;
import pages.RightColumnOptionsPage;
import utills.CommonUtils;

public class RegisterSteps {
	WebDriver driver;
	Properties prop;
	HomePage homePage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	LoginPage loginPage;
	RightColumnOptionsPage rightcoloumnOptions;
	@Given("User navigates to Register page")
	public void user_navigates_to_register_page() {
		driver = DriverFactory.getDriver();
		prop = CommonUtils.loadPropertyFiles();
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropmenu();
		registerPage = homePage.clickOnRegisterOption();
	}

	@Given("User is on Register page")
	public void user_is_on_register_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropmenu();
		registerPage = homePage.clickOnRegisterOption();

		Assert.assertTrue(registerPage.isRegisterBreadcrumbAvailbleOnPage());
	}

	@When("User enters the below fields")
	public void user_enters_the_below_fields(DataTable dataTable) {
		Map<String, String> map = dataTable.asMap();
		registerPage.enterFirstName(map.get("firstName"));
		registerPage.enterLastName(map.get("lastName"));
		registerPage.enterEmail(CommonUtils.generateNewEmail());
		registerPage.enterTelephone(map.get("telephone"));
		registerPage.enterPassword(map.get("password"));
		registerPage.enterConfirmPassword(map.get("password"));
	    if (map.containsKey("conPassword")) {
	        registerPage.enterConfirmPassword(map.get("conPassword"));
	    } else {
	        registerPage.enterConfirmPassword(map.get("password"));
	    }


	}

	@When("User selects Privacy Policy field")
	public void user_selects_privacy_policy_field() {
		registerPage.clickOnPrivacyPolicyOption();
	}

	@Then("User Account should get created")
	public void user_account_should_get_created() {
		Assert.assertTrue(accountSuccessPage.isSuccessBreadcrumbAvailableOnPage());
	}

	@When("user not enter any details in text field")
	public void user_not_enter_any_details_in_text_field() {

	}

	@And("User clicks on Continue button")
	public void User_clicks_on_Continue_button() {
		accountSuccessPage = registerPage.clickOnContinueButton();

	}

	@Then("user should not loged in and warning message shows")
	public void user_should_not_loged_in_and_warning_message_shows() {
		Assert.assertTrue(registerPage.isRegisterBreadcrumbAvailbleOnPage());
	}

	@Then("User Account should not created and warning message shows on register page")
	public void User_Account_should_not_created_and_warning_message_shows_on_register_page() {
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
	}

	@When("user clicks on Continue button")
	public void user_clicks_on_continue_button() {
		accountSuccessPage = registerPage.clickOnContinueButton();

	}

	@Then("proper warning message should be displayed in the register page")
	public void proper_warning_message_should_be_displayed_in_the_register_page() {
		Assert.assertTrue(registerPage.IsPrivacyPolicyWarningMsgAvailableOnRegisterPage());
		Assert.assertTrue(registerPage.isFirstNameWarningMsgAvailableOnRegisterPage());
		Assert.assertTrue(registerPage.IsLastNameWarningMsgAvailableOnRegisterPage());
		Assert.assertTrue(registerPage.IsEmailWarningMsgAvailableOnRegisterPage());
		Assert.assertTrue(registerPage.IsTelephoneWarningMsgAvailableOnRegisterPage());
		Assert.assertTrue(registerPage.IsPasswordWarningMsgAvailableOnRegisterPage());

	}

	@Given("user open url in any browser")
	public void user_open_url_in_any_browser() {
		driver = DriverFactory.getDriver();
		prop = CommonUtils.loadPropertyFiles();
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);

	}

	@When("user click on my account drop menu")
	public void user_click_on_my_account_drop_menu() {
		homePage.clickOnMyAccountDropmenu();

	}

	@When("user click on Register option")
	public void user_click_on_register_option() {
		registerPage = homePage.clickOnRegisterOption();

	}

	@Then("user navigate to Register page")
	public void user_navigate_to_register_page() {
		Assert.assertTrue(registerPage.isRegisterBreadcrumbAvailbleOnPage());
	}
	@When("click on continue button on login Page")
	public void click_on_continue_button_on_login_page() {
		registerPage=loginPage.clickOnContinueButton();
	}

	@When("user click on login option")
	public void user_click_on_login_option() {
		loginPage = homePage.clickOnLoginOption();
	}
	@When("user click on register from Right coloum option")
	public void user_click_on_register_from_right_coloum_option() {
		rightcoloumnOptions = loginPage.getRightColumnOptions();
		registerPage=rightcoloumnOptions.clickOnRegisterOption();
	}
	@Then("proper warning message regarding mismatch password should be displayed")
	public void proper_warning_message_regarding_mismatch_password_should_be_displayed() {
		String expected="Password confirmation does not match password!";
		Assert.assertEquals(expected,registerPage.getTextOfPasswordConfirmWarningMsgAvailableOnRegisterPage());
	}

	@When("user enter existing email into email field")
	public void user_enter_existing_email_into_email_field() {
		registerPage.enterEmail(prop.getProperty("validEmail"));

	}

	@Then("proper warnig message regarding  existing email should be displayed")
	public void proper_warnig_message_regarding_existing_email_should_be_displayed() {
		Assert.assertTrue(registerPage.didWeGetDuplicateEmailWarningMsg());
		
	}
	@When("user enter below fields except password field")
	public void user_enter_below_fields_except_password_field(DataTable dataTable) {
		Map<String, String> map = dataTable.asMap();
		registerPage.enterFirstName(map.get("firstName"));
		registerPage.enterLastName(map.get("lastName"));
		registerPage.enterEmail(CommonUtils.generateNewEmail());
		registerPage.enterTelephone(map.get("telephone"));

		
	}

	@When("^user enters (.+) which is not following password complexity standards$")
	public void user_enters_which_is_not_following_complexity_standards(String password) {
		registerPage.enterPassword(password);
		registerPage.enterConfirmPassword(password);

	}

	@Then("proper warning messsage should be displayed about password complexity not being followed")
	public void proper_warning_messsage_should_be_displayed_about_password_complexity_not_being_followed() {
		String expectedWarning = "Enter password which follows Password Complexity Standard!";
		String actualWarning = registerPage.getPasswordWarningMsg();
		Assert.assertEquals(expectedWarning, actualWarning, "Password complexity standard is not being followed");

	}

	

}
