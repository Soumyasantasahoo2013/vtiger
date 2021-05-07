
package practice.ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertiesFileTest {
	
	@Test
	public void readDataTest() throws IOException {
		// Read Data from Property File
		//Step-1 : Get the java representation object of the Physical File
		FileInputStream fis=new FileInputStream("./data/commonData.properties");
		
		//Step-2 : Create an object of the properties class & load all the Key value pair
		Properties p=new Properties();
		p.load(fis);
		
		//Step-3 : Read the value using getProperty("Key")
		String URL=p.getProperty("url");
		String Browser=p.getProperty("browser");
		String Platform=p.getProperty("platform");
		String Username=p.getProperty("username");
		String Password=p.getProperty("password");
		String Timeout=p.getProperty("timeout");
		
		System.out.println(URL);
		System.out.println(Browser);
		System.out.println(Platform);
		System.out.println(Username);
		System.out.println(Password);
		System.out.println(Timeout);
	}

}
