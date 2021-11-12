package client.serviceLocator;

import java.rmi.Naming;

import server.remote.IRemoteFa�ade;

public class ServiceLocator {
	
	private IRemoteFa�ade service;

	public void setService(String ip, String port, String serverName) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {		
			String URL = "//" + ip + ":" + port + "/" + serverName;
			this.service = (IRemoteFa�ade) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote fa�ade: " + ex);
		}		
	}

	public IRemoteFa�ade getService() {
		return this.service;
	}
}