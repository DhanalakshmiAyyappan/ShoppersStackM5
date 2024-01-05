package POMClasses;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
public class WelcomePage {
	
	public WebDriver driver;
	
	//Initialization
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//declaration
	@FindAll({@FindBy(id="loginBtn"),@FindBy(xpath="//button[text()='Login']")})
	private WebElement MainLoginButton;

	//getters
	public WebElement getMainLoginButton() {
		return MainLoginButton;
	}

	
	
	
	


}

