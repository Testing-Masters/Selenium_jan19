package com.testcases;

public class MyInfo extends UserLibrary{
	
	//================================================
	public static void TC21_AddEducationDetails()
	{
		boolean retval;
		//Step 1: Login as team member
		HRMLogin("user02", "TM1234");
		
		//Step 2: Navigate MyInfo
		navMyInfo();
		
		//Step 3: Navigate Qualifications
		navQualifications();
		
		//Step 4: Add Education details
		
			//Step 4.1: Click Add
			retval = clickElement("//input[@id='addEducation']");		
			if(retval)
				System.out.println("addEducation button clicked");
			else
				System.out.println("addEducationbutton not clicked");
			//Step 4.2: Select Education qualification
			retval = selectByText("//select[@id='education_code']", "MBA");
			if(retval)
				System.out.println("Qualification selected");
			else
				System.out.println("Qualification not selected");
			//Step 4.3: Enter Inst name
			
			//Step 4.4: Click Save
		
		//Step 5: Verify Education details
		
		
		//Step 6: Logout
	
	}
	//================================================
	
	
}
