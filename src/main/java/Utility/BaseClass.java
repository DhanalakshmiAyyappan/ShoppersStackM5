package Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import POMClasses.AccountSettingPage1;
import POMClasses.HomePage1;
import POMClasses.LoginPage1;
import POMClasses.WelcomePage;



public class BaseClass {
	public static WebDriver driver;
public	TestDataUtility du = new 	TestDataUtility();
public WebDriverUtility wu=new WebDriverUtility();
public DropDownUtility drpU=new DropDownUtility();

@BeforeClass
public void lanchingBrowser() throws Throwable {
System.out.println("---------lanchingBrowser------------");	
String BROWSER=du.dataFromPropertiesFile("browser");

if(BROWSER.equals("chrome")) {
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--disable-notifications");
	driver=new ChromeDriver(option);
}
else if(BROWSER.equals("firefox"))
{
	driver=new FirefoxDriver();
}
else if(BROWSER.equals("edge")) {
	driver=new EdgeDriver();
}
else {
	driver=new ChromeDriver();
}
String URL=du.dataFromPropertiesFile("url");

driver.get(URL);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}

@BeforeMethod
public void loginToApplication() throws Throwable {
System.out.println("---------login TO application----------");

WelcomePage WLpage = new WelcomePage(driver);
WLpage.getMainLoginButton().click();

LoginPage1 Lgpage = new LoginPage1(driver);

String emailId = du.dataFromPropertiesFile("email");
Lgpage.getEmailTextField().sendKeys(emailId);

String Password=du.dataFromPropertiesFile("password");
Lgpage.getPasswordTextField().sendKeys(Password);

Lgpage.getLoginButton().click();

}

@AfterMethod
public void logoutFromApplication() throws Throwable {
	System.out.println("----------logout from application-------");
	Thread.sleep(6000);
	HomePage1 Hpage=new HomePage1(driver);
	
	Hpage.javaScriptClick(driver);
	Thread.sleep(3000);
	AccountSettingPage1 as=new AccountSettingPage1(driver);
	as.getLogoutIcon().click();
}

@AfterClass
public void quitBrowser() {
System.out.println("----------quit the browser----------");	
driver.quit();
}

}