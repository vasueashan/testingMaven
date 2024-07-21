package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ByXPath;

public interface homeMenuPage {

	/*
	 * format for locator creation <pageName><locatorValue><Locatorid>
	 */

	By homePage_Menu_Id = By.id("react-burger-menu-btn");
	By homePage_logout_Id = By.id("logout_sidebar_link");
	By homePage_AddtoCort_id = By.id("add-to-cart-sauce-labs-backpack");
	By homePage_Pricebar = By.xpath("(//div[@class=\"inventory_item_price\"])[1]");
	By homePage_shopping_cart_link = By.xpath("//a[@class=\"shopping_cart_link\"]");
	By homePage_Remove_Id = By.id("remove-sauce-labs-backpack");

}
