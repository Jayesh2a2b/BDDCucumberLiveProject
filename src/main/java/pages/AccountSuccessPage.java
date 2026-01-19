package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.root.RootPage;

public class AccountSuccessPage extends RootPage{
WebDriver driver;
public AccountSuccessPage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Success']")
private WebElement successBreadcrumb;
public boolean isSuccessBreadcrumbAvailableOnPage()
{
	return successBreadcrumb.isDisplayed();
}
}
