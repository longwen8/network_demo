package com.longwen.socket;

import java.net.ServerSocket;

public class LocalPortScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int port = 1 ; port <= 5535; port++){
			
			try {
				ServerSocket server = new ServerSocket(port);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("There is a server on port "+ port + ".");
			}
		}
	}

}
