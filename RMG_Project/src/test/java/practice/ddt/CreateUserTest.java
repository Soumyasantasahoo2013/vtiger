package practice.ddt;

import org.testng.annotations.Test;

public class CreateUserTest {
	
	@Test
	public void createUserTest()
	{
		String Username=System.getProperty("username");
		String Password=System.getProperty("password");
		String Browser=System.getProperty("browser");
		
		System.out.println("execute test1");
		System.out.println("========>"+Username);
		System.out.println("========>"+Password);
		System.out.println("========>"+Browser);
	}

}
