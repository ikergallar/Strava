package server.service;

import server.data.UsuarioFacebook;

public class FacebookService {
	
public static FacebookService instance = null;
	
	public static FacebookService getInstance() {
		if (instance == null) {
			instance = new  FacebookService();
		}
		return instance;
	}
	
	public boolean loginFacebook(String email, String contrasenia) {
		UsuarioFacebook user = new UsuarioFacebook();		
		user.setEmail("misi@gmail.com");
		String pass =("1a2b");		
		user.setPass(pass);
		
		if (user.getEmail().equals(email) && user.checkPassword(pass)) {		
			return true;
		} else {
			return false;
		}
	}

}
