package com.plooma.utils;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.plooma.testbase.SeleniumBase;



public class ProjectSpecificMethods extends SeleniumBase {
	
	public String browserName;
	public String portal;

	@DataProvider(name = "fetchData", indices = 0)
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(excelFileName);
	}

	@BeforeClass
	public void preCondition() {
		
		if (portal.equalsIgnoreCase("public")) {
			startApp(browserName, false, "http://admin.beyondtherapydev.inventsoftlabs.com/authentication/signin");
		}else if (portal.equalsIgnoreCase("admin")) {
			startApp(browserName, false, "http://admin.beyondtherapydev.inventsoftlabs.com/");
		}
		setNode();
	}

//	@AfterMethod
//	public void postCondition() {
////		close();
//
//	}

}
