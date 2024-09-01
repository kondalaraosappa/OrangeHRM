package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import generalOperations.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTest extends BaseClass {
	  LoginPage login;

	public LoginTest() throws Throwable {
		super();
		
	}
	@Test(priority = 1)
	public  void LoginWithValidCredentials() throws Throwable {
		login=new LoginPage();
		login.EnterUserName(prop.getProperty("UserName"));
		login.EnterPassWord(prop.getProperty("PassWord"));
		HomePage home=login.ClickOnloginButton();
		Assert.assertTrue(home.VisibleDashBoard());
		
	}
	@Test(priority = 2)
	public void LoginWithInvalidCredentials() throws Throwable {
		login=new LoginPage();
		login.EnterUserName(prop.getProperty("UserName"));
		login.EnterPassWord(prop.getProperty("InvalidPassWord"));
		login.ClickOnloginButton();
		String acctualText=login.VisibleAlertText();
		Assert.assertEquals(acctualText, "Invalid credentials","alertnotmatched");
	}        
	

}
