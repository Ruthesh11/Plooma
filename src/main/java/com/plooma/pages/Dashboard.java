package com.plooma.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;  

import com.plooma.utils.ProjectSpecificMethods;

import org.openqa.selenium.support.FindBy;

public class Dashboard extends ProjectSpecificMethods  {

    private WebDriver driver;

    
    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    @FindBy(xpath = "//a[.='add_circle Add Appointment']")
    private WebElement Appointmentbtn;

    public Dashboard validatePageTitle() {
    	String expectedPageTitle = "Plooma - Hospital Admin Dashboard";
        String actualPageTitle = getDriver().getTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Login failed, page title mismatch.");
    	return this;
    }
    
public Dashboard(RemoteWebDriver driver) {
    this.driver = driver; 
    PageFactory.initElements(driver, this); 
    
}

public Appointmentcreation clickAppointmentButtonUsingJS() {

    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.elementToBeClickable(Appointmentbtn));
    js.executeScript("arguments[0].click();", Appointmentbtn);  
    return new Appointmentcreation(driver);
}
}