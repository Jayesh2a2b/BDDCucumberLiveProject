package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}

	@FindBy(id = "input-email")
	private WebElement emailField;

	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	public void enterTelephone(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}

	@FindBy(id = "input-password")
	private WebElement passwordFiels;

	public void enterPassword(String passwordText) {
		passwordFiels.sendKeys(passwordText);
	}

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;

	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordField.sendKeys(confirmPassword);
	}

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyOption;

	public void clickOnPrivacyPolicyOption() {
		privacyPolicyOption.click();
	}
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement continueButton;
	public AccountSuccessPage clickOnContinueButton()
	{
		continueButton.click();
		return new  AccountSuccessPage(driver);
	}
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Register']")
	private WebElement registerBreadcrumbOption;
	public boolean isRegisterBreadcrumbAvailbleOnPage()
	{
		return registerBreadcrumbOption.isDisplayed();
	}
	@FindBy(xpath="registerPage")
	private WebElement privacyWarningMsg;
	public boolean isPrivacyPolicyWarningMsgAvailableOnPage()
	{
		return privacyWarningMsg.isDisplayed();
	}

}
