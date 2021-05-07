package practice.ddt;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;

public class GetData {
	
	@Test
	public void getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility e=new ExcelUtility();
		String value=e.getExcelData("Sheet1", "TC_02", "FirstName");
		System.out.println(value);
	}

}
