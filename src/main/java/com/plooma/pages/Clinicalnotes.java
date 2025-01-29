package com.plooma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import com.plooma.utils.ProjectSpecificMethods;

public class Clinicalnotes extends ProjectSpecificMethods {

    private WebDriver driver;

    
    public Clinicalnotes(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
   
    @FindBy(xpath = "//a[4]/span[@class='mat-button-wrapper']") 
    private WebElement sign;
    

    public Clinicalnotes(RemoteWebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}
    public Superbill clicksign() {
    	sign.click();
    	reportStep("Clinical note signed succesfully","pass");
    	return new Superbill(driver);
    }
    
}