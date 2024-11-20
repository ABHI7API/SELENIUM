package books;

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
public class TC_DWS_005_Test extends BaseClass {     
	@Test
	 public void clickOnBooks() throws EncryptedDocumentException, IOException {
		 //class is modified in Github
		//test=extReport.createTest("clickOnBooks"); //4th step of extent report //done in listenerUtility
		hp=new HomePage(driver); //object creation for homepage
		hp.getBooksLink().click(); //books linked clicked
		Assert.assertEquals(driver.getTitle(), eUtil.getStringDataFromExcel("Books", 1, 0),"Books page is not displayed");//data fetched from excel file
		test.log(Status.PASS,"Books page is displayed"); //5th step of extent report
	}
}
