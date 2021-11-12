package client.serviceLocator;

import java.rmi.Naming;

import server.remote.IRemoteFaçade;

public class ServiceLocator {
	
	private IRemoteFaçade service;

	public void setService(String ip, String port, String serverName) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {		
			String URL = "//" + ip + ":" + port + "/" + serverName;
			this.service = (IRemoteFaçade) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote faï¿½ade: " + ex);
		}		
	}

	public IRemoteFaçade getService() {
		return this.service;
	}
}