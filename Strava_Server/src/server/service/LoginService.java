package server.service;

import java.rmi.RemoteException;

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
	
	public boolean existeUsuario(String username, String email) throws RemoteException {
		return UsuarioDAO.existeUsuario(username, email);
	}
	
	public String getUserTipo(String email) throws RemoteException {
		return UsuarioDAO.getUserTipo(email);
	}
	
	public boolean loginGoogle(String email, String pass) throws RemoteException {
		return GoogleGateway.getInstance().login(email, pass);
	}
	
	public boolean loginFacebook(String email, String pass) throws RemoteException {
		return FacebookGateway.getInstance().login(email, pass);
	}
	
	public void registro(String username, String email, String pass, float peso, int altura, String userExt)throws RemoteException {
		Usuario user = new Usuario();
		user.setUsername(username);
		user.setPass(pass);
		user.setEmail(email);
		user.setPeso(peso);
		user.setAltura(altura);
		user.setUsuarioExt(userExt);
				
		UsuarioDAO.getInstance().save(user);
	}
	
	public void registroGoogle(String username, String email, String pass, float peso, int altura)throws RemoteException {
		GoogleGateway.getInstance().registro(username, email, pass, peso, altura);;
	}
	
	public void registroFacebook(String username, String email, String pass, float peso, int altura) throws RemoteException{
		FacebookGateway.getInstance().registro(username, email, pass, peso, altura);;
	}
}