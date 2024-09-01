package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import generalOperations.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class NewUserCreation extends BaseClass{

	public NewUserCreation() throws Throwable {
		super();
		
	}
	@Test(priority = 1)
	public void CreateNewUser() throws Throwable {
		LoginPage login = new LoginPage();
		login.EnterUserName(prop.getProperty("UserName"));
		login.EnterPassWord(prop.getProperty("PassWord"));
		HomePage home=login.ClickOnloginButton();
		Assert.assertTrue(home.VisibleDashBoard());
		home.AdminClick();
		home.clickOnadd();
		home.UserCreation();
		Assert.assertTrue(home.SystemUsers());
	}
	
	
	

}
