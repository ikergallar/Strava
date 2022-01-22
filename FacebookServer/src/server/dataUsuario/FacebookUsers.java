package server.dataUsuario;

import java.util.ArrayList;

import server.data.UsuarioFacebook;


public class FacebookUsers {
	
	public static FacebookUsers instance = new FacebookUsers();
	public ArrayList<UsuarioFacebook> usuarios;
	
	public static FacebookUsers getInstance() {
		if (instance == null) {
			instance = new FacebookUsers();
		}
	
		return instance;
	}
	
	
	public FacebookUsers() {
		usuarios = new ArrayList<UsuarioFacebook>();
		
		UsuarioFacebook u1 = new UsuarioFacebook("tony","anton@gmail.com", "1234",0,0);
		UsuarioFacebook u2 = new UsuarioFacebook("falsi","falsificus@gmail.com", "1234",0,0);
		UsuarioFacebook u3 = new UsuarioFacebook("mini","minicoper@gmail.com", "1234",0,0);
		UsuarioFacebook u4 = new UsuarioFacebook("michobetis","misaga@gmail.com", "1234",0,0);
		
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		usuarios.add(u4);
		
	}
	
	public ArrayList<UsuarioFacebook> getUsuarios(){
		return usuarios;
		
	}	

}
