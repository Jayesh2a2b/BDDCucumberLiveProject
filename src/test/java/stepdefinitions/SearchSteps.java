package stepdefinitions;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utills.CommonUtils;

public class SearchSteps {
	
WebDriver driver;
Properties prop;
@Given("user navigate to home page")
public void user_navigate_to_home_page() {
	prop = CommonUtils.loadPropertyFiles();

}

@When("user enter valid product in search box")
public void user_enter_valid_product_in_search_box() {
	driver=DriverFactory.getDriver();
	driver.findElement(By.name("search")).sendKeys(prop.getProperty("existingProduct"));
}

@And("click on search button")
public void click_on_search_button() {
driver.findElement(By.xpath("//span[@class='input-group-btn']")).click();
}

@Then("user found a product in search field")
public void user_found_a_product_in_search_field() {
	driver=DriverFactory.getDriver();
Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']")).isDisplayed());
Assert.assertTrue(driver.findElement(By.xpath("//a[text()='HP LP3065']")).isDisplayed());
}
@When("user enter invalid product in search box")
public void user_enter_invalid_product_in_search_box() {
	driver=DriverFactory.getDriver();
	driver.findElement(By.name("search")).sendKeys(prop.getProperty("nonExistingProduct"));

}

@Then("user not found a product in search field")
public void user_not_found_a_product_in_search_field() {
	Assert.assertTrue(driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).isDisplayed());
}


}
