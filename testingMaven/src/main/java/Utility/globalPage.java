package Utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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

}
