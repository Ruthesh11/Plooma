package com.plooma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.plooma.utils.ProjectSpecificMethods;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class loginpage extends ProjectSpecificMethods {

    private WebDriver driver;

    public loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public loginpage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements for login
    @FindBy(xpath = "//input[@name='dname']")
    private WebElement orgcodefield;

    @FindBy(xpath = "//input[@id='fname']")
    private WebElement usernamefield;

    @FindBy(xpath = "//input[@id='pass']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[@class='mat-button-wrapper']")
    private WebElement loginbtn;

    @FindBy(xpath = "//mat-error[@id='mat-error-1']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@id='dashboard-logo']")  
    private WebElement dashboardLogo;

    
    public loginpage enterOrgCode(String orgcode) {
        orgcodefield.sendKeys(orgcode);
        reportStep("Order code entered successfully", "pass");
        return this;
    }

    public loginpage enterUsername(String username) {
        usernamefield.sendKeys(username);
        reportStep("User Name " + username + " entered successfully", "pass");
        return this;
    }

    public loginpage enterPassword(String password) {
        passwordField.sendKeys(password);
        reportStep("Password entered successfully", "pass");
        return this;
    }

    public Dashboard loginbutton() {
        loginbtn.click();
        reportStep("Login button clicked", "pass");
        
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dashboardLogo)); 
        return new Dashboard(driver);
        }
      
    public loginpage loginbuttonforinvalidcrendemtials() {
        loginbtn.click();
        reportStep("Login button clicked", "pass");
        
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dashboardLogo)); 
        return this;
        }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
