package server.dataUsuario;

import java.util.ArrayList;
import server.data.*;

public class GoogleUsers {

	public static GoogleUsers instance = new GoogleUsers();
	public ArrayList<UsuarioGoogle> usuarios;
	
	
	public static GoogleUsers getInstance() {
		if (instance == null) {
			instance = new GoogleUsers();
		}
	
		return instance;
	}

	public GoogleUsers() {
		usuarios = new ArrayList<UsuarioGoogle>();
		
		UsuarioGoogle u1 = new UsuarioGoogle("papa@gmail.com", "1234");
		UsuarioGoogle u2 = new UsuarioGoogle("xabster@gmail.com", "1234");
		UsuarioGoogle u3 = new UsuarioGoogle("galar@gmail.com", "1234");
		UsuarioGoogle u4 = new UsuarioGoogle("ranton@gmail.com", "1234");
		
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		usuarios.add(u4);
	}
	
	public ArrayList<UsuarioGoogle> getUsuarios(){
		return usuarios;
	}
}
