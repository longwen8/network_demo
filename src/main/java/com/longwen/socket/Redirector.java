package com.longwen.socket;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Redirector {

	private static final Logger logger = Logger.getLogger("Redirector");

	private final int port;

	private final String newSite;

	public Redirector(int port, String newSite) {
		super();
		this.port = port;
		this.newSite = newSite;
	}

	public void star() {
		try (ServerSocket server = new ServerSocket(port)) {
			logger.info("Redirecting connections on port" + server.getLocalPort() + "to" + newSite);

			while (true) {
				try {
					Socket s = server.accept();
					Thread t = new RedirectThread(s);
					t.start();

				} catch (IOException e) {
					// TODO: handle exception
					logger.warning("Exception accepting connection");
				} catch (RuntimeException ex) {
					// TODO: handle exception
					logger.log(Level.SEVERE, "Unexpected error", ex);
				}
			}

		} catch (BindException e) {
			// TODO: handle exception

		} catch (IOException ex) {

		}
	}

	private class RedirectThread extends Thread {

		private final Socket connection;

		public RedirectThread(Socket connection) {
			this.connection = connection;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

			try {
				Writer out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "US-ASCII"));

				Reader in = new InputStreamReader(new BufferedInputStream(connection.getInputStream()));

				StringBuilder request = new StringBuilder(80);

				while (true) {
					int c = in.read();
					if (c == '\r' || c == '\n' || c == -1) {
						break;
					}
					request.append((char) c);
				}

				String get = request.toString();
				String[] pieces = get.split("\\w*");
				String theFile = pieces[1];

				if (get.indexOf("HTTP/") != -1) {
					out.write("HTTP/1.0 302 FOUND\r\n");
					Date now = new Date();
					out.write("Date: " + now + "\r\n");
					out.write("Server :Redirector 1.1 \r\n");
					out.write("Location:" + newSite + theFile + "\r\n");
					out.write("Content-type:text/html\r\n\r\n");
					out.flush();
				}

				out.write("<HTML><HEAD><TITLE>Document moved</TITLE></HEAD>\r\n");
				out.write("<BODY><H1>Document moved</H1>\r\n");
				out.write("The document " + theFile + " has moved to \r\n<A HREF=\"" + newSite + theFile + "\">"
						+ newSite + theFile + "</A>.\r\n Please update your bookmarks<P>");
				out.write("</BODY></HTML>\r\n");
				out.flush();
				logger.log(Level.INFO, "Redirected " + connection.getRemoteSocketAddress());

			} catch (IOException ex) {
				logger.log(Level.WARNING, "Error writing to client", ex);
			} finally {
				// TODO: handle finally clause
				try {
					connection.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	public static void main(String[] args) {
		
		args=new String[2];
		args[0]="http://www.cafeconleche.org/";
		args[1]="82";
		int thePort;
		String theSite;
		try {
			theSite = args[0];
			
			if(theSite.endsWith("/")){
				theSite = theSite.substring(0, theSite.length()-1);
			}
			
		} catch (RuntimeException e) {
			// TODO: handle exception			
			System.out.println("");
			return;
		}
		try{
			thePort = Integer.parseInt(args[1]);
			
		}catch(RuntimeException ex){
			thePort = 80;
		}
		
		Redirector redirector = new Redirector(thePort,theSite);
		redirector.star();
	}

}
