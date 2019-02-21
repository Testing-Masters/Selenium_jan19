package com.resources.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebLibrary {
	
public static WebDriver driver;
	
	//===============================================================
	public static void launchApp()
	{
		driver = new FirefoxDriver();
		driver.get("http://testingmasters.com/hrm/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	//===========================================================
	public static boolean setText(String xpath, String value)
	{
		boolean status = true;
		
		try{
			driver.findElement(By.xpath(xpath)).sendKeys(value);
		}
		
		catch(Exception e)
		{
			status = false;
		}
		
		return status;
	}
	//===========================================================
	
	public static boolean clickElement(String xpath)
	{
		boolean status = true;
		
		try{
			driver.findElement(By.xpath(xpath)).click();
		}
		
		catch(Exception e)
		{
			status = false;
		}
		
		return status;
	} 
	//===========================================================
	
	public static boolean selectByText(String xpath, String item)
	{
		boolean status = true;
		
		try{
			WebElement dropdown = driver.findElement(By.xpath(xpath));
			Select sel_obj = new Select(dropdown);
			sel_obj.selectByVisibleText(item);			
		}
		
		catch(Exception e)
		{
			status = false;
		}
		
		return status;
	}
	//===========================================================
	
	public static boolean verifyText(String text, String tagName)
	{
		boolean status = true;
		
		try{
			driver.findElement(By.xpath("//"+tagName+"[text()='"+text+"']"));		
		}
		
		catch(Exception e)
		{
			status = false;
		}
		
		return status;
	}
	//===========================================================
	
	
	public static boolean isElementSelected(String xpath, Boolean expValue)
	{
		boolean status = true;
		
		try{
			boolean appvalue = driver.findElement(By.xpath(xpath)).isSelected();
			if(appvalue==expValue)
				status = true;
			else
				status =false;			
		}
		
		catch(Exception e)
		{
			status = false;
		}
		
		return status;
	}
	//===========================================================

	
	
	
	
	
	
	
	
	
	
	
}