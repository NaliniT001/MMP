package org.iit.mmp.patientmodule;

import org.iit.mmp.utility.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PayFee extends DriverScript
{	
	// pay fees
	
	public void payFees(String fee, String patient_name, String cardtype, String cardnumber, String cardmonth, String cardyear, String cvvnumber) throws Exception
	{
		
		driver.findElement(By.linkText("Fees")).click();
		driver.findElement(By.linkText("Pay Now")).click();
	
		// select fee amount
		
		Thread.sleep(3000);
		WebElement dd1 = driver.findElement(By.id("amount"));
		Select sel1 = new Select(dd1);
		sel1.selectByVisibleText(fee);
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		// card details
		
		driver.findElement(By.id("name")).sendKeys(patient_name);

		WebElement dd2 = driver.findElement(By.id("card_name"));
		Select sel2 = new Select(dd2);
		sel2.selectByVisibleText(cardtype);
		
		driver.findElement(By.id("cid")).sendKeys(cardnumber);
		
		// Select expiration date
		WebElement dd3 = driver.findElement(By.id("cardMonth"));
		Select sel3 = new Select(dd3);
		sel3.selectByValue(cardmonth);
		
		WebElement dd4 = driver.findElement(By.id("cardYear"));
		Select sel4 = new Select(dd4);
		sel4.selectByVisibleText(cardyear);
		
		driver.findElement(By.id("cvv")).sendKeys(cvvnumber);
		
		driver.findElement(By.xpath("//input[@value='submit']")).click();
	}

}
