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

public class Checkedin extends ProjectSpecificMethods {

    private WebDriver driver;

    // Constructor for WebDriver
    public Checkedin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   
    @FindBy(xpath = "//div[@class='row statustile']/descendant::p[text()='Checked In']") 
    private WebElement Checkedintile;

    @FindBy(xpath = "//input[@placeholder='Search']") 
    private WebElement search;
    
   
    public Checkedin(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    public Checkedin Checkedintile() {
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

      
        wait.until(ExpectedConditions.elementToBeClickable(Checkedintile));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", Checkedintile);
        return this;
    }


    public Checkedin searchAndEnterText(String Astrid) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    search.clear();
    search.sendKeys(Astrid);
    reportStep("Entered" + "Astrid","pass");
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
    return new AppointmentPOC(driver);

    }
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
         
    
 
