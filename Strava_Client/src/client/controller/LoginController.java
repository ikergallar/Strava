package client.controller;

import java.rmi.RemoteException;
import java.text.ParseException;

import client.serviceLocator.ServiceLocator;

public class LoginController {
	
	public ServiceLocator serviceLocator;

	public LoginController(ServiceLocator servideLocator) {
		this.serviceLocator = servideLocator;
	}
	
	public LoginController(String[] args) throws RemoteException {
		serviceLocator = new ServiceLocator();
		serviceLocator.setService("127.0.0.1", "1099", "Strava");
	}
	public boolean Login(String email, String nombre, String contra) throws RemoteException, ParseException {
		
		try {
			System.out.println(" * Client login Strava: " + email + "|| nombre:" + nombre);
			return serviceLocator.getService().login(email, contra);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean registrar(String correo, String nick, String contra) throws RemoteException, ParseException {
		System.out.println(" * Client register Strava: " + correo + "|| nombre:" + nick);
		return serviceLocator.getService().register(correo, nick, contra);
	}
}