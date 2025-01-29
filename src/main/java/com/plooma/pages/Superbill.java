package com.plooma.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import com.plooma.utils.ProjectSpecificMethods;

public class Superbill extends ProjectSpecificMethods {

    private WebDriver driver;

    // Constructor for WebDriver
    public Superbill(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
   
    @FindBy(xpath = "//div[@class='row statustile']/descendant::p[text()='Super Bill']") 
    private WebElement superbilltile;
    
    @FindBy(xpath = "//input[@placeholder='Search']") 
    private WebElement search;
    
    @FindBy(xpath = "//i[@class='fas fa-money-bill-alt']") 
    private WebElement billicon;
    
    @FindBy(xpath = "//div[@class='col-xl-12 col-lg-12 col-md-12 col-sm-12 mb-10']//div[@class='mat-ripple mat-button-ripple']") 
    private WebElement browsediagnosis;
    
    @FindBy(xpath = "//mat-cell[normalize-space()='R48.9']") 
    private WebElement selectdiagnosis;
    
    @FindBy(xpath = "//span[normalize-space()='Save']") 
    private WebElement savediagnosis;
    
    @FindBy(xpath = "//form[@name='superbillForm']//div[@class='col-xl-12 col-lg-12 col-sm-12 col-md-12']//span[@class='mat-button-wrapper']") 
    private WebElement clickprocedure;
    
    @FindBy(xpath = "//mat-cell[normalize-space()='EVALUATION OF SPEECH FLUENCY (STUTTER CLUTTER)']") 
    private WebElement selectprocedure;
    
    
    @FindBy(xpath = "//a[@class='mat-focus-indicator mat-flat-button mat-button-base mat-primary']") 
    private WebElement saveprocedure;
    
    @FindBy(xpath = "//span[normalize-space()='Submit & Checkout']") 
    private WebElement submit;
    
    @FindBy(xpath = "//span[normalize-space()='Yes']") 
    private WebElement Yes;
    
    

    public Superbill(RemoteWebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}
    public Superbill superbilltile() {
    	superbilltile.click();
    	reportStep("Superbill tile selected successfully","pass");
    	return this;
    }
    
    public Superbill searchAndEnterText(String Astrid) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        search.clear();
        search.sendKeys(Astrid);   
        reportStep("Entered" + "Astrid","pass");
        return this;
}
    
    public Superbill clickbillicon() {
    	click(billicon);
    	
//    	billicon.click();
    	reportStep("Edit superbill","pass");
    	return this;
    }
    
    public Superbill clickbrowse() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(browsediagnosis)); 
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", browsediagnosis);
        reportStep("Browser clicked","pass");
        return this;
    }
    public Superbill clickdiagnosis() {
    	selectdiagnosis.click();
    	reportStep("Diagnosis code selected sucessfully","pass");	
    	return this;
    }
    
    public Superbill savediagnosis() {
    	savediagnosis.click();
    	reportStep("Click on save","pass");
    	return this;
    }
    public Superbill clickprocedure() {
    	clickprocedure.click();
    	reportStep("Procedure code Popup opened sucessfully","pass");
    	return this;
    }

    public Superbill selectprocedure() {
    	selectprocedure.click();
    	reportStep("Procedure code selected sucessfully","pass");
    	return this;
}

    public Superbill saveprocedure() {
    	saveprocedure.click();
    	reportStep("Procedure code saved sucessfully","pass");
    	return this;
}
    public Superbill submit() {
    	submit.click();
    	reportStep("Super bill submitted sucessfully","pass");
    	return this;
}
    public Dashboard Clickyes() {
    	Yes.click();
    	reportStep("Click yes","pass");
    	return new Dashboard(driver);
}

    
}