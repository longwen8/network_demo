package com.longwen.io;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class NetworkInterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//NetworkInterface ni = NetworkInterface.getByName("lo0");
			//try {
				/*
				InetAddress local=InetAddress.getByName("127.0.0.1");
				NetworkInterface ni = NetworkInterface.getByInetAddress(local);

				System.out.println(ni);*/
				
				Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
				while(interfaces.hasMoreElements()){
					NetworkInterface ni= interfaces.nextElement();
					System.out.println(ni);
					Enumeration address = ni.getInetAddresses();
					while(address.hasMoreElements()){
						System.out.println(address.nextElement());
					}
				}
//			} catch (UnknownHostException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
