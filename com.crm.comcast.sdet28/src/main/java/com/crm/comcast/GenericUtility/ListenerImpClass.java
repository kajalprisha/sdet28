package com.crm.comcast.GenericUtility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpClass extends BaseClass implements ITestListener {

	public void onTestFailure(ITestResult result) {
		String testCaseName=result.getMethod().getMethodName();
		System.out.println(testCaseName);
		
		//take screenshot code
		EventFiringWebDriver event = new EventFiringWebDriver(BaseClass.sdriver);
		File source=event.getScreenshotAs(OutputType.FILE);
		File destination=new File("./errorshot/"+testCaseName+".png");
		source.renameTo(destination);
		//e.printStackTrace();
		
	}

}
