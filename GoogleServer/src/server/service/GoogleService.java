package server.service;

import server.data.UsuarioGoogle;
import server.dataUsuario.*;

public class GoogleService {

	public static GoogleService instance = null;

	public static GoogleService getInstance() {
		if (instance == null) {
			instance = new GoogleService();
		}
		return instance;
	}

	public boolean loginGoogle(String email, String contrasenia) {
		boolean acceso = false;
		for (UsuarioGoogle u : GoogleUsers.getInstance().getUsuarios()) {
			if (u.getEmail().equals(email) && u.getPass().equals(contrasenia)) {
				acceso = true;
			}
		}

		return acceso;
	}
	
	public boolean existeUsuario(String email) {
		boolean acceso = false;
		for (UsuarioGoogle u : GoogleUsers.getInstance().getUsuarios()) {
			if (u.getEmail().equals(email)) {
				acceso = true;
			}
		}

		return acceso;
	}

	public boolean registrarseGoogle(String username, String email, String pass, float peso, int altura) {
		if(!existeUsuario(email)) {
			UsuarioGoogle u = new UsuarioGoogle(username,email, pass, peso, altura);
			GoogleUsers.getInstance().getUsuarios().add(u);
			return true;
		}else {
			System.out.println("El usuario ya existe");
			return false;
		}
	}
}