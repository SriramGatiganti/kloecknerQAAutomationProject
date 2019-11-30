package kloeckner.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kloeckner.Base.BaseClass;

public class LoginPage extends BaseClass {

	// Page Factory - OR:
	@FindBy(xpath = "//a[contains(@class,'btn btn-sm btn-link text-white')]")
	WebElement loginBtn;

	@FindBy(xpath = "//input[contains(@id,'user')]")
	WebElement username;

	@FindBy(xpath = "//input[contains(@id,'login')]")
	WebElement loginWithAtlassianButton;

	@FindBy(xpath = "//input[contains(@id,'username')]")
	WebElement atlasssinaUserName;

	@FindBy(xpath = "//span[contains(text(),'Continue')]")
	WebElement continueButton;

	@FindBy(xpath = "//input[contains(@id,'password')]")
	WebElement password;

	@FindBy(xpath = "//button[contains(@id,'login-submit')]//span[contains(@class,'css-t5emrf')]")
	WebElement loginBtnAtlassian;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	// Verify Login Page Title
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	// Login Action
	public void login(String un, String pwd) throws InterruptedException {

		loginBtn.click();
		username.sendKeys(un);
		loginWithAtlassianButton.click();
		// Thread.sleep(5000);
		atlasssinaUserName.clear();
		atlasssinaUserName.sendKeys(un);
		continueButton.click();
		Thread.sleep(1000);
		password.sendKeys(pwd);
		loginBtnAtlassian.click();

	}

}
