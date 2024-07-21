package tests;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseFactory.baseFactotyPage;
import Utility.globalPage;
import Utility.utiltyPage;
import listeners.ListenersManager;
import pages.globalVariable;
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

		String getCookieValue="";
		utiltyPage.enterTextValue(loginSectionPage.login_UserName_Id, globalPage.getData("UserName"));
		utiltyPage.enterTextValue(loginSectionPage.login_Password_Id, globalPage.getData("PassWord"));
		utiltyPage.click(loginSectionPage.login_Login_Id);
		Assert.assertEquals(utiltyPage.getTittle(), "Swag Labs");
		
		//verifying cookies username
		Set<Cookie> cookiesList = driver.manage().getCookies();		
		for (Cookie getcookies : cookiesList) {
			getCookieValue = getcookies.getValue().toString();
		}		
		Assert.assertEquals(getCookieValue,globalPage.getData("UserName"));

	}

	// Tesct case-2: Check login Application with invalid credential
	@Test
	public void TC_002_loginWithInValidCredential() throws InterruptedException, IOException {

		//String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";

		utiltyPage.enterTextValue(loginSectionPage.login_UserName_Id, globalPage.getData("UserName"));
		utiltyPage.enterTextValue(loginSectionPage.login_Password_Id, globalPage.getData("PassWord") + 1);
		utiltyPage.click(loginSectionPage.login_Login_Id);
		String actualErrorMsg = utiltyPage.getText(loginSectionPage.login_errorMsg_h3);
		Assert.assertEquals(actualErrorMsg, globalVariable.expectedErrorMsg);

	}

	// Tesct case-3: Check logout validation

	@Test
	public void TC_003_logoutValidation() throws InterruptedException, IOException {
		
		utiltyPage.enterTextValue(loginSectionPage.login_UserName_Id, globalPage.getData("UserName"));
		utiltyPage.enterTextValue(loginSectionPage.login_Password_Id, globalPage.getData("PassWord"));
		utiltyPage.click(loginSectionPage.login_Login_Id);
		globalPage.waitForElement(homeMenuPage.homePage_Menu_Id);
		Assert.assertEquals(utiltyPage.getTittle(), "Swag Labs");
		utiltyPage.click(homeMenuPage.homePage_Menu_Id);
		globalPage.waitForElement(homeMenuPage.homePage_logout_Id);
		utiltyPage.click(homeMenuPage.homePage_logout_Id);

	}

	// Tesct case-4: Check Add to cart and remove Validation

	@Test
	public void TC_004_AddToCart_Remove_Validation() throws InterruptedException, IOException {		
		utiltyPage.enterTextValue(loginSectionPage.login_UserName_Id, globalPage.getData("UserName"));
		utiltyPage.enterTextValue(loginSectionPage.login_Password_Id, globalPage.getData("PassWord"));
		utiltyPage.click(loginSectionPage.login_Login_Id);
		utiltyPage.click(homeMenuPage.homePage_AddtoCort_id);
		String getPrice = utiltyPage.getText(homeMenuPage.homePage_Pricebar);
		utiltyPage.click(homeMenuPage.homePage_shopping_cart_link);
		String expgetPrice = utiltyPage.getText(homeMenuPage.homePage_Pricebar);
		Assert.assertEquals(expgetPrice, getPrice);

	}

	// Tesct case-5: Remove Item from Add to cart box Validation

	@Test
	public void TC_004_Remove_AddToCart_Validation() throws InterruptedException, IOException {		
		utiltyPage.enterTextValue(loginSectionPage.login_UserName_Id, globalPage.getData("UserName"));
		utiltyPage.enterTextValue(loginSectionPage.login_Password_Id, globalPage.getData("PassWord"));
		utiltyPage.click(loginSectionPage.login_Login_Id);
		utiltyPage.click(homeMenuPage.homePage_AddtoCort_id);
		utiltyPage.click(homeMenuPage.homePage_shopping_cart_link);
		utiltyPage.click(homeMenuPage.homePage_Remove_Id);

	}

}
