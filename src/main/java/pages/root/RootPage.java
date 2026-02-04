package pages.root;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.RightColumnOptionsPage;
import utills.ElementUtilities;

public class RootPage {
	WebDriver driver;
	public ElementUtilities elementUtilities;
	public RootPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtilities = new ElementUtilities(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-home']")
	private WebElement homeBreadCrumb;
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Account']")
	private WebElement accountBreadcrumb;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement pageHeading;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement pageLevelSuccessMessage;
	
	
	public RightColumnOptionsPage getRightColumnOptions() {
		return new RightColumnOptionsPage(driver);
	}
	

	

}
