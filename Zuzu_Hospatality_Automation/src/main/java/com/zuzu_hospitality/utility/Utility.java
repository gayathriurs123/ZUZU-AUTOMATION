package com.zuzu_hospitality.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {
	public Object fetchPropertyValue(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("./Configuration/Config.properties");
		Properties property = new Properties();
		property.load(file);
		return property.get(key);
		
	}

}
