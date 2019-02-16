package generic;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;



public class ListenerDemo implements ISuiteListener,ITestListener{

	@Override
	public void onFinish(ITestContext testBlock) {
		Reporter.log(testBlock.getName()+" Finished",true);
		
	}

	@Override
	public void onStart(ITestContext testBlock) {
		Reporter.log(testBlock.getName()+" Started",true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult testMethod) {
	
		Reporter.log(testMethod.getName()+" Failed",true);
		
	}

	@Override
	public void onTestSkipped(ITestResult testMethod) {
		
		Reporter.log(testMethod.getName()+" Skipped",true);
	}

	@Override
	public void onTestStart(ITestResult testMethod) {
		
		Reporter.log(testMethod.getName()+" Started",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult testMethod) {
		Reporter.log(testMethod.getName()+" Success",true);
		
	}

	@Override
	public void onFinish(ISuite isuite) {
		// TODO Auto-generated method stub
		Reporter.log(isuite.getName()+" Finished",true);
		
	}

	@Override
	public void onStart(ISuite isuite) {
		// TODO Auto-generated method stub
		Reporter.log(isuite.getName()+" Started",true);
	}
	

}
