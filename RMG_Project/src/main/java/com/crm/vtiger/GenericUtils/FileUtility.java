package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class FileUtility {
	
	/**
	 * This method used to read data from properties and return the value based on key specified
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String getPropertyKeyValue(String key) throws IOException
	{
		FileInputStream file=new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
		Properties p=new Properties();
		p.load(file);
		return p.getProperty(key);
	}
	
	/**
	 * This method will return Json value based on Json key
	 * @param jsonkey
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public String getDataFromJson(String jsonkey) throws IOException, ParseException
	{
		FileReader reader=new FileReader(IPathConstant.JSON_FILEPATH);
		JSONParser parser=new JSONParser();
		Object object=parser.parse(reader);
		JSONObject jsonObject=(JSONObject)object;
		String jsonValue=jsonObject.get(jsonkey).toString();
		return jsonValue;
	}

}
