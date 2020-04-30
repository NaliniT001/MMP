package org.iit.mmp.adminmodule;

import org.iit.mmp.utility.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLogin extends DriverScript
{
	// Admin Login
	
	public void adminLogin(String admin_username, String admin_password)
	{
			driver.findElement(By.id("username")).sendKeys(admin_username);
			driver.findElement(By.id("password")).sendKeys(admin_password);
			driver.findElement(By.name("admin")).click();
	}
	
	// Admin Logout
	
		public void logout()
		{
			 driver.findElement(By.linkText("Logout")).click(); 
		}
	
	
}
