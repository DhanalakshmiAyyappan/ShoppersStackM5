package POMClasses;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage1 {

	public WebDriver driver;
	
	public HomePage1(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//button[@aria-label='Account settings']")
	private WebElement accountSettingIcon;
	
	public WebElement getAccountSettingIcon() {
		return accountSettingIcon;
	}
	
	@FindBy(xpath="//a[@href='/men' and @id='men']")
	private WebElement menMenuLink;
	
	public WebElement getmenMenuLink() {
		return menMenuLink;
	}
	
	@FindBy(xpath="//a[text()='T-shirts']")
	private WebElement TshirtPopupLink;
	
	public WebElement getTshirtPopupLink() {
		return TshirtPopupLink;
	}
	
	@FindBy(xpath="//a[@id='cart']")
	private WebElement addToCartLink;
	
	public WebElement getaddToCartLink() {
		return addToCartLink;
	}
	
	public void javaScriptClick(WebDriver driver) {
		WebElement ele=driver.findElement(By.xpath("//button[@aria-label='Account settings']"));
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();",ele);
	}
	
}



