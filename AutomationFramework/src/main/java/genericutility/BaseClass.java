package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelcomePage;

public class BaseClass {
	public static ExtentReports extReport; //GLOBALLY DECLARED
	public static ExtentTest test; //GLOBALLY DECLARED
	
	public WebDriver driver; //GLOBALLY DECLARED
	public static WebDriver sdriver;
	
	public JavaUtility jUtil=new JavaUtility();  //CREATE OBJECTS FOR ALL NONSTATIC METHODS, AND THEN CALL THEM USING ORV
	public WebDriverUtility wUtil=new WebDriverUtility();  //CREATE OBJECTS FOR ALL NONSTATIC METHODS, AND THEN CALL THEM USING ORV
	public FileUtility fUtil=new FileUtility();  //CREATE OBJECTS FOR ALL NONSTATIC METHODS, AND THEN CALL THEM USING ORV
	public ExcelUtility eUtil = new ExcelUtility();  //CREATE OBJECTS FOR ALL NONSTATIC METHODS, AND THEN CALL THEM USING ORV
	
	public WelcomePage wp; //GLOBALLY DECLARED
	public LoginPage lp; //GLOBALLY DECLARED
	public HomePage hp; //GLOBALLY DECLARED
	
	@BeforeSuite 
	public void reportConfig() {
	ExtentSparkReporter spark=new ExtentSparkReporter("./HTML Report/ExtentReports"+jUtil.getSystemTime());
	extReport=new ExtentReports(); 
	extReport.attachReporter(spark);
	}
	
	@Parameters("Browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome")String browserName) throws IOException {
		if(browserName.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			}
		sdriver=driver;
		wUtil.maximiseWindow(driver); //method from WebDriverUtility.java called using orv
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(fUtil.getDataFromProperty("url"));
			
		}
	
	@BeforeMethod
	public void login() throws IOException {
		wp=new WelcomePage(driver); //WelcomePage Stored Already In Object Repository, so Welcome Page Launched
		wp.getLoginLink().click();
		
		lp=new LoginPage(driver);
		lp.getEmailTextFiels().sendKeys(fUtil.getDataFromProperty("email"));
		lp.getPasswordTextField().sendKeys(fUtil.getDataFromProperty("password"));
		lp.getLoginButton().click();
	}
	
	@AfterMethod
	public void logout() {
		hp=new HomePage(driver);
		hp.getLogOutLink().click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	@AfterSuite
	public void reportBackup() {
		extReport.flush();
	}
	

}
