package scripts;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.IAutoConstant;
import generic.Lib;
import pompages.LoginPage;




public class TestInValidLogin extends BaseTest{

	@Test
	public void inValidLogin() {
		LoginPage lp=new LoginPage(driver);
		int row=Lib.getRowCount("InvalidLogin");
		for(int i=1;i<=row;i++) {
		lp.setUsername(Lib.getCellValue("InvalidLogin", i, 0));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lp.setPwd(Lib.getCellValue("InvalidLogin", i, 1));
	
			try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		lp.clickLogin();
		
		
	}

	}	
}