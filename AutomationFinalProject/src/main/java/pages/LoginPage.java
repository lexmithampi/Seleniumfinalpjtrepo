package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement usernameField;
	@FindBy(name = "password")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbtn;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminBtn;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement loginText;

	public LoginPage enterUsernameOnUsernameField(String username) {
		// TODO Auto-generated method stub
		usernameField.sendKeys(username);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String password) {
		// TODO Auto-generated method stub
		passwordField.sendKeys(password);
		return this;
	}

	public HomePage clickOnLoginBtn() {
		// TODO Auto-generated method stub
		loginbtn.click();
		return new HomePage(driver);

	}

	public boolean adminBtnEnabled() {
		return adminBtn.isEnabled();
	}

	public String getLoginText() {
		return loginText.getText();
	}

}
