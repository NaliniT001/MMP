package org.iit.mmp.TestCases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.iit.mmp.patientmodule.RegistrationPage;
import org.iit.mmp.utility.DriverScript;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationPageTests extends DriverScript
{
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
		HashMap<String,String> hMap = rp.registerPatient();
		//Iterator<String> key =  hMap.keySet().iterator();
		Iterator<Entry<String, String>> value = hMap.entrySet().iterator();
		while(value.hasNext())
		{
			System.out.println(value.next());
		}
	}
}
