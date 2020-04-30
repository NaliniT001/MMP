package org.iit.mmp.TestCases;

import java.util.List;


import org.iit.mmp.adminmodule.AdminLogin;
import org.iit.mmp.adminmodule.CreateReport;
import org.iit.mmp.adminmodule.RetrievePatient;
import org.iit.mmp.patientmodule.PatientLogin;
import org.iit.mmp.patientmodule.ViewReport;
import org.iit.mmp.utility.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateReportsTest extends DriverScript
{
	@BeforeClass
	public void beforetest()
	{
		loadProps("./mmp.properties/config.properties");
	}
	
	@Test(priority = 1)
	public void createReport() throws Exception
	{
		initBrowser(prop.getProperty("adminURL"));
		
		AdminLogin al = new AdminLogin();
		al.adminLogin(prop.getProperty("Adminusername"), 
				prop.getProperty("Adminpassword"));
		
		RetrievePatient rp = new RetrievePatient();
		rp.retrievePatient(prop.getProperty("patientSSN"), 
				prop.getProperty("patientFIRSTNAME"));
		
		CreateReport cr = new CreateReport();
		//cr.createReport(prop.getProperty("apptDate"), prop.getProperty("reportName"), "C:\\WORKSPACE2\\Test_Report.txt", prop.getProperty("reportDesc"));
		cr.createReport(prop.getProperty("apptDate"), prop.getProperty("reportName"), prop.getProperty("reportFile"), prop.getProperty("reportDesc"));
		al.logout();	
	}
	
	@Test(priority = 2)
	public void validateReport()
	{
		initBrowser(prop.getProperty("patientURL"));
		
		PatientLogin pl = new PatientLogin();
		pl.patientLogin(prop.getProperty("Patientusername"), prop.getProperty("Patientpassword"));
		
		ViewReport vp = new ViewReport();
		List<WebElement> reportList = vp.retrieveReport();
		boolean reportPresent = vp.validateReport(reportList, prop.getProperty("reportName"), prop.getProperty("reportDesc"));
		Assert.assertTrue(reportPresent);
		pl.logout();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	
	
	
}
