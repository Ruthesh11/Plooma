package com.plooma.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.plooma.utils.ProjectSpecificMethods;

import org.openqa.selenium.support.FindBy;

public class Appointmentcreation extends ProjectSpecificMethods {

	private WebDriver driver;

	public Appointmentcreation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//app-custom-autocomplete[@name='providerName']")
	private WebElement ProvideDropdow;

	@FindBy(xpath = "//span[text()=' Cadence Reed-Bippen ']")
	private WebElement selectprovider;

	@FindBy(xpath = "//app-custom-autocomplete[@name='patientName']")
	private WebElement patientdropdown;

	@FindBy(xpath = "//span[normalize-space()='Astrid Lindley']")
	private WebElement selectpatient;

	@FindBy(id = "endTime")
	private WebElement calendor;

	@FindBy(xpath = "//span[contains(@class,'owl-dt-calendar-cell-today')]")
	private WebElement currentDate;

	@FindBy(xpath = "//input[@id='mat-input-10']")
	private WebElement visitreason;

	@FindBy(xpath = "//span[normalize-space()='OT Evaluation']")
	private WebElement selectvisitreason;

	@FindBy(xpath = "//input[@id='mat-input-11']")
	private WebElement servicelocation;

	@FindBy(xpath = "//span[@class='mat-option-text']")
	private WebElement selectservicelocaion;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	private WebElement Save;

	@FindBy(xpath = "//a[normalize-space()='Yes']")
	private WebElement Slotconfirmation;

	@FindBy(xpath = "//app-custom-autocomplete[@name='renderingProviderName']")
	private WebElement clickrendring;

	@FindBy(xpath = "//span[normalize-space()='Cadence Reed-Bippen']")
	private WebElement Selectrendring;

	private JavascriptExecutor js;

	public Appointmentcreation(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public Appointmentcreation selectProviderFromDropdown() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(ProvideDropdow));
		wait.until(ExpectedConditions.elementToBeClickable(ProvideDropdow));
		ProvideDropdow.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(selectprovider));
		wait.until(ExpectedConditions.elementToBeClickable(selectprovider));
		selectprovider.click();
		reportStep("Provider selected", "pass");
		return this;
	}

	public Appointmentcreation selectDateforAppointmentToday() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		System.out.println("Waiting for the provider dropdown to be clickable...");
		wait.until(ExpectedConditions.visibilityOf(calendor));
		wait.until(ExpectedConditions.elementToBeClickable(calendor));

		calendor.click();
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOf(currentDate));
		wait.until(ExpectedConditions.elementToBeClickable(currentDate));

		currentDate.click();
		return this;

	}

	public Appointmentcreation selectPatientdropdown() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(patientdropdown));
		wait.until(ExpectedConditions.elementToBeClickable(patientdropdown));
		patientdropdown.click();

		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(selectpatient));
		wait.until(ExpectedConditions.elementToBeClickable(selectpatient));

		selectpatient.click();
		reportStep("Patient selected", "pass");
		return this;
	}

	public Appointmentcreation selectvisitreason() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(visitreason));
		wait.until(ExpectedConditions.elementToBeClickable(visitreason));

		visitreason.click();

		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(selectvisitreason));
		wait.until(ExpectedConditions.elementToBeClickable(selectvisitreason));
		selectvisitreason.click();
		reportStep("Visit reason selected", "pass");
		return this;
	}

	public Appointmentcreation selectrendring() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(clickrendring));
		wait.until(ExpectedConditions.elementToBeClickable(clickrendring));
		clickrendring.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(Selectrendring));
		wait.until(ExpectedConditions.elementToBeClickable(Selectrendring));
		Selectrendring.click();
		reportStep("Rendering provider selected", "pass");
		return this;
	}

	public Appointmentcreation servicelocation() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(servicelocation));
		wait.until(ExpectedConditions.elementToBeClickable(servicelocation));

		servicelocation.click();

		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(selectservicelocaion));
		wait.until(ExpectedConditions.elementToBeClickable(selectservicelocaion));

		selectservicelocaion.click();
		reportStep("Service location selected", "pass");
		return this;
	}

	public Appointmentcreation Save() {
		Save.click();
		return this;
	}

	public Schedule Slotconfirmation() {
		expwait = new WebDriverWait(driver, Duration.ofSeconds(5));
		expwait.until(ExpectedConditions.visibilityOf(Slotconfirmation));
		Slotconfirmation.click();
		reportStep("Click Yes", "pass");
		 return new Schedule(driver);


	}

}
