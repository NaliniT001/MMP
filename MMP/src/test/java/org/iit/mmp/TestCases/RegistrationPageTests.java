package org.iit.mmp.TestCases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.iit.mmp.adminmodule.AdminLogin;
import org.iit.mmp.adminmodule.ManageUser;
import org.iit.mmp.patientmodule.RegistrationPage;
import org.iit.mmp.utility.DriverScript;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationPageTests extends DriverScript
{
	static HashMap<String,String> hMap;
	@BeforeClass
	public void beforetest()
	{
		loadProps("./mmp.properties/config.properties");
	}
	
	
	@Test(priority=1)
	public void registerPatient() throws Exception
	{
		initBrowser(prop.getProperty("registerURL"));
		RegistrationPage rp = new RegistrationPage();
		hMap = rp.registerPatient();
		
		/*
		Iterator<Entry<String, String>> value = hMap.entrySet().iterator();
		while(value.hasNext())
		{
			System.out.println(value.next());
		}
		*/
		driver.close();
	}
	
	@Test(priority=2)
	public void acceptUser()
	{
		initBrowser(prop.getProperty("adminURL"));
		
		AdminLogin admnlogin = new AdminLogin();
		admnlogin.adminLogin(prop.getProperty("Adminusername"), prop.getProperty("Adminpassword"));
		String fname = hMap.get("firstname");
		
		ManageUser au = new ManageUser();
		au.userTab();
		au.checkStatus("Pending");
		au.selectUser(fname);
		String message = au.changeStatus("Accepted");
		System.out.println(fname+" - "+message);
		admnlogin.logout();
		driver.close();
	}
}
