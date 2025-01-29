package com.plooma.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.plooma.pages.AppointmentPOC;
import com.plooma.pages.Appointmentcreation;
import com.plooma.pages.Checkedin;
import com.plooma.pages.Clinicalnotes;
import com.plooma.pages.Dashboard;
import com.plooma.pages.Schedule;
import com.plooma.pages.Superbill;
import com.plooma.pages.loginpage;
import com.plooma.utils.ProjectSpecificMethods;

public class TC_001_Superbillcheckout extends ProjectSpecificMethods {
    
    private loginpage Loginpage;
    private Dashboard dashboard;
    private Appointmentcreation appointmentCreation;  
    private Schedule schedule;
    private Checkedin checkedin;
    private AppointmentPOC appointmentPOC;
    private Clinicalnotes clinicalnotes;
    private Superbill superbill;

    @BeforeTest
    public void setValues() {
        testcaseName = "Appointment Checkout";
        testDescription = "Verify the Appointment Checkout";
        authors = "Ruthesh";
        category = "Smoke";
        portal = "Admin";
        browserName = "edge";
        excelFileName="testData";
    }

    @BeforeMethod
    public void setUp(String orgCode,String username,String password, String status) {
        // Initialize the page objects
        Loginpage = new loginpage(getDriver());
        dashboard = new Dashboard(getDriver());
        appointmentCreation = new Appointmentcreation(getDriver());  
        schedule=new Schedule(getDriver());
        checkedin=new Checkedin(getDriver());
        appointmentPOC=new AppointmentPOC(getDriver());
        clinicalnotes=new Clinicalnotes(getDriver());
        superbill=new Superbill(getDriver());
        if(status.equalsIgnoreCase("valid")) {
        	
        }
    }
    


    @Test
    public void Login() throws InterruptedException {
    			new loginpage(getDriver())
    	        .enterOrgCode("mlee")
    	        .enterUsername("prem")
    	        .enterPassword("P@ssw0rd")
    	        .loginbutton()
    	        .clickAppointmentButtonUsingJS()
    	        .selectProviderFromDropdown()
    	        .selectrendring()
    	        .selectPatientdropdown()
    	        .selectvisitreason()
    	        .servicelocation()
    	        .Save()
    	        .Slotconfirmation()
    	        .scheduletile()
    	        .searchAndEnterText("Astrid")
    	        .clickOnOneElementFromList()
    	        .changestatus()
    	        .Checkedintile()
    	        .searchAndEnterText("Astrid")
    	        .clickOnOneElementFromList()
    	        .Template()
//    	         checkedin.selectCheckbox();
    	        .clickCheckBoxes()
    	        .continuetosoap()
    	        .clicksign()
    	        .superbilltile()
    	        .searchAndEnterText("Astrid")
    	        .clickbillicon()
    	        .clickbrowse()
    	        .clickdiagnosis()
    	        .savediagnosis()
    	        .clickprocedure()
    	        .selectprocedure()
    	        .saveprocedure()
    	        .submit()
    	        .Clickyes();
    }
}