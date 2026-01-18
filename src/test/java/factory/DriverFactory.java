package factory;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public static WebDriver driver;
public static WebDriver openBrowserAndApplicationUrl(Properties prop)
{
	String browserName = prop.getProperty("browserName");
	if(browserName.equalsIgnoreCase("chrome"))
	driver=new ChromeDriver();
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if(browserName.equalsIgnoreCase("edge"))
	{
		driver=new EdgeDriver();
	}
	else
	{
	    throw new RuntimeException("Invalid browser name: " + browserName);
	}
	driver.get(prop.getProperty("appUrl"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	return driver;
}
public static WebDriver getDriver()
{
	return driver;
}
}
