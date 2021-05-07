package com.crm.vtiger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateOrganisationWithIndustry01_Test extends BaseClass {

	@Test
	public void createOrganisationWithIndustryTest1() throws InterruptedException, IOException, ParseException
	{
		String orgName=eUtil.getExcelData("org", "TC_01", "organizationName");
		
		//Navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();

		//Navigate to create Organisation
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+JavaUtility.getRandomData());

		WebElement sel=driver.findElement(By.name("industry"));
		wUtil.SelectOption(sel, "Finance");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Logout
		/*Actions act=new Actions(driver);
		WebElement logoutImage=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(logoutImage).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();*/
	}

}
