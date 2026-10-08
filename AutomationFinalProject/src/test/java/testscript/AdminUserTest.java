package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import seleniumcore.TestngBase;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends TestngBase {

	HomePage home;
	AdminUserPage adminuser;

	@Test(description = "Verify Admin is able to Add New User")
	public void verifyAdminUserIsAbleToAddNewUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		FakerUtility fake = new FakerUtility();
		String adminUsernameField = fake.createRandomUsername();
		String adminPasswordField = fake.createRandomPassword();
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnLoginBtn();
		// HomePage home = new HomePage(driver);
		AdminUserPage adminuser = new AdminUserPage(driver);
		home.clickmoreInfoLink();
		adminuser.clickOnNewBtn().enterUsernameOnUsernameField(adminUsernameField)
				.enterPasswordOnPasswordField(adminPasswordField).clickUserTypeDropdown().clicksavebtn();
		boolean isAlertDisplayed = adminuser.alertDisplay();
		Assert.assertTrue(isAlertDisplayed, "Unable to create user");

	}

	@Test(description = "Verify Admin is able to search the newly added user")
	public void verifyAdminUserIsAbleToSearchNewUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		String adminUsernameField = ExcelUtility.readStringData(0, 0, "AdminUserPage");
		String adminPasswordField = ExcelUtility.readStringData(0, 1, "AdminUserPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnLoginBtn();
		AdminUserPage adminuser = new AdminUserPage(driver);
		home.clickmoreInfoLink();
		adminuser.clickOnSearchBtn().enterUsernameOnSearchUsernameField(adminUsernameField).searchUserType()
				.clickOnSearchButton();
		String expected = "Search Admin Users";
		String actual = adminuser.getSearchAdminUserText();
		Assert.assertEquals(actual, expected, Constant.ADMINSEARCHERROR);

	}

	@Test(description = "Verify Admin is able to reset Admin User List")
	public void verifyAdminUserIsAbleToResetAdminUserList() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		String adminUsernameField = ExcelUtility.readStringData(0, 0, "AdminUserPage");
		String adminPasswordField = ExcelUtility.readStringData(0, 1, "AdminUserPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnLoginBtn();
		AdminUserPage adminuser = new AdminUserPage(driver);
		home.clickmoreInfoLink();
		adminuser.clickOnResetBtn();
		String expected = "Admin Users";
		String actual = adminuser.resetAdminUserText();
		Assert.assertEquals(actual, expected, Constant.ADMINRESETERROR);

	}

}
