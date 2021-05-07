package com.crm.vtiger.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_6_createNewLeadBySelectingDifferrentLeadSourceFromDropDown_Test {

	static
	{
		System.setProperty("webdriver.chrome.driver", "C:\\HSSM40\\RMG_Project\\src\\main\\resources\\Drivers\\chromedriver.exe");
	}

	@Test
	public void createNewLeadBySelectingDifferrentLeadSourceFromDropDown() throws InterruptedException
	{
		WebDriverUtility wutil=new WebDriverUtility();
		//launch browser
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//get URL
		driver.get("http://localhost:8888");

		//login to the Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		//Navigate To Lead Page
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();

		//Create Lead Information
		WebElement leadInfo1=driver.findElement(By.name("salutationtype"));
		wutil.SelectOption(leadInfo1, "Mr.");
		driver.findElement(By.name("firstname")).sendKeys("Soumyasanta"+JavaUtility.getRandomData());
		driver.findElement(By.name("lastname")).sendKeys("Sahoo"+JavaUtility.getRandomData());
		driver.findElement(By.name("company")).sendKeys("TYSS"+JavaUtility.getRandomData());
		WebElement leadInfo2=driver.findElement(By.name("leadsource"));
		wutil.SelectOption(leadInfo2, "Employee");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Logout
		Actions act=new Actions(driver);
		WebElement logoutImage=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(logoutImage).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		//close the browser
		Thread.sleep(10000);
		driver.close();
	}

}
