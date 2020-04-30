package org.iit.mmp.patientmodule;

import org.iit.mmp.utility.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ViewReport extends DriverScript
{

	public static void main(String[] args) 
	{
		String reportName = "ECG";
		String reportDesc="ECG for the date 06/15/2019";
		ViewReport vp = new ViewReport();
		vp.initBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		PatientLogin pl = new PatientLogin();
		pl.patientLogin("ria1", "Ria12345");
		List<WebElement> tablerow = vp.retrieveReport();
		boolean reportPresent = vp.validateReport(tablerow, reportName, reportDesc);
		Assert.assertTrue(reportPresent);
		pl.logout();
		driver.close();
		//Assert.assertTrue(vp.validateReport(tablerow, reportName, reportDesc));	
		   
	} //main
	
	public List<WebElement> retrieveReport()
	{
		driver.findElement(By.linkText("Profile")).click();
		driver.findElement(By.linkText("View Reports")).click();
		
		List<WebElement> tablerow = driver.findElements(By.xpath("//table[contains(@class,'table')]/tbody/tr/td"));
		return tablerow;
	}
	
	public boolean validateReport(List<WebElement> tablerow, String reportName, String reportDesc)
	{
		boolean result= false;
		int i = 0;
		String tableItemText;
		for (WebElement tableitems : tablerow) 
		{
			i++;
			tableItemText = tableitems.getText();
		    System.out.println(i+"  "+tableItemText);
		    if((tableItemText.contains(reportName)) && (tableItemText.contains(reportDesc)))
		    {
		    	result = true;
		    	break; 
		    }  // if
		} // for
		System.out.println("result: "+result);	 
		return result;
		
	}
	
} //ViewReport
