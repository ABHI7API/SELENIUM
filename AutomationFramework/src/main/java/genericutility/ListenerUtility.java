package genericutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerUtility extends BaseClass implements ITestListener { 
	@Override    //GITHUB
	public void onTestStart(ITestResult result) {
		test=extReport.createTest(result.getName());//object creation of ExtentTest //INITIALISATION
	}
	
	@Override
	public void onTestFailure(ITestResult result) { //IF TEST SCRIPT FAILS
		test.log(Status.FAIL,result.getName()+"is failed");
		TakesScreenshot ts=(TakesScreenshot) sdriver;
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));//to add ss in extent reports
		
		File temp = ts.getScreenshotAs(OutputType.FILE);//to add ss in screenshots folder
		File dest = new File("./Screenshots/"+result.getName()+jUtil.getSystemTime()+".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	 
	
	

}
