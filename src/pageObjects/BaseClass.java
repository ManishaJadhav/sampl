package pageObjects;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BaseClass {
	public static WebDriver driver;
	public static boolean bResult;
	public  BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		BaseClass.bResult = true;
	}

}
