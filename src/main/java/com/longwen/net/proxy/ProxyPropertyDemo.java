package com.longwen.net.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ProxyPropertyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProxyPropertyDemo demo = new ProxyPropertyDemo();
		String url="https://www.google.com";
		demo.setProxyProperty();
		demo.getURLData(url);

	}
	
	public void setProxyProperty(){
		
		System.setProperty("socksProxyHost","localhost");
		
		System.setProperty("socksProxyPort", "1080");
		
		  
		
	}
	
	public void getURLData(String url){
		try{
			URL  u = new URL(url);
			InputStream in = u.openStream();
			int c;
			while((c = in.read())!= -1){
				System.out.write(c);
			}
			  in.close();
		}catch(IOException ex){
			System.err.println(ex);
		}
	}

}
