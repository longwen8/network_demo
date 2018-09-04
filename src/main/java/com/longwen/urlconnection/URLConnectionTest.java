package com.longwen.urlconnection;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
        	URL url = new URL("https://www.baidu.com/");
        	URLConnection uc = url.openConnection();
        	System.out.println(uc.getClass());
        	System.out.println("contentType:"+uc.getContentType());
        	System.out.println("getContentLength:"+uc.getContentLength());
        	System.out.println("getContentEncoding:"+uc.getContentEncoding());
        	System.out.println("getDate:"+uc.getDate());
        	System.out.println("getLastModified:"+uc.getLastModified());
        	System.out.println("getExpiration:"+uc.getExpiration());
        	
        	
        	try(InputStream raw = uc.getInputStream()){
        		InputStream buffer = new BufferedInputStream(raw);
        		Reader reader =new InputStreamReader(buffer);
        		BufferedReader brd=new BufferedReader(reader);
        		
        		
        		int c;
        		while((c= reader.read())!= -1){
        			System.out.println((char)c);
        		}
        	}
        	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
