package server.remote;

import java.rmi.RemoteException;

import server.service.FacebookService;

public class FacebookRemote {
	
	private static final long serialVersionUID = 1L;
	public static FacebookRemote instance;

	
	private FacebookRemote() throws RemoteException {
		super();
	}
	
	public static FacebookRemote getInstance() {
		if (instance == null) {
			try {
				instance = new FacebookRemote();
			} catch(Exception ex) {
				System.err.println("  # Error initializing service(): " + ex.getMessage());
			}
		}
		
		return instance;
	}
	
	public boolean loginFacebook(String email, String pass) throws RemoteException {
		return FacebookService.getInstance().loginFacebook(email, pass);
	}

}
