package server.service;

import java.rmi.RemoteException;

import server.data.domain.Usuario;
import server.gateway.FacebookGateway;
import server.gateway.GoogleGateway;

public class LoginService {
	
	private static LoginService instance;

	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		
		return instance;
	}

	public Usuario login(String email, String password) {
		Usuario user = new Usuario();		
		user.setEmail("aticus@gmail.com");
		user.setUsername("Aticus");		
		String pass =("123");		
		user.setPass(pass);
		
		if (user.getEmail().equals(email) && user.checkPassword(pass)) {		
			return user;
		} else {
			return null;
		}
	}
	
	public boolean loginGoogle(String email, String pass) throws RemoteException {
		return GoogleGateway.getInstance().loginGoogle(email, pass);
	}
	
	public boolean loginFacebook(String email, String pass) throws RemoteException {
		return FacebookGateway.getInstance().loginFacebook(email, pass);
	}
}