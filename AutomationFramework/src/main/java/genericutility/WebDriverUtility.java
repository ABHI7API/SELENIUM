package genericutility;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author abhinav
 */
public class WebDriverUtility {
	/**
	 * Thismethod is used to maximise window
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver) {
		driver.manage().window().maximize();
	} 
	
	/**
	 * This method is used to capture size of a window
	 * @param driver
	 * @return
	 */
	public Dimension getSize(WebDriver driver) {
		return driver.manage().window().getSize();
	}
	/**
	 * Thismethod is used to switch driver control to window based on url
	 * @param driver
	 * @param url
	 */
	
	public void swutchToWindow(WebDriver driver,String url) {
		//step1: capture window ids
		Set<String> allWindowIds = driver.getWindowHandles();
		//step2: navigate through all windows
		for(String id:allWindowIds) {
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(url)) {
				break;
			}
			}
		} 
	public void rightClick(WebDriver driver) { 
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	public void clickAndHold(WebDriver Driver,WebElement element) {
		Actions act=new Actions(Driver);
		act.clickAndHold(element).perform();;
	}
	/**
	 * This method is used to mousehover on elements
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method is used to drag and drop the elements
	 * @param driver
	 * @param element
	 */
	public void dragAndDrop(WebDriver driver,WebElement element1,WebElement element2) {
		Actions act=new Actions(driver);
		act.dragAndDrop(element1, element2).perform(); 
	}
	/**
	 * This method is used to switch to iframe using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index); 
	}
	/**
	 * This method is used to switch to iframe using nameorid
	 * @param driver
	 * @param nameorId
	 */
	public void switchToFrame(WebDriver driver,String nameorId) { 
		driver.switchTo().frame(nameorId);  
	}
	/**
	 * This method is used to switch to iframe using frameElement
	 * @param driver
	 * @param frameElement
	 */
	public void switchToFrame(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method is used to switch back to parent page
	 * @param driver
	 */
	public void switchToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to handle dropdowns using index
	 * @param element
	 * @param index
	 */
	public void selectDropDownByIndex(WebElement element,int index) {
		 Select ref=new Select(element);
		 ref.selectByIndex(index); 
	}
	/**
	 * This method is used to handle dropdowns using value
	 * @param element
	 * @param value
	 */
	public void selectDropDownByValue(WebElement element,String value) {
		Select ref=new Select(element);
		ref.selectByValue(value);
	}
	/**
	 * This method is used to handle dropdowns using text
	 * @param element
	 * @param text
	 */
	public void selectDropDownByVisisbleText(WebElement element,String text) { 
		Select ref=new Select(element);
		ref.selectByVisibleText(text);
	}
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void switchToAlertAndSendKeys(WebDriver driver,String data) {
		driver.switchTo().alert().sendKeys(data);
	}
	public void switchToAlertAndGetText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	public void jsScroll(WebDriver driver,int x,int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
}
