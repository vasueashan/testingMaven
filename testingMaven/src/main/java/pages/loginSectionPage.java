package pages;

import org.openqa.selenium.By;

public interface loginSectionPage {

	/*
	 * format for locator creation <pageName><locatorValue><Locatorid>
	 */

	By login_UserName_Id = By.id("user-name");
	By login_Password_Id = By.id("password");
	By login_Login_Id = By.id("login-button");
	By login_errorMsg_h3 = By.xpath("//h3[@data-test=\"error\"]");
}
