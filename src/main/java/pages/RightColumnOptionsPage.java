package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.root.RootPage;

public class RightColumnOptionsPage extends RootPage {
	WebDriver driver;

	public RightColumnOptionsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//aside[@id='column-right']//a[text()='Register']")
	private WebElement registerOption;

	public RegisterPage clickOnRegisterOption() {
		elementUtilities.clickOnElement(registerOption);
		return new RegisterPage(driver);
	}

	@FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")
	private WebElement logoutOption;


	public boolean isLogoutOptionAvailable() {
		return elementUtilities.isElementDisplayed(logoutOption);
	}

	@FindBy(xpath = "//div[@class='list-group']//a[text()='Login']")
	private WebElement loginOption;

	public LoginPage clickOnLoginOption() {
		elementUtilities.clickOnElement(loginOption);
		return new LoginPage(driver);
	}

}
