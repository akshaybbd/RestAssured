package com.RestAssuredFramework.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {
	Properties conf;
	FileInputStream fis;

	public Configuration() {
		File file = new File("./configuration/config.properties");
		try {
			fis = new FileInputStream(file);
			
			  conf = new Properties(); 
			  conf.load(fis);
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public  String prop(String str) {
		
		return 	conf.getProperty(str);
	}

}
