package org.iit.mmp.TestCases;

import org.iit.mmp.adminmodule.AdminLogin;
import org.iit.mmp.adminmodule.CreateFeePage;
import org.iit.mmp.adminmodule.RetrievePatient;
import org.iit.mmp.patientmodule.PatientLogin;
import org.iit.mmp.patientmodule.PayFee;
import org.iit.mmp.utility.DriverScript;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateFeeTest extends DriverScript
{
	@BeforeClass
	public void beforetest()
	{
		loadProps("./mmp.properties/config.properties");
	}
	
	
	@Test(priority=1)
	public void createFee() throws Exception
	{
		initBrowser(prop.getProperty("adminURL"));
		
		AdminLogin admnlogin = new AdminLogin();
		admnlogin.adminLogin(prop.getProperty("Adminusername"), prop.getProperty("Adminpassword"));
		
		RetrievePatient rp = new RetrievePatient();
		rp.retrievePatient(prop.getProperty("patientSSN"), prop.getProperty("patientFIRSTNAME"));
		
		CreateFeePage cfp = new CreateFeePage();
		cfp.createFee(prop.getProperty("apptdate"), prop.getProperty("service"));
		admnlogin.logout();
		driver.close();
	}
	
	@Test(priority=2)
	public void payfee() throws Exception
	{
	
		initBrowser(prop.getProperty("patientURL"));
		
		PatientLogin pl = new PatientLogin();
		pl.patientLogin(prop.getProperty("Patientusername"), prop.getProperty("Patientpassword"));
		
		PayFee pf = new PayFee();
		pf.payFees(prop.getProperty("fee"), 
				prop.getProperty("patientNAME"), 
				prop.getProperty("cardtype"), 
				prop.getProperty("cardnumber"), 
				prop.getProperty("cardmonth"), 
				prop.getProperty("cardyear"), 
				prop.getProperty("cvvnumber"));
		pl.logout();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
