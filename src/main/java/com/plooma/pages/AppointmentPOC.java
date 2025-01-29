package com.plooma.pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import com.plooma.utils.ProjectSpecificMethods;

public class AppointmentPOC extends ProjectSpecificMethods {

    private WebDriver driver;

    // Constructor for WebDriver
    public AppointmentPOC(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
  
    @FindBy(xpath = "//mat-select[@id='salt']")
    private WebElement Clicktemplate;
    
    @FindBy(xpath = "//span[text()=' Test ']")
    private WebElement Selecttemplate;
    
    @FindBy(xpath = "//input[@class='ng-valid ng-dirty ng-touched']")  
    private WebElement Checkbox;
    
    @FindBy(xpath = "//span[normalize-space()='Continue To Soap Note']")  
    private WebElement Continuetosoap;
    
    @FindBy(xpath = "//div[@id='selectedObjectiveCollapse0']/child::div/child::div/child::input")  
    private List<WebElement> Checkboxes;

    // Constructor for RemoteWebDriver
    public AppointmentPOC(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public AppointmentPOC clickCheckBoxes() {
    	for(WebElement checkbox:Checkboxes) {
    		checkbox.click(); 	
    	}
    	return this;
    }
    

    public AppointmentPOC clickOnOneElementFromList() {
	List<WebElement> elementsList = driver.findElements(By.xpath("//button[@mattooltip='Notes']"));

    if (!elementsList.isEmpty()) {
      
        Random rand = new Random();
        WebElement randomElement = elementsList.get(rand.nextInt(elementsList.size()));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", randomElement);
    } else {
        System.out.println("No elements found in the list.");
    }
    reportStep("Click edit icon","pass");
    return this;
}

//    public void Template() throws InterruptedException {
//    	Thread.sleep(5000);
//     	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//          wait.until(ExpectedConditions.visibilityOf(Clicktemplate));  
//          wait.until(ExpectedConditions.elementToBeClickable(Clicktemplate)); 
//          
//          Actions action = new Actions(driver);
//
//          action.moveToElement(Clicktemplate).click().build().perform();
//          
//         JavascriptExecutor js = (JavascriptExecutor) driver;
//         js.executeScript("arguments[0].click();", Clicktemplate);
//          Clicktemplate.click();
//          Thread.sleep(3000);                
//          wait.until(ExpectedConditions.visibilityOf(Selecttemplate));  
//          wait.until(ExpectedConditions.elementToBeClickable(Selecttemplate)); 
//          Selecttemplate.click();
//    }
          public AppointmentPOC Template() {
        	    try {
        	        
        	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));       	     
        	        wait.until(ExpectedConditions.elementToBeClickable(Clicktemplate));
        	        Actions action = new Actions(driver);
        	        action.moveToElement(Clicktemplate).click().perform();       	      
        	        wait.until(ExpectedConditions.elementToBeClickable(Selecttemplate));   	      
        	        Selecttemplate.click();
       
        	    } catch (Exception e) {
        	        System.out.println("Error occurred while interacting with template elements: " + e.getMessage());
        	    }
        	    reportStep("Template selected","pass");
        	    return this;
        	}

  
    public AppointmentPOC selectCheckbox() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.elementToBeClickable(Checkbox));
        Checkbox.click();
        reportStep("Checkbox selected","pass");
        return this;
}
    public Clinicalnotes continuetosoap() {
    	Continuetosoap.click();
    	reportStep("Clicked continue to soap button","pass");
        return new Clinicalnotes(driver);

    }
}
