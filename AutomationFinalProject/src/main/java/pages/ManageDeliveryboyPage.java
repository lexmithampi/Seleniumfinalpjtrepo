package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.PhoneNumber;

public class ManageDeliveryboyPage {

	public WebDriver driver;

	public ManageDeliveryboyPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="(//a[@class=\'small-box-footer\'])[8]")WebElement
	// managedelMoreInfoLink;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement managedelNewbtn;
	@FindBy(id = "name")
	WebElement addDelboyNameField;
	@FindBy(name = "email")
	WebElement addDelboyEmailField;
	@FindBy(name = "phone")
	WebElement addDelboyPhoneField;
	@FindBy(name = "address")
	WebElement addDelboyAddressField;
	@FindBy(id = "username")
	WebElement addDelboyUsernameField;
	@FindBy(id = "password")
	WebElement addDelboyPasswordField;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement addDelboySaveBtn;

	@FindBy(xpath = "//a[@onclick=\"click_button(2)\"]")
	WebElement searchDelboySaveBtn;
	@FindBy(name = "un")
	WebElement searchDelboyNameField;
	@FindBy(name = "ut")
	WebElement searchDelboyEmailField;
	@FindBy(name = "ph")
	WebElement searchDelboyPhoneField;
	@FindBy(name = "Search")
	WebElement searchDelboySearchbtn;

	@FindBy(xpath = "//h1[text()='Add-Delivery Boy']")
	WebElement addDelboyText;
	@FindBy(xpath = "//h4[text()='Search List Delivery Boy']")
	WebElement searchDelboyText;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;
	// @FindBy(xpath = "//h4[text()='List Delivery Boy']")WebElement
	// resetDelboyText;

	/*
	 * public HomePage clickManageDelboyMoreInfoLink() { // TODO Auto-generated
	 * method stub managedelMoreInfoLink.click(); return new HomePage(driver);
	 * 
	 * }
	 */

	public ManageDeliveryboyPage clickOnManageDelboyNewBtn() {
		// TODO Auto-generated method stub
		managedelNewbtn.click();
		return this;

	}

	public ManageDeliveryboyPage enterNameOnAddDelboyNameField(String username) {
		// TODO Auto-generated method stub

		addDelboyNameField.sendKeys(username);
		return this;
	}

	public ManageDeliveryboyPage enterEmailOnAddDelboyEmailField(String username) {
		// TODO Auto-generated method stub
		addDelboyEmailField.sendKeys(username);
		return this;
	}

	public ManageDeliveryboyPage enterPhoneOnAddDelboyPhoneField(CharSequence[] addDelboyPhoneField2) {
		// TODO Auto-generated method stub
		addDelboyPhoneField.sendKeys(addDelboyPhoneField2);
		return this;
	}

	public ManageDeliveryboyPage enterAddressOnAddDelboyAddressField(String username) {
		// TODO Auto-generated method stub
		addDelboyAddressField.sendKeys(username);
		return this;
	}

	public ManageDeliveryboyPage enterUsernameOnAddDelboyUsernameField(String username) {
		// TODO Auto-generated method stub
		addDelboyUsernameField.sendKeys(username);
		return this;
	}

	public ManageDeliveryboyPage pageScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;// control casting
		js.executeScript("window.scrollBy(0,350)", "");
		return this;
	}

	public ManageDeliveryboyPage enterPasswordOnAddDelboyPasswordField(String password) {
		// TODO Auto-generated method stub
		addDelboyPasswordField.sendKeys(password);
		return this;

	}

	public ManageDeliveryboyPage clickAddDelboySavebtn() {
		addDelboySaveBtn.click();
		return this;
	}

	public ManageDeliveryboyPage enterUsernameOnSearchUsernameField(String username) {
		addDelboyUsernameField.sendKeys();
		return this;
	}

	public ManageDeliveryboyPage clickOnSearchBtn() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(searchDelboySaveBtn));

		searchDelboySaveBtn.click();
		return this;
	}

	public ManageDeliveryboyPage enterNameOnSearchDelboyNameField(String name) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(searchDelboyNameField));

		searchDelboyNameField.sendKeys(name);
		return this;
	}

	public ManageDeliveryboyPage enterEmailOnSearchDelboyEmailField(String email) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(searchDelboyEmailField));

		searchDelboyEmailField.sendKeys(email);
		return this;
	}

	public ManageDeliveryboyPage enterPhoneOnSearchDelboyPhoneField(String phone) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(searchDelboyPhoneField));

		searchDelboyPhoneField.sendKeys(phone);
		return this;
	}

	public ManageDeliveryboyPage clickOnSearchButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(searchDelboySearchbtn));
		searchDelboySearchbtn.click();
		return this;
	}

	public boolean getAddDelboyAlert() {
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * 
		 * wait.until(ExpectedConditions.visibilityOf(addDelboyText)); return
		 * addDelboyText.getText();
		 */
		return successAlert.isDisplayed();
	}

	public String getSearchDelboyText() {
		return searchDelboyText.getText();
	}

}
