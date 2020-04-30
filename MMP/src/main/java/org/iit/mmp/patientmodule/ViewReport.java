package org.iit.mmp.patientmodule;

import org.iit.mmp.utility.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ViewReport extends DriverScript
{
	
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
