package listeners;

import java.io.File;
import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Utility.globalPage;

public class ListenersManager implements ITestListener {

	public void onTestStart(ITestResult result) {

		String fileWithPath = System.getProperty("user.dir") + "\\ScreenShort";
		File index = new File(fileWithPath);
		if (index.exists()) {
			index.delete();
		}

	}

	public void onTestSuccess(ITestResult result) {

		try {
			globalPage.screenShort(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestFailure(ITestResult result) {
		try {
			globalPage.screenShort(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
