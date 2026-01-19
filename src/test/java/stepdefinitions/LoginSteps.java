package stepdefinitions;

import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utills.CommonUtils;

public class LoginSteps {
	WebDriver driver;
	Properties prop ;
	  WebDriverWait wait;
	@Given("user should navigate to Login page")
	public void user_should_navigate_to_login_page() {
		driver = DriverFactory.getDriver();
		prop = CommonUtils.loadPropertyFiles();
		driver.findElement(By.xpath("//li[@class='dropdown']//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")).click();

	}

	@When("user enter email and password in Email and Password text box field")
	public void user_enter_email_and_password_in_email_and_password_text_box_field() {
		driver = DriverFactory.getDriver();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
	}

	@And("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("user shouild loged in and navigate to My Account Page")
	public void user_shouild_loged_in_and_navigate_to_my_account_page() {
		driver = DriverFactory.getDriver();
	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    Assert.assertTrue(
	        wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//h2[text()='My Account']")
	            )
	        ).isDisplayed());

	}

	@When("user enters invalid credentials")
	public void user_enters_invalid_credentials() {
		driver = DriverFactory.getDriver();
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateNewEmail());
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("invalidPassword"));

	}

	@Then("user should not logged in")
	public void user_should_not_logged_in() {
		driver = DriverFactory.getDriver();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
	}

}
