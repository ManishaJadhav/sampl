package appModules;

import pageObjects.Login_Page;
import utility.Constant;
import utility.ExcelUtils;

public class LogIn_Action {
	
	public static void Excute_login(int iTestCaseRow) throws Exception
	
	{
		try{
			Thread.sleep(4000);
			Login_Page.txt_username().clear();
			
			String pas = ExcelUtils.getCellData(iTestCaseRow, Constant.UserName);
			
			System.out.println(pas);
		Login_Page.txt_username().sendKeys(pas);
		
		String pass = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
		System.out.println(pass);
		Thread.sleep(4000);
		
		Login_Page.txt_Password().sendKeys("Mobileuser@1");
		Login_Page.back();
		
		Thread.sleep(4000);
		Login_Page.btn_LogIN().click();
		Thread.sleep(10000);
		
		Login_Page.link_Signup().click();
		Thread.sleep(10000);
		
		 Login_Page.btn_service().click();
		//Thread.sleep(10000);
		

		Login_Page.btn_service1().click();
		 
		Thread.sleep(10000);
			/*	Login_Page.drop_down_select().click();
		
		Thread.sleep(10000);
		Login_Page.add_entry().click();
		*/
		//Thread.sleep(10000);
		
		String x = Login_Page.timein().getAttribute("name");
	    System.out.println("Current time ="+ x);
		Login_Page.timein().click();
		Thread.sleep(10000);
		
	Login_Page.hrs(x);
		
	Thread.sleep(1000);
	Login_Page.min(x);

		Thread.sleep(1000);
		Login_Page.AP(x);
		
		Thread.sleep(1000);
	Login_Page.btn_set();
//		
//		Thread.sleep(10000);
//		Login_Page.btn_timeout().click();
		
		ExcelUtils.setCellData("Passed", iTestCaseRow, Constant.Col_Result);
		
		
		}
		catch(Exception e)
		{
	System.out.println(e.getMessage());
		}
	}

}
