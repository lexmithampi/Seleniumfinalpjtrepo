package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constant;
import utilities.PageUtility;

public class AdminUserPage {
	
	PageUtility page = new PageUtility();

	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="(//a[@class=\"small-box-footer\"])[2]")WebElement
	// moreInfoLink;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbtn;
	@FindBy(id = "username")
	WebElement adminUsernameField;
	@FindBy(name = "password")
	WebElement adminPasswordField;
	@FindBy(name = "user_type")
	WebElement userTypedrpdwn;
	@FindBy(name = "Create")
	WebElement saveBtn;

	@FindBy(xpath = "//a[@onclick=\"click_button(2)\"]")
	WebElement searchBtn;
	@FindBy(name = "un")
	WebElement searchUsernameField;
	@FindBy(name = "ut")
	WebElement searchUserTypedrpdwn;
	@FindBy(name = "Search")
	WebElement searchButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetBtn;
	// @FindBy(xpath = "//h3[text()='Admin Users Informations']")WebElement
	// adminUsersInfoText;
	// @FindBy(xpath = "//h3[contains(normalize-space(),'Admin Users
	// Informations')]")WebElement adminUsersInfoText;
	@FindBy(xpath = "//h4[text()='Search Admin Users']")
	WebElement searchAdminUsersText;
	@FindBy(xpath = "//h1[text()='Admin Users']")
	WebElement adminUsersText;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement userAddSuccessAlert;

	/*
	 * public HomePage clickmoreInfoLink() { // TODO Auto-generated method stub
	 * moreInfoLink.click(); return new HomePage(driver); }
	 */

	public AdminUserPage clickOnNewBtn() {
		// TODO Auto-generated method stub
		newbtn.click();
		return this;

	}

	public AdminUserPage enterUsernameOnUsernameField(String username) {
		// TODO Auto-generated method stub
		adminUsernameField.sendKeys(username);
		return this;
	}

	public AdminUserPage enterPasswordOnPasswordField(String password) {
		// TODO Auto-generated method stub
		adminPasswordField.sendKeys(password);
		return this;

	}

	public AdminUserPage clickUserTypeDropdown() {
		// TODO Auto-generated method stub
		page.selectDropdownWithValue(userTypedrpdwn,Constant.DROPDOWNVALUE);
		return this;

	}

	public AdminUserPage clicksavebtn() {
		saveBtn.click();
		return this;
	}

	public AdminUserPage clickOnSearchBtn() {
		searchBtn.click();
		return this;
	}

	public AdminUserPage enterUsernameOnSearchUsernameField(String username) {
		searchUsernameField.sendKeys(username);
		return this;
	}

	public AdminUserPage searchUserType() {
		Select s = new Select(searchUserTypedrpdwn);
		s.selectByValue("staff");
		return this;
	}

	public AdminUserPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}

	public AdminUserPage clickOnResetBtn() {
		resetBtn.click();
		return this;
	}

	public boolean alertDisplay() {
		return userAddSuccessAlert.isDisplayed();
	}

	public String getSearchAdminUserText() {
		return searchAdminUsersText.getText();

	}

	public String resetAdminUserText() {
		return adminUsersText.getText();

	}

}
