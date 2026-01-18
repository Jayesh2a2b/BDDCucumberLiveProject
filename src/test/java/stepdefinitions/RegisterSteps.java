package stepdefinitions;

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
import pages.MyAccountPage;
import pages.RegisterPage;
import utills.CommonUtils;

public class RegisterSteps {
	WebDriver driver;
	Properties prop;
	HomePage homePage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	@Given("User navigates to Register page")
	public void user_navigates_to_register_page() {
		driver = DriverFactory.getDriver();
		prop = CommonUtils.loadPropertyFiles();
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropmenu();
		registerPage=homePage.clickOnRegisterOption();
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
	public  void User_clicks_on_Continue_button() {
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
}
