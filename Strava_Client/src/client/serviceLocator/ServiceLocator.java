package client.serviceLocator;

import java.rmi.Naming;

import server.remote.IStravaFa�ade;

public class ServiceLocator {
	
	private IStravaFa�ade service;

	public void setService(String ip, String port, String serverName) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {		
			String URL = "//" + ip + ":" + port + "/" + serverName;
			this.service = (IStravaFa�ade) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote fa�ade: " + ex);
		}		
	}

	public IStravaFa�ade getService() {
		return this.service;
	}
}