package hooks;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utills.CommonUtils;

public class MyHooks {
	WebDriver driver;
	@Before
public void setup()
{
		driver=DriverFactory.openBrowserAndApplicationUrl(CommonUtils.loadPropertyFiles());
}
	@After
public void teardown()
{
	if(driver!=null)
	{
		driver.close();
	}

}
}