package com.crm.vtiger;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateContactWithOrganisation01_Test1 extends BaseClass {

	@Test
	public void createContactWithOrganisationTest1() throws InterruptedException, IOException
	{
		String lastName=eUtil.getExcelData("org", 1, 3);
		//Navigate to Contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Sahoo");
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		Set<String> window=driver.getWindowHandles();
		/*Iterator<String> iterator=window.iterator();
		while(iterator.hasNext())
		{
			String winId=iterator.next();
			driver.switchTo().window(winId);
			System.out.println(driver.getTitle());
		}*/
		String orgName="techM2";
		wUtil.switchtoWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgName)).click();
		wUtil.switchtoWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Logout
		/*Actions act=new Actions(driver);
		WebElement logoutImage=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(logoutImage).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();*/

	}

}
