package pages.root;

import org.openqa.selenium.WebDriver;

import utills.ElementUtilities;

public class RootPage {
	WebDriver driver;
	public ElementUtilities elementUtilities;
	public RootPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtilities = new ElementUtilities(driver);
	}
	

}
