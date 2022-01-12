package server.service;

import java.rmi.RemoteException;
import java.util.List;

import server.data.dao.UsuarioDAO;
import server.data.domain.Usuario;
import server.data.dto.UsuarioDTO;
import server.gateway.FacebookGateway;
import server.gateway.GoogleGateway;

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
		Usuario user = UsuarioDAO.getInstance().find(email);
		if (user != null && user.checkPassword(password)) {
			return user;
		} else {
			return null;
		}
	}
	
	public boolean loginGoogle(String email, String pass) throws RemoteException {
		return GoogleGateway.getInstance().login(email, pass);
	}
	
	public boolean loginFacebook(String email, String pass) throws RemoteException {
		return FacebookGateway.getInstance().login(email, pass);
	}
	
	public void registro(String username, String pass, String email, float peso, int altura) {
		Usuario user = new Usuario();
		user.setUsername(username);
		user.setPass(pass);
		user.setEmail(email);
		user.setPeso(peso);
		user.setAltura(altura);
				
		UsuarioDAO.getInstance().save(user);
	}
	
}