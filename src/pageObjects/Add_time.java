package pageObjects;






import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Add_time extends BaseClass {
    
	static WebElement element;
	 public Add_time(WebDriver driver){
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
 
public static WebElement  btn_ADDTime()
 
 {
	 element = driver.findElement(By.xpath("//android.widget.TextView[@text = 'Add Time']"));
	 
	return element;
	 
 }
 
public static WebElement  btn_ADDservices()

{
	 element = driver.findElement(By.xpath("//android.widget.TextView[@text = 'WILLIE CANTRELL']"));
	 
	return element;
	 
}

public static WebElement  btn_selectservices()

{
	 element = driver.findElement(By.xpath("//android.widget.TextView[@text = 'ATTENDANT CARE SERVICES']"));
	 
	return element;
	 
}

public static WebElement  btn_chkin()

{
	 element = driver.findElement(By.xpath("//android.widget.Button[@text = 'Clock In']"));
	 
	return element;
	 
}





public static WebElement  btn_edit()

{
	 element = driver.findElement(By.xpath("//android.widget.TextView[@text = 'edit']"));
	 
	return element;
	 
}


}
