package com.plooma.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import com.plooma.pages.Schedule;
import com.plooma.pages.loginpage;
import com.plooma.pages.Checkedin;
import com.plooma.utils.ProjectSpecificMethods;


import io.cucumber.messages.types.Duration;

public class TC_005_Checkedin extends ProjectSpecificMethods {

    private Schedule schedule;
    private Checkedin checkinPage;

    @BeforeTest
    public void setValues() {
        testcaseName = "Login and Schedule";
        testDescription = "Verify Login functionality and Schedule Operations";
        authors = "YourName";
        category = "Sanity";
        portal = "public";
        browserName = "edge";
    }

    @Test(priority = 1)
    public void login() {
        loginpage login = new loginpage(getDriver());
        login.enterOrgCode("mlee")
             .enterUsername("prem")
             .enterPassword("P@ssw0rd")
             .loginbutton();
    }
    
    @Test(priority = 2)
    public void testCheckedInTileClick() {
    	checkinPage = new Checkedin(getDriver());
        checkinPage.Checkedintile();
//        WebDriverWait wait = new WebDriverWait(getDriver(), 5000);
        expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Checkedintext")));
//        WebElement checkedInText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Checkedintext")));
    }
}
