package com.longwen.proxy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class LocalProxySelector extends ProxySelector {

	public LocalProxySelector() {
		// TODO Auto-generated constructor stub
	}
	
	private List<URI> failed = new ArrayList<URI>();

	@Override
	public List<Proxy> select(URI uri) {
		// TODO Auto-generated method stub
		List<Proxy> result = new ArrayList<Proxy>();
		if(failed.contains(uri)){
			result.add(Proxy.NO_PROXY);
		}else{
			SocketAddress proxyAddress = new InetSocketAddress("",1080);
			Proxy proxy = new Proxy(Proxy.Type.HTTP,proxyAddress);
			result.add(proxy);
		}
		return result;
	}

	@Override
	public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
		// TODO Auto-generated method stub
		failed.add(uri);

	}

}
