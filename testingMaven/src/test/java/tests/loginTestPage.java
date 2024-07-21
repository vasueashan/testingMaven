package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseFactory.baseFactotyPage;
import Utility.globalPage;
import Utility.utiltyPage;
import listeners.ListenersManager;
import pages.homeMenuPage;
import pages.loginSectionPage;

//@Listeners(ListenersManager.class)
public class loginTestPage extends baseFactotyPage {

	@BeforeMethod
	public void LunchApplication() {
		loginTestPage.getDriver();

	}

	@AfterMethod
	public void CloseApplicationn() {
		loginTestPage.closeDriver();

	}

	// Tesct case-1: Check login Application with valid credential

	@Test
	public void TC_001_loginWithValidCredential() throws InterruptedException, IOException {

		System.out.println("Its working fine");
		utiltyPage.enterTextValue(loginSectionPage.login_UserName_Id, globalPage.getData("UserName"));
		utiltyPage.enterTextValue(loginSectionPage.login_Password_Id, globalPage.getData("PassWord"));
		utiltyPage.click(loginSectionPage.login_Login_Id);
		Thread.sleep(3000);
		Assert.assertEquals(utiltyPage.getTittle(), "Swag Labs");
		Thread.sleep(2000);		
	}

	// Tesct case-2: Check login Application with invalid credential
	@Test
	public void TC_002_loginWithInValidCredential() throws InterruptedException, IOException {

		String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";

		utiltyPage.enterTextValue(loginSectionPage.login_UserName_Id, globalPage.getData("UserName"));
		utiltyPage.enterTextValue(loginSectionPage.login_Password_Id, globalPage.getData("PassWord")+1);
		utiltyPage.click(loginSectionPage.login_Login_Id);
		Thread.sleep(2000);
		String actualErrorMsg = utiltyPage.getText(loginSectionPage.login_errorMsg_h3);
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		Thread.sleep(2000);		
	}

	// Tesct case-3: Check logout validation

	@Test
	public void TC_003_logoutValidation() throws InterruptedException, IOException {

		System.out.println("Its working fine");
		utiltyPage.enterTextValue(loginSectionPage.login_UserName_Id, globalPage.getData("UserName"));
		utiltyPage.enterTextValue(loginSectionPage.login_Password_Id, globalPage.getData("PassWord"));
		utiltyPage.click(loginSectionPage.login_Login_Id);
		Thread.sleep(2000);
		Assert.assertEquals(utiltyPage.getTittle(), "Swag Labs");
		Thread.sleep(1000);
		utiltyPage.click(homeMenuPage.homePage_Menu_Id);
		Thread.sleep(1000);
		utiltyPage.click(homeMenuPage.homePage_logout_Id);
		Thread.sleep(1000);		
	}

	// Tesct case-4: Check Add to cart and remove Validation

	@Test
	public void TC_004_AddToCart_Remove_Validation() throws InterruptedException, IOException {
		System.out.println("Its working fine");
		utiltyPage.enterTextValue(loginSectionPage.login_UserName_Id, globalPage.getData("UserName"));
		utiltyPage.enterTextValue(loginSectionPage.login_Password_Id, globalPage.getData("PassWord"));
		utiltyPage.click(loginSectionPage.login_Login_Id);
		Thread.sleep(1000);
		utiltyPage.click(homeMenuPage.homePage_AddtoCort_id);
		Thread.sleep(1000);
		String getPrice = utiltyPage.getText(homeMenuPage.homePage_Pricebar);		
		utiltyPage.click(homeMenuPage.homePage_shopping_cart_link);
		Thread.sleep(2000);
		String expgetPrice = utiltyPage.getText(homeMenuPage.homePage_Pricebar);
		Assert.assertEquals(expgetPrice, getPrice);
		Thread.sleep(1000);		
	}

	// Tesct case-5:  Remove Item from Add to cart box  Validation

	@Test
	public void TC_004_Remove_AddToCart_Validation() throws InterruptedException, IOException {
		System.out.println("Its working fine");
		utiltyPage.enterTextValue(loginSectionPage.login_UserName_Id, globalPage.getData("UserName"));
		utiltyPage.enterTextValue(loginSectionPage.login_Password_Id, globalPage.getData("PassWord"));
		utiltyPage.click(loginSectionPage.login_Login_Id);
		Thread.sleep(1000);
		utiltyPage.click(homeMenuPage.homePage_AddtoCort_id);
		Thread.sleep(1000);		
		utiltyPage.click(homeMenuPage.homePage_shopping_cart_link);
		Thread.sleep(2000);
		utiltyPage.click(homeMenuPage.homePage_Remove_Id);
		Thread.sleep(2000);		
	}

}
