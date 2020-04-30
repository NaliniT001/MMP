package org.iit.mmp.adminmodule;

import org.iit.mmp.utility.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RetrievePatient extends DriverScript
{
	
	// retrieve patient
	public void retrievePatient(String patient_ssn, String patient_firstname) throws Exception
	{
		driver.findElement(By.linkText("Patients")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("search")).sendKeys(patient_ssn);
		driver.findElement(By.xpath("//input[@value = 'search']")).click();
			
		String path = "//div[@id='show']//a[contains(text(),'"+patient_firstname+"')]";
		System.out.println(path);
		Thread.sleep(3000);
		driver.findElement(By.xpath(path)).click();
		Thread.sleep(3000);
	}
}
