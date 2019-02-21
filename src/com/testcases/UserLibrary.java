package com.testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.resources.generic.WebLibrary;

public class UserLibrary extends WebLibrary {
		
	public static void HRMLogin(String UID, String PWD)
	{ 
		boolean retval;
		
		launchApp();
		
		retval = setText("//input[@id='txtUsername']", UID);
		if(retval)
			System.out.println("User name entered");
		else
			System.out.println("User name not entered");
		
		retval = setText("//input[@id='txtPassword']", PWD);
		if(retval)
			System.out.println("Password entered");
		else
			System.out.println("Password not entered");
		
		retval = clickElement("//input[@id='btnLogin']");
		if(retval)
			System.out.println("Login button clicked");
		else
			System.out.println("Login button not clicked");			
	}
	
	//===============================================================
	
	public static void navMyLeavePage()
	{
		//Mouse hover to leave menu
		Actions act_obj = new Actions(driver);
		act_obj.moveToElement(driver.findElement(By.id("menu_leave_viewLeaveModule"))).build().perform();
				
		//Click on My Leave option
		driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();	
	}
	
	//===============================================================
	
	public static void navMyInfo()
	{		
		boolean retval;
		
		retval = clickElement("//a[@id='menu_pim_viewMyDetails']");		
		if(retval)
			System.out.println("Myinfo link clicked");
		else
			System.out.println("Myinfo link not clicked");
		
		retval = verifyText("Personal Details", "h1");
		if(retval)
			System.out.println("MyInfo page displayed");
		else
			System.out.println("MyInfo page not displayed");
		
	}
	
	//===============================================================
	
	public static void navQualifications()
	{		
		boolean retval;
		
		retval = clickElement("//a[text()='Qualifications']");		
		if(retval)
			System.out.println("Qualifications link clicked");
		else
			System.out.println("Qualifications link not clicked");
		
		retval = verifyText("Work Experience", "h1");
		if(retval)
			System.out.println("Qualifications page displayed");
		else
			System.out.println("Qualifications page not displayed");
		
	}
	
	//===============================================================
	
	public static void selectCancelLeave(String leavedate)
	{		
		boolean bTag = false;
		//Get Table row count
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		int rowcount = rows.size();
		
		for(int i=1; i<=rowcount; i++)
		{
			String appdate = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]")).getText();
			String appstatus = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[6]")).getText();
			
			if ( (appdate.equals(leavedate)) && (appstatus.contains("Pending Approval")) )
			{
				driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[8]/select/option[2]")).click();
				driver.findElement(By.xpath("//input[@id='btnSave']")).click();
				bTag = true;
				break;
			}
		}
		
		if(bTag)
			System.out.println("Cancel selected");
		else
			System.out.println("Cancel not selected or date not found");	
	}
	
	//===============================================================
	
	public static void verifyLeaveStatus(String leavedate, String leaveStatus)
	{		
		boolean bTag = false;
		//Get Table row count
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		int rowcount = rows.size();
		String appdate = "";
		String appstatus = "";
		
		for(int i=1; i<=rowcount; i++)
		{
			appdate = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]")).getText();
			appstatus = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[6]")).getText();
			
			if(leavedate.length()!=0)	
			{
				if ( (appdate.equals(leavedate)) && (appstatus.contains(leaveStatus)) )
				{
					bTag = true;
					break;
				}
			}
			else
			{
				if ( appstatus.contains(leaveStatus) ) 
				{
					bTag = true;
					break;
				}
			}
		}
		
		if(bTag)
			System.out.println(leavedate + "  Leave status is as expected - " + leaveStatus);
		else
			System.out.println(leavedate + " Leave status is incorrectly displayed - " + leaveStatus);	
	}
	
	
	//===============================================================
		
	public static void closeApp()
	{
		driver.quit();		
	}
	
	//===============================================================
	

}
