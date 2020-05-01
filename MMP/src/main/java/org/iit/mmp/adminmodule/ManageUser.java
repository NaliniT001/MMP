package org.iit.mmp.adminmodule;

import java.util.List;

import org.iit.mmp.utility.DriverScript;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ManageUser extends DriverScript
{

	public static void main(String[] args) 
	{
		ManageUser au = new ManageUser();
		au.initBrowser("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		AdminLogin al = new AdminLogin();
		al.adminLogin("Thomas_444", "Edison_444");
		au.userTab();
		au.checkStatus("Pending");
		au.selectUser("testFNYN");
		String message = au.changeStatus("Accepted");
		System.out.println(message);
		al.logout();
		driver.close();
	}
	
	public void userTab()
	{
		driver.findElement(By.linkText("Users")).click();
	}
	
	public void checkStatus(String status)
	{			
		WebElement statuselement = driver.findElement(By.id("search"));
		Select statusvalue = new Select(statuselement);
		statusvalue.selectByVisibleText(status);
	}
	
	public void selectUser(String firstName)
	{		
		try
		{
			driver.findElement(By.linkText(firstName)).click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			driver.findElement(By.linkText(firstName)).click();
		}	
	}
	
	public String changeStatus(String status)
	{
		WebElement statuselement = driver.findElement(By.id("sapproval"));
		Select statusvalue = new Select(statuselement);
		statusvalue.selectByVisibleText(status);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Alert alrt = driver.switchTo().alert();
		String successMsg = alrt.getText();
		alrt.accept();
		return successMsg;
	}

}
