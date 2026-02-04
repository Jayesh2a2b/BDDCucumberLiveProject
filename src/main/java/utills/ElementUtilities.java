package utills;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtilities {
	WebDriver driver;

	public ElementUtilities(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(WebElement element) {
		if (isElementDisplayed(element) && isElementInEnabledState(element)) {
			element.click();
		}
	}

	public boolean isElementInEnabledState(WebElement element) {
		boolean b = false;
		if (isElementDisplayed(element)) {
			b = element.isEnabled();
		}
		return b;
	}

	public boolean isElementDisplayed(WebElement element) {
		boolean b = false;
		try {
			b = element.isDisplayed();
		} catch (NoSuchElementException e) {
			b = false;
		}
		return b;
	}

	public void enterTextIntoElement(WebElement element, String text) {
		if (isElementDisplayed(element) && isElementInEnabledState(element)) {
			element.clear();
			element.sendKeys(text);
		}
	}

	public String getTextFromElement(WebElement element) {
		String text = "";
		if (isElementDisplayed(element)) {
			text = element.getText();
		}
		return text;
	}

	public boolean isElementInSelectedState(WebElement element) {
		boolean b = false;
		if (isElementDisplayed(element)) {
			b = element.isSelected();
		}
		return b;
	}

	public void clickOnElement(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();

	}

	public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);

	}

	public WebElement waitForElement(WebElement element, long durationInSeconds) {

		WebElement webElement = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return webElement;

	}

	public void selectOptionInDropdown(WebElement element, String dropDownOption, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);
		Select select = new Select(webElement);
		select.selectByVisibleText(dropDownOption);

	}

	public void acceptAlert(long durationInSeconds) {

		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();

	}

	public void dismissAlert(long durationInSeconds) {

		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();

	}

	public Alert waitForAlert(long durationInSeconds) {

		Alert alert = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return alert;

	}

	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();

	}

	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {

		WebElement webElement = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return webElement;

	}

	public void javaScriptClick(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].click();", webElement);

	}

	public void javaScriptType(WebElement element, long durationInSeconds, String textToBeTyped) {

		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='" + textToBeTyped + "'", webElement);

	}

	public String getTextFromElement(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);
		return webElement.getText();

	}

	public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {

		try {
			WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
			return webElement.isDisplayed();
		} catch (Throwable e) {
			return false;
		}

	}

}
