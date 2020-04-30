package org.iit.mmp.adminmodule;

import org.iit.mmp.utility.DriverScript;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateReport extends DriverScript
{
	
	public void createReport(String appDate, String  reportName, String  reportFile, String  reportDesc) throws Exception
	{
			driver.findElement(By.xpath("//input[@value='Reports']")).click();
			
			WebElement dd1 = driver.findElement(By.id("app_date"));
			Select sel1 = new Select(dd1);
			sel1.selectByVisibleText(appDate);
			
			driver.findElement(By.id("exampleInputcardnumber1")).sendKeys(reportName);
			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(reportFile);
			
			driver.findElement(By.name("report_desc")).sendKeys(reportDesc);
			
			driver.findElement(By.xpath("//input[@value='submit']")).click();
					
	} // createReport

} // CreateReport
