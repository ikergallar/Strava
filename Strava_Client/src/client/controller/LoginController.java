package client.controller;

import java.rmi.RemoteException;

import client.serviceLocator.ServiceLocator;

public class LoginController {
	
	public ServiceLocator serviceLocator;
	private long token = -1;
	
	public LoginController(ServiceLocator servideLocator) {
		this.serviceLocator = servideLocator;
	}
	
	public LoginController(String[] args) throws RemoteException {
		serviceLocator = new ServiceLocator();
		serviceLocator.setService("127.0.0.1", "1099", "Strava");
	}
	public boolean login(String email, String pass) {
		try {
			this.token = this.serviceLocator.getService().login(email, pass);			
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error during login: " + e);
			this.token = -1;
			return false;
		}
	}
	public void logout() {
		try {
			this.serviceLocator.getService().logout(this.token);
			this.token = -1;
		} catch (RemoteException e) {
			System.out.println("# Error during logout: " + e);
		}
	}
	
	public long getToken() {
		return token;
	}
}