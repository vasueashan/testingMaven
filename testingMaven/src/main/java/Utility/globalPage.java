package Utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import BaseFactory.baseFactotyPage;

public class globalPage extends baseFactotyPage {

	public static void screenShort(String name) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String fileWithPath = System.getProperty("user.dir") + "\\ScreenShort\\" + name + ".png";
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);

	}

	public static String getData(String key) throws IOException {
		String fileWithPath = System.getProperty("user.dir") + "\\TestData\\testData.json";
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(new File(fileWithPath));
		String getText = jsonNode.get(key).asText();
		return getText;

	}

	public static void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
