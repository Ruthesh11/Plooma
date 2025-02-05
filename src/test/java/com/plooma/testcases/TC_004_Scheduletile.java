package com.plooma.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import com.plooma.pages.Schedule;
import com.plooma.pages.loginpage;
import com.plooma.pages.Checkedin;
import com.plooma.utils.ProjectSpecificMethods;

public class TC_004_Scheduletile extends ProjectSpecificMethods {

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
    public void scheduleTileSelection() {
        schedule = new Schedule(getDriver());
        schedule.scheduletile();

        String expectedTitle = "Plooma - Hospital Admin Dashboard";
        Assert.assertEquals(getDriver().getTitle(), expectedTitle, "Schedule tile was not clicked successfully.");
    }

    @Test(priority = 3)
    public void clickEditFromList() {
        schedule = new Schedule(getDriver());
        schedule.clickOnOneElementFromList();

        if (getDriver().getPageSource().contains("No elements found")) {
            System.out.println("No Edit elements found in the list.");
        } else {
            System.out.println("Successfully clicked on an Edit icon from the list.");
        }
    }

    @Test(priority = 4)
    public void testChangeStatusToCheckedIn() throws InterruptedException {
        try {
            schedule = new Schedule(getDriver());
            checkinPage = schedule.changestatus();

            Thread.sleep(2000);

            String expectedTitle = "Plooma - Hospital Admin Dashboard";
            String actualTitle = getDriver().getTitle();

            Assert.assertEquals(actualTitle, expectedTitle, "Page did not redirect to the expected title after changing status.");
            System.out.println("Successfully changed status to 'Checked In' and redirected to the expected page.");
        } catch (Exception e) {
            System.out.println("Test failed due to an exception: " + e.getMessage());
            Assert.fail("Test failed: Page did not redirect to the expected title after changing status.");
        }
    }
}
