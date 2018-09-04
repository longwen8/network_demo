package com.longwen.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class LastModified {
	
	private static String url="http://www.ibiblio.org/xml/";
	public static void main(String[] args) {
		
		try {
			URL u = new URL(url);
			Date date1=new Date();
			HttpURLConnection http = (HttpURLConnection)u.openConnection();
			//http.setRequestMethod("HEAD");
			
		
			
			
			System.out.println(url+" was last modified at "+new Date(http.getLastModified()));
			Date date2=new Date();
			System.out.println(date2.getTime()-date1.getTime());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
