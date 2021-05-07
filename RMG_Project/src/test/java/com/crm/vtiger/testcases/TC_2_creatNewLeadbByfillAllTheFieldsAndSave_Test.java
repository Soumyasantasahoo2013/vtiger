package com.crm.vtiger.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.pomclass.CreateLeadsPage;
import com.crm.vtiger.pomclass.HomePage;
import com.crm.vtiger.pomclass.LeadsInformationPage;
import com.crm.vtiger.pomclass.LeadsPage;

public class TC_2_creatNewLeadbByfillAllTheFieldsAndSave_Test extends BaseClass {

	@Test(groups="smokeTest")
	public void creatNewLeadbByfillAllTheFieldsAndSave() throws InterruptedException, IOException
	{
		String fname=eUtil.getExcelData("Sheet1", 1, 2)+JavaUtility.getRandomData();
		String lname=eUtil.getExcelData("Sheet1", 1, 3)+JavaUtility.getRandomData();
		String company=eUtil.getExcelData("Sheet1", 1, 4)+JavaUtility.getRandomData();
		
		//Navigate To Lead Page
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLeadsLink();
		
		//create Lead
		LeadsPage ldPage=new LeadsPage(driver);
		ldPage.clickOnCreateLeadsImage();

		//Create Lead Information
		CreateLeadsPage crtLdPage=new CreateLeadsPage(driver);
		crtLdPage.createNewLeadsByEnteringAllTheField(fname, lname, company);
		
		//Verification
		LeadsInformationPage ldInfoPage=new LeadsInformationPage(driver);
		String actualLeadName=ldInfoPage.getLeadInfo();
		Assert.assertTrue(actualLeadName.contains(lname));
	}

}
