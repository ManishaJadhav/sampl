package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.CellStyle;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BaseClass;

import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import appModules.Add_time1;
import appModules.LogIn_Action;
import io.appium.java_client.android.AndroidDriver;
public class Login_with_Valid_Data {
public static WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow = 1;
	CellStyle style;
	
  // Following TestNg Test case pattern, and divided a Test case in to three different part.
  // In Before Method, your code will always be the same for every other test case.
  // In other way before method is your prerequisites of your main Test Case	
  @BeforeTest
  public void beforeMethod() throws Exception {
	  
	  	DOMConfigurator.configure("log4j.xml");
	  	
	  	// Getting the Test Case name, as it will going to use in so many places
	  	// The main use is to get the TestCase row from the Test Data Excel sheet
	  	sTestCaseName = this.toString();
	  	// From above method we get long test case name including package and class name etc.
	  	// The below method will refine your test case name, exactly the name use have used
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
	  	// Start printing the logs and printing the Test Case name
		Log.startTestCase(sTestCaseName);
		
		// Setting up the Test Data Excel file using Constants variables
		// For Constant Variables please see http://www.toolsqa.com/constant-variables/
		// For setting up Excel for Data driven testing, please see http://www.toolsqa.com/data-driven-testing-excel-poi/
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"InputSheet");
		
		// Fetching the Test Case row number from the Test Data Sheet
		// This row number will be feed to so many functions, to get the relevant data from the Test Data sheet 
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		// Launching the browser, this will take the Browser Type from Test Data Sheet 
	driver = Utils.OpenBrowser(iTestCaseRow);
		
		
	ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"InputSheet");
		
		
		// Initializing the Base Class for Selenium driver
		// Now we do need to provide the Selenium driver to any of the Page classes or Module Actions
		// Will soon write a post on Base Class
		new BaseClass(driver);  
		
	
		   
      }

  
  
		
  
  // This is the starting of the Main Test Case
 @Test
  public void Testsc() throws Exception
  {
	  // Every exception thrown from any class or method, will be catch here and will be taken care off
	  
	  try{
		  
		  
		  String exe = ExcelUtils.getCellData(iTestCaseRow, Constant.Exe);
	System.out.println(exe);
		if(exe.equals("Y")||exe.equals("Yes")){
			
		
			
		// LogIn_Action.Excute_login(iTestCaseRow);	
			Add_time1.Excute_login(iTestCaseRow); 
		 Reporter.log("Login gets sucessful");
		}
		
		else
		{
			
			System.out.println("Test case gets Skipped "+ sTestCaseName);
		}
	
	  }catch (Exception e){
	  } 
		
  }
	
  // Its time to close the finish the test case		
@AfterMethod
public void afterMethod() throws Exception 
{
	    // Printing beautiful logs to end the test case
	 Log.endTestCase(sTestCaseName);
	// Runtime.getRuntime().exec("D:\\flightSpeak\\Autoit\\Reportgenrate.exe");
	    // Closing the opened driver
	 ((AndroidDriver)driver).closeApp();
  		}

}