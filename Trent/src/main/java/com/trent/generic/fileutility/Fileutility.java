package com.trent.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class Fileutility {
	
	public String getdatafrompropertyfile(String key) throws Throwable {
		FileInputStream fis= new FileInputStream("./Configdata/trentcommondata.properties");
		Properties prop= new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
		
		
	}

}
