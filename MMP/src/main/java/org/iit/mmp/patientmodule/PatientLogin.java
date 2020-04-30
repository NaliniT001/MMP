package org.iit.mmp.patientmodule;

import org.iit.mmp.utility.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientLogin extends DriverScript
{
	/*
	 * WebDriver driver;
	 */
	/*
	public PatientLogin(WebDriver driver)
	{
		this.driver = driver;
	}
	*/
	
	public void patientLogin(String patient_username, String patient_password)
	{
		driver.findElement(By.id("username")).sendKeys(patient_username);
		driver.findElement(By.id("password")).sendKeys(patient_password);
		driver.findElement(By.name("submit")).click();
	}
	
	// Patient Logout
	
	public void logout()
	{
		driver.findElement(By.linkText("Logout")).click(); 
	}
		
}
