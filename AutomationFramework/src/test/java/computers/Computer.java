package computers;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenerUtility;
import objectrepository.HomePage;

@Listeners(ListenerUtility.class)

public class Computer extends BaseClass { 
	@Test
	 public void clickOnComputer() throws EncryptedDocumentException, IOException {  
		//test=extReport.createTest("clickOnComputer"); //4th step of extent report //done in ListenerUtility
		hp=new HomePage(driver); //object creation for homepage
		hp.getComputerLink().click(); //computer linked clicked 
		Assert.assertEquals(driver.getTitle(), eUtil.getStringDataFromExcel("Computer", 1, 0),"Computer page is not displayed");//data fetched from excel file
		test.log(Status.PASS,"Computer page is displayed"); //5th step of extent report
	}
}
