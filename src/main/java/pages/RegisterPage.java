package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.root.RootPage;

public class RegisterPage extends RootPage {
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	public void enterFirstName(String firstNameText) {
		elementUtilities.enterTextIntoElement(firstNameField, firstNameText);
	}

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	public void enterLastName(String lastNameText) {
		elementUtilities.enterTextIntoElement(lastNameField, lastNameText);
	}

	@FindBy(id = "input-email")
	private WebElement emailField;

	public void enterEmail(String emailText) {
		elementUtilities.enterTextIntoElement(emailField, emailText);
	}

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	public void enterTelephone(String telephoneText) {
		elementUtilities.enterTextIntoElement(telephoneField, telephoneText);
	}

	@FindBy(id = "input-password")
	private WebElement passwordFiels;

	public void enterPassword(String passwordText) {
		elementUtilities.enterTextIntoElement(passwordFiels, passwordText);
	}

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;
   public void enterConfirmPassword(String confirmPasswordText) {
	   elementUtilities.enterTextIntoElement(confirmPasswordField, confirmPasswordText);
	}

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyOption;

	public void clickOnPrivacyPolicyOption() {
		elementUtilities.clickOnElement(privacyPolicyOption);
	}
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement continueButton;
	public AccountSuccessPage clickOnContinueButton()
	{
		elementUtilities.clickOnElement(continueButton);
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
