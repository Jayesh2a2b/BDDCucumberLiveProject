package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='dropdown']//span[text()='My Account']")
	private WebElement myAccountDropmenu;

	public void clickOnMyAccountDropmenu() {
		myAccountDropmenu.click();
	}

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")
	private WebElement registerOption;

	public RegisterPage clickOnRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")
	private WebElement loginOption;

	public LoginPage clickOnLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
}
