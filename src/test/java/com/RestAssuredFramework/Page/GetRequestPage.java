package com.RestAssuredFramework.Page;

import java.io.FileInputStream;
import java.util.Properties;

import com.RestAssuredFramework.StepDefination.Base;
import com.RestAssuredFramework.Utility.Configuration;

public class GetRequestPage extends Base {

	
	Configuration con = new Configuration();
	public String getPro(String str)
	{
		return con.prop(str);
	}
}
