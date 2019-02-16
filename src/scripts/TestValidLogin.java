package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.IAutoConstant;
import generic.Lib;
import pompages.LoginPage;




public class TestValidLogin extends BaseTest{
	@Test
	public void validLogin() {
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(Lib.getCellValue("ValidLogin", 1, 0));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lp.setPwd(Lib.getCellValue("ValidLogin", 1, 1));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lp.clickLogin();
		System.out.println(driver.getTitle());
		
	}

	
}