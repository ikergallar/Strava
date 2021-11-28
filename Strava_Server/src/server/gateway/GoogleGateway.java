package server.gateway;

import java.rmi.Naming;

import server.remote.IGoogleRemote;


public class GoogleGateway {
	

	private static GoogleGateway instance;
	private IGoogleRemote googleService;
		
	private GoogleGateway() {
		try {		
			String URL = "//127.0.0.1:1099/Login";
			this.googleService = (IGoogleRemote) Naming.lookup(URL);			} catch (Exception ex) {
			System.err.println("# Error locating remote fa�ade: " + ex);
		}
	}
		
	public static GoogleGateway getInstance() {
		if(instance == null) {
			instance = new GoogleGateway();
		}
			
		return instance;
	}
	

}
