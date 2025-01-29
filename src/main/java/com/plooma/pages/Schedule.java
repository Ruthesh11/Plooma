package com.plooma.pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import com.plooma.utils.ProjectSpecificMethods;

public class Schedule extends ProjectSpecificMethods {

    private WebDriver driver;

    // Constructor for WebDriver
    public Schedule(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   
    @FindBy(xpath = "//div[@class='row statustile']/descendant::p[text()='Scheduled']") 
    private WebElement Scheduletile;

    
    @FindBy(xpath = "//input[@placeholder='Search']")  
    private WebElement search;
    
    @FindBy(xpath = "//button[@smattooltip='Edit']")  
    private WebElement Editicon;
    
    @FindBy(xpath = "//mat-select[@id='statusType']")  
    private WebElement Status;
    
    @FindBy(xpath = "//span[text()='Checked In']")  
    private WebElement SelectStatus;

    // Constructor for RemoteWebDriver
    public Schedule(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    public Schedule scheduletile() {
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

      
        wait.until(ExpectedConditions.elementToBeClickable(Scheduletile));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", Scheduletile);
        reportStep("Schedule tile selected","pass");
        return this;
    }


    public Schedule searchAndEnterText(String Astrid) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        search.clear();
        search.sendKeys(Astrid);
        reportStep("Entered" + "Astrid","pass");
        return this;
    }
    
//    public void clearAndType(String Astrid) {
//    	search.sendKeys(Astrid);
//    }
    
    public Schedule clickOnOneElementFromList() {
    	List<WebElement> elementsList = driver.findElements(By.xpath("//button[@smattooltip='Edit']"));

        if (!elementsList.isEmpty()) {
          
            Random rand = new Random();
            WebElement randomElement = elementsList.get(rand.nextInt(elementsList.size()));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", randomElement);
        } else {
            System.out.println("No elements found in the list.");
        }
        reportStep("Click Edit ","pass");
        search.clear();
        return this;
    }
    
    public Checkedin changestatus() throws InterruptedException {
      	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

           wait.until(ExpectedConditions.visibilityOf(Status));  
           wait.until(ExpectedConditions.elementToBeClickable(Status)); 
           Status.click();
           Thread.sleep(3000);                
           wait.until(ExpectedConditions.visibilityOf(SelectStatus));  
           wait.until(ExpectedConditions.elementToBeClickable(SelectStatus)); 
           SelectStatus.click();
           Thread.sleep(3000); 
           reportStep("Changes checkedin status succesfully","pass");
           return new Checkedin(driver);
}
}
