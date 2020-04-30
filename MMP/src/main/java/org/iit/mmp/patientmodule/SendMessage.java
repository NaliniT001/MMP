package org.iit.mmp.patientmodule;

import org.iit.mmp.utility.DriverScript;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendMessage extends DriverScript
{

	// CreateMessage
	
	public void createMessage(String subject, String message) throws Exception
	{
		driver.findElement(By.linkText("Messages")).click();
		driver.findElement(By.id("subject")).sendKeys(subject);
		driver.findElement(By.id("message")).sendKeys(message);	
		driver.findElement(By.xpath("//input[@value='Send']")).click();
		Thread.sleep(3000);
		Alert msgsent = driver.switchTo().alert();
		msgsent.accept();
	}	
}
