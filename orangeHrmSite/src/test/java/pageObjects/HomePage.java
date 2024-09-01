package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generalOperations.BaseClass;

public class HomePage extends BaseClass {
	public HomePage() throws Throwable {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h6[text()='Dashboard']")
	WebElement DashBoard;
	@FindBy(xpath="//span[text()='Admin']")
	WebElement Admin;
	@FindBy(xpath="//div[@class='orangehrm-header-container']//button")
	WebElement Add;
	@FindBy(xpath="//label[contains(text(),'User Role')]//parent::div//following-sibling::div//div//div[@class='oxd-select-text oxd-select-text--active']")
    WebElement UserRole;
	@FindBy(xpath="//div[@class='oxd-select-dropdown --positon-bottom']//div[2]/span")
	WebElement UserRoleValue;
	@FindBy(xpath="//label[contains(text(),'Status')]//parent::div//following-sibling::div")
	WebElement Status;
	@FindBy(xpath="//div[contains(@class,'oxd-select-wrapper')]//span[text()='Enabled']")
	WebElement StatusValue;
	@FindBy(xpath="//div[contains(@class,'oxd-autocomplete-text-input')]//input")
	WebElement EmployeName;
	@FindBy(xpath="//div[contains(@class,'oxd-autocomplete-dropdown')]//span")
	WebElement EmpValue;
	@FindBy(xpath="//label[text()='Username']//parent::div//following-sibling::div//input")
	WebElement Username;
	@FindBy(xpath="//label[text()='Password']//parent::div//following-sibling::div//input")
	WebElement Password;
	@FindBy(xpath="//label[text()='Confirm Password']//parent::div//following-sibling::div//input")
	WebElement ConfirmPassword;
	@FindBy(xpath="//button[@type='submit']")
	WebElement Save;
	@FindBy(xpath="//h5[text()='System Users']")
	WebElement SystemUsers;
	
	public boolean VisibleDashBoard() {
		boolean Board = DashBoard.isDisplayed();
		return Board;

	}
	public void AdminClick() {
		Admin.click();
		
	}
	public void clickOnadd() {
		Add.click();
	}
	public void UserCreation() throws Throwable {
		UserRole.click();
		UserRoleValue.click();
		Status.click();
		StatusValue.click();
		EmployeName.sendKeys("R");
		EmpValue.click();
		String randomuser=randomString();
		System.out.println(randomuser);
		Username.sendKeys(randomuser);
		String randomPass= randomPassword();
		System.out.println(randomPass);
		Password.sendKeys(randomPass);
		Thread.sleep(2000);
		ConfirmPassword.sendKeys(randomPass);
		Save.click();
		
	}
	public boolean SystemUsers() {
		boolean Sys=SystemUsers.isDisplayed();
		return Sys;
		
	}

	
}
