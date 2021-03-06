package org.iit.mmp.adminmodule;

import org.iit.mmp.utility.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateFeePage extends DriverScript
{
	
	// Create Fee
	public void createFee(String appdate, String service) throws Exception 
	{
		driver.findElement(By.xpath("//input[@value = 'Create Fee']")).click();
		
		WebElement dd1 = driver.findElement(By.id("app_date"));
		Select sel1 = new Select(dd1);
		sel1.selectByVisibleText(appdate);
		
		WebElement dd2 = driver.findElement(By.id("service"));
		Select sel2 = new Select(dd2);
		sel2.selectByVisibleText(service);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value = 'submit']")).click();
		driver.switchTo().alert().accept();
		
	}
		
}
