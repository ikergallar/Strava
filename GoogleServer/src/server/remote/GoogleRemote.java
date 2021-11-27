package server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.service.GoogleService;

public class GoogleRemote extends UnicastRemoteObject implements IGoogleRemote {
	
	private static final long serialVersionUID = 1L;
	public static GoogleRemote instance;

	
	private GoogleRemote() throws RemoteException {
		super();
	}
	
	public static GoogleRemote getInstance() {
		if (instance == null) {
			try {
				instance = new GoogleRemote();
			} catch(Exception ex) {
				System.err.println("  # Error initializing service(): " + ex.getMessage());
			}
		}
		
		return instance;
	}
	
	@Override
	public boolean loginGoogle(String email, String contrasenia) throws RemoteException {
		return GoogleService.getInstance().loginGoogle(email, contrasenia);
	}


}
