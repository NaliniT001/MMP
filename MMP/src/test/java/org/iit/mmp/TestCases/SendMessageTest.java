package org.iit.mmp.TestCases;

import java.util.List;

import org.iit.mmp.adminmodule.AdminLogin;
import org.iit.mmp.adminmodule.CheckMessages;
import org.iit.mmp.patientmodule.PatientLogin;
import org.iit.mmp.patientmodule.SendMessage;
import org.iit.mmp.utility.DriverScript;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SendMessageTest extends DriverScript
{
	@BeforeClass
	public void beforetests()
	{
		loadProps("./mmp.properties/config.properties");
	}
	
	@Test(priority=1)
	public void sendMessage() throws Exception
	{
		initBrowser(prop.getProperty("patientURL"));
		
		PatientLogin pl = new PatientLogin();
		pl.patientLogin(prop.getProperty("Patientusername"), prop.getProperty("Patientpassword"));
		
		SendMessage sm = new SendMessage();
		sm.createMessage(prop.getProperty("subject"), 
						prop.getProperty("message"));
		pl.logout();
		driver.close();
	}
	
	@Test(priority=2)
	public void validateMessage() throws Exception
	{
		initBrowser(prop.getProperty("adminURL"));
		
		AdminLogin al = new AdminLogin();
		al.adminLogin(prop.getProperty("Adminusername"), prop.getProperty("Adminpassword"));
		
		CheckMessages cm = new CheckMessages();
		List<WebElement> msgrows = cm.getMessages();
		
		boolean msgfound = cm.validateMessages(msgrows, 
		prop.getProperty("patientFIRSTNAME"),
		prop.getProperty("subject"), 
		prop.getProperty("message"));
		
		System.out.println(msgfound);
		
		al.logout();
		driver.close();		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
}

