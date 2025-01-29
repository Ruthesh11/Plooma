package com.plooma.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

import com.plooma.pages.loginpage;
import com.plooma.utils.ProjectSpecificMethods;

public class TC_002_Login extends ProjectSpecificMethods {

    private loginpage Loginpage;

    @BeforeTest
    public void setValues() {
        testcaseName = "Login ";
        testDescription = "Verify the Login functionality";
        authors = "Ruthesh";
        category = "Sanity";
        portal = "Admin";
        browserName = "edge";
        excelFileName="testData";
    }

    @Test(dataProvider = "testData", priority = 1)
    public void testLogin(String orgCode, String username, String password, String status) throws InterruptedException {
    	if(status.equalsIgnoreCase("valid")) {
    		new loginpage(getDriver()).enterOrgCode(orgCode)
            .enterUsername(username)
            .enterPassword("password")
            .loginbutton()
            .validatePageTitle();
    		
    	}
    	
         else {
        	 new loginpage(getDriver()).enterOrgCode(orgCode)
             .enterUsername("username")
             .enterPassword("password")
             .loginbuttonforinvalidcrendemtials();
              String expectedErrorMessage = "Enter valid domain , username and password"; // Update based on your actual error message
              String actualErrorMessage = Loginpage.getErrorMessage();
              Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch.");
          }
      }
  }
    