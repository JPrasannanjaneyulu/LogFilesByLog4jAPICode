package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCRMLoginTest 
{
	//What is log? : capturing info/activities at the time of program execution. 
	// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
					
	//how to generate the logs? : use Apache log4j API (log4j jar)
	//How it works? : it reads log 4j configuration from log4j.properties file
	//where to create: create inside resources folder

	public static WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\batch229\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/");
	}
	
	@Test(priority=1)
	public void freeCrmTitleTest()
	{
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Free CRM software for any Business");
	}
	
	@Test(priority=2)
	public void freemCRMLoginButtonTest()
	{
		boolean b = driver.findElement(By.xpath("//span[text()='Log In']")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
