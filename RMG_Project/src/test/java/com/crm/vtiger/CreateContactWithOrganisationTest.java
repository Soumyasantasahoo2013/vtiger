package com.crm.vtiger;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateContactWithOrganisationTest {

	static
	{
		System.setProperty("webdriver.chrome.driver", "C:\\HSSM40\\RMG_Project\\src\\main\\resources\\Drivers\\chromedriver.exe");
	}

	@Test
	public void createContactWithOrganisation() throws InterruptedException
	{
		//launch browser
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//get URL
		driver.get("http://localhost:8888");

		//login to the Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		//Navigate to Contacts
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Sahoo");
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		Set<String> window=driver.getWindowHandles();
		Iterator<String> iterator=window.iterator();
		while(iterator.hasNext())
		{
			String winId=iterator.next();
			driver.switchTo().window(winId);
			System.out.println(driver.getTitle());
			driver.findElement(By.linkText("TYSS321")).click();
		}
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
