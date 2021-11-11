package client.serviceLocator;

import java.rmi.Naming;

import server.remote.IStravaFaçade;

public class ServiceLocator {
	
	private IStravaFaçade service;

	public void setService(String ip, String port, String serverName) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {		
			String URL = "//" + ip + ":" + port + "/" + serverName;
			this.service = (IStravaFaçade) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote faï¿½ade: " + ex);
		}		
	}

	public IStravaFaçade getService() {
		return this.service;
	}
}