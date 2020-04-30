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
	
	public static void main(String[] args) throws Exception 
	{

			String admin_username="Thomas_444";
			String admin_password="Edison_444";
			String patient_ssn="462379048";
			String patient_firstname="Ria";
			String appDate="04/15/2020";
			String reportName = "MRI Report";
			String reportDesc="Report of leg MRI";
			String reportFile="C:\\WORKSPACE2\\Test_Report.txt";
				
			String url="http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php";
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			
			System.out.println(admin_username+"  "+admin_password);
			
			AdminLogin al = new AdminLogin();
			al.adminLogin(admin_username, admin_password);
			
			RetrievePatient rp = new RetrievePatient();
			rp.retrievePatient(patient_ssn, patient_firstname);
			
			CreateReport cr = new CreateReport();
			cr.createReport(appDate, reportName, reportFile, reportDesc);	
			
	} // main()
	
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
