package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConstant {
	public WebDriver driver;
	static{
		//Set the Path
		System.setProperty(CHROME_KEY, CHROME_PATH);
		System.setProperty(FIREFOX_KEY, FIREFOX_PATH);
		System.setProperty(IE_KEY, IE_PATH);
	}
@Parameters("browser")
@BeforeMethod
public void openApplication(String browser) {
	
	//Launch the Browser
	if(browser.equals("chrome")) {
	driver=new FirefoxDriver();
	}
	else
	{
	driver=new ChromeDriver();
	}
	
	//Enter the URL
	String url = Lib.getPropertyValue("URL");
	driver.get(url);
	//Specify the implicit Time Wait
	String ito = Lib.getPropertyValue("IMPLICIT_TIMEOUT");
	long timeout = Long.parseLong(ito);
	driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
}
@AfterMethod
public void closeApplication(ITestResult res) {
	//Take Screenshot if Fail
	if(ITestResult.FAILURE==res.getStatus()) {
		Lib.captureScreenshot(driver, res.getName());
	}
	//Close the Browser
	driver.close();
	
}
}