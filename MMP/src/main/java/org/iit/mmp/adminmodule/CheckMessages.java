package org.iit.mmp.adminmodule;

import java.util.List;

import org.iit.mmp.utility.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckMessages extends DriverScript
{

	/*
	WebDriver driver;
	
	public CheckMessages(WebDriver driver)
	{
		this.driver = driver;
	}
	*/
	
		
	// Get  messages
	
	public List<WebElement> getMessages() throws Exception
	{
		driver.findElement(By.linkText("Messages")).click();
		Thread.sleep(3000);
		List<WebElement> msgrows = driver.findElements(By.xpath("//table[@class='table']//tr"));
		return msgrows;
	}
	
	public boolean validateMessages(List<WebElement> msgrows, String patientName, String subject, String message) throws Exception
	{
		int rows = msgrows.size();
		boolean result=false;
		String tableRowText;
		outerloop:
		for(int i=0; i<rows; i=i+2)
		{
			tableRowText = msgrows.get(i).getText();
			System.out.println(tableRowText);
			if((tableRowText.contains(patientName)) & (tableRowText.contains(subject)))
			{
				tableRowText = msgrows.get(i+1).getText();
				if(tableRowText.contains(message))
				{
					System.out.println(tableRowText);
					System.out.println("Found");
					result = true;
					break outerloop;
				}
			}
		}
		return result;
	}
	
}
