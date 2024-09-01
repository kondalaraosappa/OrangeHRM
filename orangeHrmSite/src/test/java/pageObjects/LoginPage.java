package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generalOperations.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() throws Throwable {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//button[contains(@class,'oxd-button--main orangehrm-login-button')]")
	WebElement LoginButton;
	@FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
	WebElement invalidPopUp;
	
	public void EnterUserName(String userName) {
		username.sendKeys(userName);
	}
	public void EnterPassWord(String passWord) {
		password.sendKeys(passWord);
	}
	public HomePage ClickOnloginButton() throws Throwable {
		LoginButton.click();
		return new HomePage();
	}
	public String VisibleAlertText() {
		   String PopUp=invalidPopUp.getText();
		   return PopUp;
		
	}

}
