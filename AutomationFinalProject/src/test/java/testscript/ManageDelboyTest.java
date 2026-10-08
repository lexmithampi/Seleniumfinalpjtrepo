package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.PhoneNumber;

import constants.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryboyPage;
import seleniumcore.TestngBase;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageDelboyTest extends TestngBase{
	
	
	HomePage home;
	LoginPage login;
	ManageDeliveryboyPage delboyuser;
	
	String addDelboyUsernameField;
	String addDelboyPhoneField;
	String addDelboyEmailField;
	
	@Test(description = "Verify Admin is able to Add New Delivery Boy")
	public void verifyAdminUserIsAbleToAddNewDelboy() throws IOException
	{
		String username = ExcelUtility.readStringData(0, 0,"LoginPage");
		String password = ExcelUtility.readStringData(0, 1,"LoginPage");
		//String adminUsernameField = ExcelUtility.readStringData(0, 0,"AdminUserPage");
		//String adminPasswordField = ExcelUtility.readStringData(0, 1,"AdminUserPage");
		
		
		FakerUtility fake = new FakerUtility();
		String addDelboyNameField = fake.createRandomFullname();
		addDelboyEmailField = fake.createRandomEmail();
		addDelboyPhoneField = fake.createRandomPhoneNumber().toString();
		String addDelboyAddressField = fake.createRandomAddress();
		addDelboyUsernameField = fake.createRandomUsername();
		String addDelboyPasswordField = fake.createRandomPassword();
				
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnLoginBtn();
		//HomePage home = new HomePage(driver);
		ManageDeliveryboyPage delboyuser = new ManageDeliveryboyPage(driver);
		home.clickManageDelboyMoreInfoLink();
		delboyuser.clickOnManageDelboyNewBtn().enterNameOnAddDelboyNameField(addDelboyNameField).enterEmailOnAddDelboyEmailField(addDelboyEmailField).enterPhoneOnAddDelboyPhoneField(new CharSequence[]{addDelboyPhoneField.toString()}).pageScrollDown().enterAddressOnAddDelboyAddressField(addDelboyAddressField).enterUsernameOnAddDelboyUsernameField(addDelboyUsernameField).pageScrollDown().enterPasswordOnAddDelboyPasswordField(addDelboyPasswordField).clickAddDelboySavebtn();
		
		/*String expected = "Add-Delivery Boy";
		String actual = delboyuser.getAddDelboyText();
		Assert.assertEquals(actual,expected,Constant.ADDNEWDELBOYERROR);*/
		
		boolean delBoyAlert = delboyuser.getAddDelboyAlert();
		Assert.assertTrue(delBoyAlert,Constant.ADDNEWDELBOYERROR);
				
		
		
		
	}
	
	
	@Test(description = "Verify Admin is able to search the newly added user")
	public void verifyAdminUserIsAbleToSearchNewUser() throws IOException
	{
		String username = ExcelUtility.readStringData(0, 0,"LoginPage");
		String password = ExcelUtility.readStringData(0, 1,"LoginPage");
		//String adminUsernameField = ExcelUtility.readStringData(0, 0,"AdminUserPage");
		//String adminPasswordField = ExcelUtility.readStringData(0, 1,"AdminUserPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnLoginBtn();
		
		ManageDeliveryboyPage delboyuser = new ManageDeliveryboyPage(driver);
		home.clickManageDelboyMoreInfoLink();
		delboyuser.clickOnSearchBtn().enterNameOnSearchDelboyNameField(addDelboyUsernameField).enterEmailOnSearchDelboyEmailField(addDelboyEmailField).enterPhoneOnSearchDelboyPhoneField(addDelboyPhoneField).clickOnSearchButton();
		
		String expected = "Search List Delivery Boy";
		String actual = delboyuser.getSearchDelboyText();
		Assert.assertEquals(actual,expected,Constant.SEARCHDELBOYERROR);
				
		
		
	}
	

}
