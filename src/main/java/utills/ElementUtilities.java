package utills;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtilities {
	WebDriver driver;

	public ElementUtilities(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(WebElement element) {
		if (isElementInDisplayed(element)&& isElementInEnabledState(element)) {
			element.click();
		}
	}

	public boolean isElementInEnabledState(WebElement element) {
		boolean b = false;
		if (isElementInDisplayed(element)) {
			b = element.isEnabled();
		}
		return b;
	}

	public boolean isElementInDisplayed(WebElement element) {
		boolean b = false;
		try {
			b = element.isDisplayed();
		} catch (NoSuchElementException e) {
			b = false;
		}
		return b;
	}
	public void enterTextIntoElement(WebElement element,String text)
	{
		if(isElementInDisplayed(element) && isElementInEnabledState(element) )
		{
			element.clear();
			element.sendKeys(text);
		}
	}
public String getTextFromElement(WebElement element)
{
	String text="";
	if(isElementInDisplayed(element))
	{
		text=element.getText();
	}
	return text;
}
public boolean isElementInSelectedState(WebElement element)
{
	boolean b=false;
	if(isElementInDisplayed(element))
	{
		b=element.isSelected();
	}
	return b;
}
}
