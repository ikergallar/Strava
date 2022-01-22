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
	
	public void registro(String username, String email, String pass, float peso, int altura) {
		try {
			this.serviceLocator.getService().registro(username,email,pass,peso,altura);
		} catch (RemoteException e) {
			System.out.println("# Error during registro: " + e);
		}
	}
	
	public boolean existeUsuario(String username, String email) {
		boolean existe = false;	
		try {
			if(this.serviceLocator.getService().existeUsuario(username, email)){
				existe = true;
			}
		} catch (RemoteException e) {
			System.out.println("# Error during existeUsuario: " + e);
		}
		
		return existe;
		
	}
	
	public boolean getUserExt(String username, String email) {
		try {
			return this.serviceLocator.getService().getUserExt(username, email);
		} catch (RemoteException e) {
			System.out.println("# Error during existeUsuario: " + e);
			return false;
		}
		
		
	}
	
	public long getToken() {
		return token;
	}
	
	public boolean loginGoogle(String email, String pass) {
		try {
			this.serviceLocator.getService().loginGoogle(email, pass);	
			this.token=0;
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error during login Google: " + e);
			return false;
		}
	}
	
	public boolean loginFacebook(String email, String pass) {
		try {
			this.serviceLocator.getService().loginFacebook(email, pass);
			this.token=0;
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error during login Facebook: " + e);
			return false;
		}
	}
	
	public boolean registroGoogle(String username, String email, String pass, float peso, int altura) {
		try {
			this.serviceLocator.getService().registroGoogle(username, email, pass, peso, altura);
			return true;
		}catch(RemoteException e) {
			System.out.println("# Error during registro: " + e);
			return false;
		}
		
	}
	 public boolean registroFacebook(String username, String email, String pass, float peso, int altura) {
		 try {
			 this.serviceLocator.getService().registroFacebook(username, email, pass, peso, altura);
			 return true;
		 }catch(RemoteException e) {
			 System.out.println("# Error during registro: " + e);
			 return false;
		 }
	 }
}