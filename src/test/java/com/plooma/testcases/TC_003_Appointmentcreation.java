package com.plooma.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import com.plooma.pages.loginpage;
import com.plooma.pages.Appointmentcreation;
import com.plooma.pages.Dashboard;
import com.plooma.utils.ProjectSpecificMethods;

public class TC_003_Appointmentcreation extends ProjectSpecificMethods {

    private loginpage loginPage;
    private Dashboard dashboardPage;
    private Appointmentcreation appointmentPage;
    

    @BeforeTest
    public void setValues() {
        testcaseName = "Login and Appointment Creation";
        testDescription = "Verify Login functionality and Appointment Creation";
        authors = "YourName"; 
        category = "Sanity";
        portal = "public";
        browserName = "edge";  
    }

    @Test
    public void testLoginAndAppointmentCreation() throws InterruptedException {
       
        loginPage = new loginpage(getDriver());  
        loginPage.enterOrgCode("mlee")  
                .enterUsername("prem")  
                .enterPassword("P@ssw0rd")  
                .loginbutton();   
        
        dashboardPage = new Dashboard(getDriver());
        appointmentPage = dashboardPage.clickAppointmentButtonUsingJS();  
        System.out.println("Add Appointment button clicked successfully.");
        appointmentPage = new Appointmentcreation(getDriver());
       
        appointmentPage.selectProviderFromDropdown()
                       .selectPatientdropdown()
                       .selectvisitreason()
                       .selectrendring()
                       .servicelocation()
                       .Save();
        String appointmentUrl = getDriver().getCurrentUrl(); 
        String dashboardUrl = "http://admin.beyondtherapydev.inventsoftlabs.com/dashboard/main";  
        
        if (appointmentUrl.equals(dashboardUrl)) {
            reportStep("Appointment created and redirected to Dashboard", "pass");
        } else {
            reportStep("Appointment creation failed to redirect to Dashboard", "fail");
            Assert.fail("Appointment creation did not redirect to Dashboard, test failed.");
        }
    }
}
