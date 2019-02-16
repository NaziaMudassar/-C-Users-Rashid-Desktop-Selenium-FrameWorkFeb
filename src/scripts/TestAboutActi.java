package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import pompages.EnterTimeTrackPage;
import pompages.LoginPage;

public class TestAboutActi extends BaseTest {
	@Test
	public void checkAboutActi() throws InterruptedException {
	LoginPage lp=new LoginPage(driver);
	lp.setUsername("admin");
	lp.setPwd("manager");
	lp.clickLogin();
	EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
	ettp.clickHelp();
	Thread.sleep(3000);
	ettp.clickAboutActi();
	Thread.sleep(3000);
	WebElement documentVersion=driver.findElement(By.xpath("//span[text()='actiTIME 2014 Pro']")) ;
	SoftAssert sa=new SoftAssert();
	String documentText=documentVersion.getText();
	System.out.println(documentText);
	sa.assertEquals(documentVersion.getText(), "actiTIME 20144 Pro"); 
	WebElement logOutBtn=driver.findElement(By.id("logoutLink"));
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	Thread.sleep(3000);
	jse.executeScript("arguments[0].click()",logOutBtn);
	
	
	lp.setUsername("admin");
	lp.setPwd("manager");
	lp.clickLogin();
	//ettp.clickLogout();
	sa.assertAll();
	}
	
		

}

