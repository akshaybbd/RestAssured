package com.RestAssuredFramework.Page;

import com.RestAssuredFramework.StepDefination.Base;
import com.RestAssuredFramework.Utility.Configuration;

public class PostRequestPage extends Base {
	
	Configuration con = new Configuration();
	public String getPro(String str)
	{
		return con.prop(str);
	}

}
