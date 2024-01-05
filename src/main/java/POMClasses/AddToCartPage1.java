package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage1 {
	

		public WebDriver driver;
		
		public AddToCartPage1(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		
		@FindBy(xpath="//p[text()='Levis Mens Regular Fit Tee']")
		private WebElement levisProduct;
		
		public WebElement getlevisProduct() {
			return levisProduct;
		}
		
		@FindBy(id="buynow_fl")
		private WebElement buyNowButtonInAddToCartPage;
		
		public WebElement buyNowButtonInAddToCartPage() {
			return buyNowButtonInAddToCartPage;
		}
		
		
	}

