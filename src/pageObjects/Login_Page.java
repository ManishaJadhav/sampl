package pageObjects;



import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.ScrollsTo;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import utility.Constant;
import utility.ExcelUtils;

import java.util.HashMap;
import java.util.List;

import org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page extends BaseClass {
    
	static WebElement element;
	 public Login_Page(WebDriver driver){
     	super(driver);
 }      

	 public static WebElement  txt_username()
	 
	 {
		 element = driver.findElement(By.xpath("//android.widget.EditText[@text = 'Username']"));
		 
		return element;
		 
	 }
	 

	 public static WebElement  txt_Password()
	 
	 {
		
		 element = driver.findElement(By.xpath("//android.widget.EditText[@resource-id ='com.paragyte.publicpartnerships.evv:id/activityLoginEdtPassword']"));
		 
		return element;
		
		 
	 }
	 
 public static WebElement  btn_LogIN()
	 
	 {
		 element = driver.findElement(By.xpath("//android.widget.Button[@text = 'Login']"));
		 
		return element;
		 
	 }
 public static void  back()
 
 {
	 ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.BACK);
	 
	
	 
 }
 


	public static WebElement drop_down_select()

	{
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Add Timesheet")));
		element = driver.findElement(By.name("Add Timesheet"));	  		

		return element;

	}

	public static WebElement link_Signup() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RelativeLayout[@resource-id = 'com.paragyte.publicpartnerships.evv:id/activityEvvTabsBottomPayPeriod']")));
		
		element = driver.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id = 'com.paragyte.publicpartnerships.evv:id/activityEvvTabsBottomPayPeriod']"));

		return element;
	}

	public static WebElement add_entry() {
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Add Entry")));
		
		element = driver.findElement(By.name("Add Entry"));

		return element;
	}

	
public static WebElement timein() {
		
	
	
	WebDriverWait wait = new WebDriverWait(driver, 100);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[contains(@resource-id,'TimeIn')]")));
	element =driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'TimeIn')]"));

		return element;
	}
 
public static void hrs(String x1) throws Exception {
	TouchAction ta = new TouchAction((MobileDriver) driver);

	String hr = ExcelUtils.getCellData(2, Constant.TimeIN_HR);
	String hr1 = x1.substring(0, 2);
	
	System.out.println(hr + hr1);
	Integer x = Integer.valueOf(hr);
	Integer y = Integer.valueOf(hr1);
	int diff = y-x;
	if (x== 12)
	{
		for (int i =0;i<y;i++)
		{
			ta.tap(126, 890).perform();
			Thread.sleep(2000);
		}
			
	}
	else if(y>x)
	{
		for (int i =0;i<diff;i++)
		{
			ta.tap(126, 890).perform();
			Thread.sleep(2000);
		}
	
	}
	else
	{
	for (int i =1;i<=diff;i++)
	{
		ta.tap(120, 1055).perform();
		Thread.sleep(2000);
	}
	}
}

public static void min(String x2) throws Exception {
	TouchAction ta = new TouchAction((MobileDriver) driver);
	
	String hr = ExcelUtils.getCellData(2, Constant.TimeIN_Min);
	System.out.println(hr);
	Integer x = Integer.valueOf(hr);
	String min1 = x2.substring(3, 6);
	Integer min = Integer.valueOf(hr);
	
	if (min>x)
	{
	int diff = min-x;
	for (int i =0;i<diff;i++)
	{
		ta.tap(360, 890).perform();
		Thread.sleep(1000);
	}
	
	}
	else
	{
	
	for (int i =0;i<x;i++)
	{
		ta.tap(360, 1055).perform();
		Thread.sleep(1000);
	}
	}
	
}

public static void AP(String Amp) throws Exception {
	TouchAction ta = new TouchAction((MobileDriver) driver);
	
	String ap = ExcelUtils.getCellData(2, Constant.TimeIN_AP);
	String ate = Amp.substring(6,8);
	System.out.println(ate +        ap);
	 if(ap.contains(ate))
	 {
		 ta.tap(590, 978).perform();

	
	 }

	 else
	 {
			ta.tap(590, 1055).perform();
		
	 }
}


public static WebElement btn_service() {
	

	WebDriverWait wait = new WebDriverWait(driver, 100);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.GridView[@index='3']/android.view.View[@index = '1']/android.view.View[@index = '0']")));
	element =driver.findElement(By.xpath("//android.widget.GridView[@index='3']/android.view.View[@index = '1']/android.view.View[@index = '0']"));
//	WebDriverWait wait1 = new WebDriverWait(driver, 100);
//	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("ATTENDANT CARE SERVICES")));
//	
// driver.findElement(By.name("ATTENDANT CARE SERVICES"));
	return element;
}

public static WebElement btn_service1() {
	
	WebDriverWait wait = new WebDriverWait(driver, 100);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.GridView[@index='5']/android.view.View[@index = '1']/android.view.View[@index = '0']/android.view.View[@index = '0']")));
		element =driver.findElement(By.xpath("//android.widget.GridView[@index='5']/android.view.View[@index = '1']/android.view.View[@index = '0']/android.view.View[@index = '0']"));

		return element;
}


public static void btn_set() {
	// element = driver.findElement(By.xpath("//android.widget.Button[@content-desc='Set']"));
	// 		return element;
	 		
	 		TouchAction ta = new TouchAction((MobileDriver) driver);	
	 		 ta.tap(180, 1146).perform();
}


public static WebElement btn_timeout() {
	 element = driver.findElement(By.id("ConsumerServiceAndPeriod_TimeOut"));
	 	return element;
	 	
}
}

