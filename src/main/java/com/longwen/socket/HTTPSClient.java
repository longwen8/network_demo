package com.longwen.socket;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class HTTPSClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        if(args.length==0){
        	System.out.println("Usage:java HTTPSClient2 host");
        	return;
        }
        
        int port = 443;
        String host = args[0];
        
        SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
        
        SSLSocket socket = null;
        
        
        try {
        	
        	//socket = (SSLSocket)
			
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        
	}

}
