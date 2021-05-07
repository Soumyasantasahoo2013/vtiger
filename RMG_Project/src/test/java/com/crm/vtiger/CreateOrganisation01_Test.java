package com.crm.vtiger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateOrganisation01_Test extends BaseClass {

	/*static
	{
		System.setProperty("webdriver.chrome.driver", "C:\\HSSM40\\RMG_Project\\src\\main\\resources\\Drivers\\chromedriver.exe");
	}*/

	@Test
	public void createOrganisation01_Test() throws InterruptedException, IOException
	{
		String orgName=eUtil.getExcelData("org", 1, 2);

		//Navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();
        Reporter.log("Organization Page found", true);
        
		//Navigate to create Organisation
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Reporter.log("Click on create organisation", true);
		
		driver.findElement(By.name("accountname")).sendKeys(orgName+JavaUtility.getRandomData());
		Reporter.log("Create organisation with organisation name", true);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("Click on save", true);
		
		String expData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		//Assert.assertTrue(expData.contains(orgName));
		SoftAssert asrt=new SoftAssert();
		asrt.assertTrue(expData.contains(orgName));
		System.out.println(expData);
		
		Reporter.log("The expected data is :"+expData, true);

		//Logout
		/*Actions act=new Actions(driver);
		WebElement logoutImage=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(logoutImage).perform();
		Thread.sleep(10000);
		driver.findElement(By.linkText("Sign Out")).click();*/
	}

}
