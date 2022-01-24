package server.service;

import server.data.UsuarioFacebook;
import server.dataUsuario.*;

public class FacebookService {

	public static FacebookService instance = null;

	public static FacebookService getInstance() {
		if (instance == null) {
			instance = new FacebookService();
		}
		return instance;
	}

	public boolean loginFacebook(String email, String contrasenia) {
		boolean acceso = false;
		for (UsuarioFacebook u : FacebookUsers.getInstance().getUsuarios()) {
			if (u.getEmail().equals(email) && u.getPass().equals(contrasenia)) {
				acceso = true;
			}
		}

		return acceso;
	}

	public boolean existeUsuario(String email) {
		boolean acceso = false;
		for (UsuarioFacebook u : FacebookUsers.getInstance().getUsuarios()) {
			if (u.getEmail().equals(email)) {
				acceso = true;
			}
		}

		return acceso;
	}
	
	public boolean registrarseFacebook(String username, String email, String pass, int peso, int altura) {
		if(!existeUsuario(email)) {
			UsuarioFacebook u = new UsuarioFacebook(username,email, pass, peso, altura);
			FacebookUsers.getInstance().getUsuarios().add(u);
			return true;
		}else {
			System.out.println("El usuario ya existe");
			return false;
		}
	}

}
