package server.service;

import server.data.UsuarioGoogle;

public class GoogleService {

	public static GoogleService instance = null;
	
	public static GoogleService getInstance() {
		if (instance == null) {
			instance = new  GoogleService();
		}
		return instance;
	}
	
	public boolean loginGoogle(String email, String contrasenia) {
		UsuarioGoogle user = new UsuarioGoogle();		
		user.setEmail("xabster@gmail.com");
		String pass =("abcd");		
		user.setPass(pass);
		
		if (user.getEmail().equals(email) && user.checkPassword(pass)) {		
			return true;
		} else {
			return false;
		}
	}
}