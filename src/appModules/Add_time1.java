package appModules;

import pageObjects.Add_time;
import utility.Constant;
import utility.ExcelUtils;

public class Add_time1 {
	
	public static void Excute_login(int iTestCaseRow) throws Exception
	
	{
		try{
			Thread.sleep(4000);
			Add_time.txt_username().clear();
			
			String pas = ExcelUtils.getCellData(iTestCaseRow, Constant.UserName);
			
			
			Add_time.txt_username().sendKeys(pas);
		
		String pass = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
		
		Thread.sleep(4000);
		
		Add_time.txt_Password().sendKeys(pass);
		
		
		Thread.sleep(4000);
		Add_time.btn_LogIN().click();
		Thread.sleep(10000);
		
		Add_time.btn_ADDTime().click();
		Thread.sleep(10000);
		
		Add_time.btn_ADDservices().click();
		Thread.sleep(10000);
		
		Add_time.btn_selectservices().click();
		Thread.sleep(10000);
		
		
		Add_time.btn_chkin().click();
		Thread.sleep(10000);
		
		Add_time.btn_edit().click();
		Thread.sleep(10000);
		
		
		ExcelUtils.setCellData("Passed", iTestCaseRow, Constant.Col_Result);
		
		
		}
		catch(Exception e)
		{
	System.out.println(e.getMessage());
		}
	}



}
