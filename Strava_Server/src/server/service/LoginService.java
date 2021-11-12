package server.service;

import server.data.domain.Usuario;

public class LoginService {

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
}