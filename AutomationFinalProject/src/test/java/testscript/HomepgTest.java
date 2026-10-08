package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import seleniumcore.TestngBase;
import utilities.ExcelUtility;

public class HomepgTest extends TestngBase{
	
	LoginPage login;
	HomePage home;
	
	@Test(description = "Verify User is able to Logout successfully",retryAnalyzer = retrymechanism.Retry.class)
	public void verifyUserIsAbleToLogoutSuccessfully() throws IOException
	{
		String username = ExcelUtility.readStringData(0, 0,"LoginPage");
		String password = ExcelUtility.readStringData(0, 1,"LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnLoginBtn();
		//HomePage home = new HomePage(driver);
		HomePage home = new HomePage(driver);
		home.clickAdminLink();
		login = home.clickOnLogoutBtn();
		String expected = "7rmart supermarket";
		String actual = login.getLoginText();
		Assert.assertEquals(actual,expected, "User was able to login with invalid credentials");
				
	}

}
