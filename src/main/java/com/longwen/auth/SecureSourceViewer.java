package com.longwen.auth;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;

public class SecureSourceViewer {

	public SecureSourceViewer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Authenticator.setDefault(new DialogAuthenticator());

		for (int i = 0; i < args.length; i++) {
			try {
				URL u = new URL(args[i]);

				try (InputStream in = new BufferedInputStream(u.openStream())) {
					Reader r = new InputStreamReader(in);
					int c;
					while ((c = r.read()) != -1) {
						System.out.print((char) c);
					}
				}
			} catch (MalformedURLException e) {
				// TODO: handle exception
				System.err.println(e);
			} catch (IOException e) {
				// TODO: handle exception
				System.err.println(e);
			}
			System.out.println();
		}
		
		System.exit(0);
	}

}
