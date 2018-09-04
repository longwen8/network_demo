package com.longwen.proxy;

public class DMoz {

	public DMoz() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		String target = "";
		for(int i=0;i<args.length;i++){
			target += args[i]+ "";			
		}
		target = target.trim();
		
	}

}
