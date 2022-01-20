package server.service;

import server.data.UsuarioFacebook;
import server.dataUsuario.FacebookUsers;

public class FacebookService {
	
public static FacebookService instance = null;
	
	public static FacebookService getInstance() {
		if (instance == null) {
			instance = new  FacebookService();
		}
		return instance;
	}
	
	public boolean loginFacebook(String email, String contrasenia) {
		boolean acceso = false;
		for(UsuarioFacebook u : FacebookUsers.getInstance().getUsuarios()) {
			if (u.getEmail().equals(email) && u.getPass().equals(contrasenia)) {
				acceso= true;
			}else {
				System.out.println("El usuario no existe");
			}
		}
		
		return acceso;
	}
	
	public void registrarseFacebook(String email, String contrasenia) {
		UsuarioFacebook u = new UsuarioFacebook(email, contrasenia);
		FacebookUsers.getInstance().getUsuarios().add(u);
	}

}
