package practice.ddt;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateDynamicWebTable1 {
	
	static
	{
		System.setProperty("webdriver.chrome.driver", "C:\\HSSM40\\RMG_Project\\src\\main\\resources\\Drivers\\chromedriver.exe");
	}
	
	@Test
	public void clickOnAllCheckbox() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Step : 1 = Get URL
		driver.get("http://localhost:8888");
		
		//Step : 2 = Login to the Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step : 3 = navigate to Organizations
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step : 4 = Click on all checkbox
		String x="//table[@class='lvt small']/tbody/tr[*]/td[1]";
		List<WebElement> list=driver.findElements(By.xpath(x));
		
		for(WebElement wb:list)
		{
			wb.click();
		}
		
	}

}
