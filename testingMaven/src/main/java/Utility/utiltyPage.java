package Utility;

import java.sql.Driver;

import org.openqa.selenium.By;

import BaseFactory.baseFactotyPage;

public class utiltyPage extends baseFactotyPage {

	public static String getTittle() {
		return driver.getTitle();
	}

	public static String getText(String locator) {
		return driver.findElement(By.xpath(locator)).getText();
	}

	public static void enterTextValue(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
		;
	}

	public static void click(By value) {
		driver.findElement(value).click();
	}

	public static String getText(By locator) {
		return driver.findElement(locator).getText();
	}

}
