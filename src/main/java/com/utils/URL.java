package com.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.cts.hybrid.ConfigProvider.ConfigProvider;

public class URL {

	private static Logger log = LogManager.getLogger(URL.class.getName());
	public static final String URL = ConfigProvider.getAsString("url");
		 
		//"https://jsonplaceholder.typicode.com/posts/1";
		//https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
	
	public static String getEndPoint(){
		log.info("Base URI : " + URL);
		return URL;
	}
	
	public static String getEndPoint(String resource){
		log.info("URI End Point : " + URL + resource);
		return URL + resource;
	}	
}
