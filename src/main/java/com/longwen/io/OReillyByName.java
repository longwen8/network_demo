package com.longwen.io;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class OReillyByName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			InetAddress ia= InetAddress.getByName("www.oreilly.com");
			
			System.out.println(ia.getCanonicalHostName());
			System.out.println(ia.isReachable(3000));
			/*byte[] bytes=InetAddress.getLocalHost().getAddress();
			for(byte b:bytes){
				System.out.println((int)b);
			}
			System.out.println(new String(bytes,"ISO-8859-1"));
			
			for(int i=0;i<1000;i++)
			{
				System.out.println(i+"<---->"+(byte)i);
			}*/
			
			
			//System.out.println(bytes);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
