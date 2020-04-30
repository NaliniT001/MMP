package org.iit.mmp.patientmodule;


//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import org.iit.mmp.utility.DriverScript;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationPage extends DriverScript
{
	/*
	static HashMap<String,String> hMap = new HashMap<String,String>();
	static Random rnd = new Random();
	*/
	public static void main (String args[]) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php");
		
		RegistrationPage rp = new RegistrationPage();
		HashMap<String,String> hMap = rp.registerPatient();
		Iterator<String> itr =  hMap.keySet().iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
	} //main ()
	
	public HashMap<String,String> registerPatient() throws Exception
	{

		HashMap<String,String> hMap = new HashMap<String,String>();
		Random rnd = new Random();
		
		WebElement firstnameTxtField = driver.findElement(By.id("firstname"));
		String fNameValue = "testFN" +  (char) (65+rnd.nextInt(26));
		firstnameTxtField.sendKeys(fNameValue);
		hMap.put("firstname", firstnameTxtField.getAttribute("value"));
		
		WebElement lastnameTxtField = driver.findElement(By.id("lastname"));
		String LNameValue = "testLN" +  (char) (65+rnd.nextInt(26));
		lastnameTxtField.sendKeys(LNameValue);
		hMap.put("lastname", lastnameTxtField.getAttribute("value"));
		
		WebElement stateTxtField = driver.findElement(By.id("state"));
		stateTxtField.sendKeys("New York");
		hMap.put("state", stateTxtField.getAttribute("value"));
		
		WebElement lsnTxtField = driver.findElement(By.id("license"));
		//long lsnValue = 10000000+rnd.nextInt(90000000);
		lsnTxtField.sendKeys("12345678");
		hMap.put("license", lsnTxtField.getAttribute("value"));
		
		WebElement ssnTxtField = driver.findElement(By.id("ssn"));
		long ssnValue = 100000000+rnd.nextInt(900000000);
		ssnTxtField.sendKeys(""+ssnValue);
		hMap.put("ssn", ssnTxtField.getAttribute("value"));
		
		WebElement cityTxtField = driver.findElement(By.id("city"));
		cityTxtField.sendKeys("seattle");
		hMap.put("city", cityTxtField.getAttribute("value"));
		
		WebElement addressTxtField = driver.findElement(By.id("address"));
		addressTxtField.sendKeys("10 street");
		hMap.put("address", addressTxtField.getAttribute("value"));
		
		WebElement zipcodeTxtField = driver.findElement(By.id("zipcode"));
		long zipValue = 10000+rnd.nextInt(90000);
		zipcodeTxtField.sendKeys(""+zipValue);
		hMap.put("zipcode", zipcodeTxtField.getAttribute("value"));
		
		WebElement ageTxtField = driver.findElement(By.id("age"));
		long ageValue = 10+rnd.nextInt(90);
		ageTxtField.sendKeys(""+ageValue); 
		hMap.put("age", ageTxtField.getAttribute("value"));
		
		WebElement heightTxtField = driver.findElement(By.id("height"));
		heightTxtField.sendKeys("50");
		hMap.put("height", heightTxtField.getAttribute("value"));
		
		WebElement weightTxtField = driver.findElement(By.id("weight"));
		weightTxtField.sendKeys("50");
		hMap.put("weight", weightTxtField.getAttribute("value"));	
		
		//SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		//Date d = new Date();
		
		WebElement dobTxtField = driver.findElement(By.id("datepicker"));
		//dobTxtField.sendKeys(sdf.format(d));
		dobTxtField.sendKeys("10/20/1930");
		hMap.put("dob", dobTxtField.getAttribute("value"));
		
		WebElement emailTxtField = driver.findElement(By.id("email"));
		String emailValue = "testEmail" +  (char) (65+rnd.nextInt(26)) +(long) (10+rnd.nextInt(90))+"@gmail.com";
		emailTxtField.sendKeys(emailValue);
		//System.out.println(emailValue);
		hMap.put("email", emailTxtField.getAttribute("value"));
		
		WebElement unameTxtField = driver.findElement(By.id("username"));
		String unameValue = "testUname" +  (char) (65+rnd.nextInt(26)) + (long) (10+rnd.nextInt(90));
		unameTxtField.sendKeys(unameValue);
		hMap.put("uname", unameTxtField.getAttribute("value"));
		
		WebElement pwdTxtField = driver.findElement(By.id("password"));
		String pwdValue = "TestPwd" +  (long) (10+rnd.nextInt(90));
		//System.out.println("pwd: "+pwdValue);
		pwdTxtField.sendKeys(pwdValue);
		hMap.put("pwd", pwdTxtField.getAttribute("value"));
		
		WebElement pwd2TxtField = driver.findElement(By.id("confirmpassword"));
		//System.out.println("pwd2: "+pwdValue);
		pwd2TxtField.sendKeys(pwdValue);
		hMap.put("pwd2", pwd2TxtField.getAttribute("value"));
		
		WebElement secselField = driver.findElement(By.id("security"));
		Select secQ = new Select(secselField);
		secQ.selectByVisibleText("What is your mother maiden name");
		hMap.put("SecurityQuestion", "What is your mother maiden name");
		
		WebElement answerTxtField = driver.findElement(By.id("answer"));
		answerTxtField.sendKeys("testMother");
		hMap.put("answer", answerTxtField.getAttribute("value"));
		
		Thread.sleep(5000);
		driver.findElement(By.name("register")).click();
		
		Alert alrt = driver.switchTo().alert();
		String successMsg = alrt.getText();
		hMap.put("successMsg", successMsg);
		alrt.accept();
		
		return hMap;
	}
	
}//RegistrationPage
