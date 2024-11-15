package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="Email")
	private WebElement emailTextFiels;
	
	@FindBy(id ="Password")
	private WebElement passwordTextField;
	
	@FindBy(xpath ="(//input[@type='submit'])[2]" )
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getEmailTextFiels() {
		return emailTextFiels;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	
	

}
