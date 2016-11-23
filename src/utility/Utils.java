package utility;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	public static WebDriver driver ;
	
	public static String getTestCaseName(String sTestCase)throws Exception{
		String value = sTestCase;
		try{
		//	int posi = value.indexOf("@");
			value = value.substring(10, 17);
			//System.out.println(value);
			return value;
				}catch (Exception e){
			Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw (e);
					}
			}
	
	
	/* public static void waitForElement(WebElement element){
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	 	}*/
		
	 public static void takeScreenshot(AndroidDriver  driver, String sTestCaseName) throws Exception{
			try{
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + sTestCaseName +".jpg"));	
			} catch (Exception e){
				Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
				throw new Exception();
			}
		}

	public static WebDriver OpenBrowser(int iTestCaseRow) {
		String sBrowserName;
		try{
		
		WebDriver driver;

		
		 
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Capabilities");
		
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  
		  String BROWSER_NAME = ExcelUtils.getCellData(Constant.Android_capabilities, Constant.BROWSER_NAME);
		  capabilities.setCapability("BROWSER_NAME", BROWSER_NAME);
			
			String VERSION = ExcelUtils.getCellData(Constant.Android_capabilities, Constant.VERSION);
			capabilities.setCapability("VERSION", VERSION); 
			
			String deviceName = ExcelUtils.getCellData(Constant.Android_capabilities, Constant.deviceName);
			capabilities.setCapability("deviceName",deviceName);
			
			
			String platformName = ExcelUtils.getCellData(Constant.Android_capabilities, Constant.platformName);
			capabilities.setCapability("platformName",platformName);
			
			String path = ExcelUtils.getCellData(Constant.Android_capabilities, Constant.path);
			File file = new File (path);
			 capabilities.setCapability("app",file.getAbsolutePath());
			 capabilities.setCapability("resetKeyboard", true);
		   driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		   
		    return driver;
		   
		}catch (Exception e){
			Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
		}
		return driver;
		
		// TODO Auto-generated method stub
		
	}
	 
	 
	}
