package testCases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import utility.Constant;
import utility.ExcelUtils;

public class main_test {
	
	public static void main(String args[]) throws Exception
	{
		WebDriver driver;

		
		String time = "05:11 AM";
		
		String ap = time.substring(6,8);
		
		System.out.println(ap);
	}

}
