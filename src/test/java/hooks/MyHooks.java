package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utills.CommonUtils;

public class MyHooks {
	WebDriver driver;
	@Before
public void setup()
{
		driver=DriverFactory.openBrowserAndApplicationUrl(CommonUtils.loadPropertyFiles());
}
	@After
public void teardown(Scenario scenario)
{
        if (scenario.isFailed()) {
            WebDriver driver = DriverFactory.getDriver();

            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(
                    screenshot,
                    "image/png",
                    scenario.getName());
        }
		
	if(driver!=null)
	{
		driver.quit();
	}

}
}