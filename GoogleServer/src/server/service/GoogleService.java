package server.service;

import server.data.UsuarioGoogle;
import server.dataUsuario.*;

public class GoogleService {

	public static GoogleService instance = null;
	
	public static GoogleService getInstance() {
		if (instance == null) {
			instance = new  GoogleService();
		}
		return instance;
	}
	
	public boolean loginGoogle(String email, String contrasenia) {
		boolean acceso = false;
		for (UsuarioGoogle u : GoogleUsers.getInstance().getUsuarios()) {
			if (u.getEmail().equals(email) && u.getPass().equals(contrasenia)) {
				acceso= true;
			} else {
				System.out.println("El usuario no existe");
			} 
		}
		
		return acceso;
	}
	
	public void registrarseGoogle(String email, String contrasenia) {
		UsuarioGoogle u = new UsuarioGoogle(email, contrasenia);
		GoogleUsers.getInstance().getUsuarios().add(u);
	}
	
}