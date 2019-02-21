package com.testcases;

public class Leave extends UserLibrary{
	
//=======================================================
	public static void TC01_CancelLeave()
	{
		// Step 1: Login as team member		
		HRMLogin("user02", "TM1234");
		
		// Step 2: Navigate My Leave
		navMyLeavePage();
		
		// Step 3: Cancel Leave Leave
		selectCancelLeave("2019-02-18");		
		
		// Step 4: Verify Leave status is cancelled
		verifyLeaveStatus("2019-02-18", "Cancelled");
		
		//Step 5: close application
		closeApp();
	}
//=======================================================	
		
	
	
	
	
	
	public static void TC02_ApplyLeave_VerifyInMyLeavePage()
	{		
		HRMLogin("user02", "TM1234");
		
		
		closeApp();
	}
	
//=======================================================	
	public static void TC03_ApplyLeave_Approve()
	{
		launchApp();
		HRMLogin("user02", "TM1234");
		
		
		closeApp();
		
	}
//=======================================================

}
