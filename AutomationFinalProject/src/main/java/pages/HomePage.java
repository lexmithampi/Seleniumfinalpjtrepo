package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {
	
	WaitUtility wait = new WaitUtility();
	

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminLink;
	@FindBy(xpath = "/html/body/div/nav/ul[2]/li/div/a[2]")
	WebElement logoutbtn;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement loginText;
	@FindBy(xpath = "(//a[@class=\"small-box-footer\"])[2]")
	WebElement moreInfoLink;
	@FindBy(xpath = "(//a[@class=\'small-box-footer\'])[8]")
	WebElement managedelMoreInfoLink;

	public HomePage clickAdminLink() {
		// TODO Auto-generated method stub
		adminLink.click();
		return this;
	}

	public LoginPage clickOnLogoutBtn() {
		// TODO Auto-generated method stub
		wait.waitUntilElementToBeClickable(driver, logoutbtn);
		logoutbtn.click();
		return new LoginPage(driver);

	}

	public String getLoginText() {
		return loginText.getText();
	}

	public HomePage clickmoreInfoLink() {
		// TODO Auto-generated method stub
		moreInfoLink.click();
		return new HomePage(driver);
	}

	public HomePage clickManageDelboyMoreInfoLink() {

		// TODO Auto-generated method stub
		managedelMoreInfoLink.click();
		return new HomePage(driver);

	}

}
