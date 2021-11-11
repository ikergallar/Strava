package server.service;

import server.data.Usuario;
import server.db.DBManager;

public class LoginService {
	
	private static LoginService instance;
	
	private LoginService() { }
	
	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		
		return instance;
	}

	public Usuario login(String email, String password) {
		Usuario user = DBManager.getInstance().getUsuario(email);
		
		if (user != null && user.checkPassword(password)) {
			return user;
		} else {
			return null;
		}
	}
}