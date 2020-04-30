package org.iit.mmp.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverScript 
{
	public static WebDriver driver;
	public static Properties prop;

	public DriverScript()
	{
		
	}
	
	public void loadProps(String filesrc)
	{
		try{
			prop = new Properties();
			//File src = new File("./mmp.properties/config.properties");
			
			File src = new File(filesrc);
			FileInputStream fis = new FileInputStream(src);
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("File not found: "+e.getMessage());
		}
	}


	// Initialize Browsers
	public void initBrowser(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	
	
}
